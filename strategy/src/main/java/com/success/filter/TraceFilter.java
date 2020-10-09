package com.success.filter;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

import static javax.servlet.DispatcherType.*;

/**
 *  MDC (Mapped Diagnostic Context)   美[ˌdaɪəɡˈnɑːstɪk]
 *      映射诊断上下文
 * MDC顾名思义提供日志的上下文信息，通过MDC中的参数值区分输出的日志。
 *
 * SLF4J的MDC实质上就是一个Map。通常实现SLF4J的日志系统支持MDC，即表明该日志系统负责维护这个Map。应用就可以依赖于日志系统，直接存取key/value对到该Map中。
 *
 * 在SLF4J API中，也提供了MDC的默认实现类org.slf4j.MDC。如果实现SLF4J API的日志系统也支持MDC功能，则覆盖org.slf4j.MDC类。
 *
 * 目前，只有Log4j和Logback支持MDC功能
 */
//在SpringBootApplication上使用@ServletComponentScan注解后，Servlet、Filter、Listener可以直接通过@WebServlet、@WebFilter、@WebListener注解自动注册，无需其他代码
//如果SpringBootApplication上使用了@ServletComponentScan注解，就可以去掉@Component了
@Component
@WebFilter(filterName = "traceFilter", urlPatterns = "/*", dispatcherTypes = {REQUEST,
    FORWARD,INCLUDE,ASYNC,ERROR})
public class TraceFilter implements Filter {


    private static final String TRACE_ID = "traceId";
    private static final String RPC_ID = "rpcId";
    private static final String CLIENT_IP = "clientIp";
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try{
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String traceId = httpRequest.getHeader(TRACE_ID);
            if (traceId == null || traceId.length() == 0) {
                traceId= UUID.randomUUID().toString().replaceAll("-","");
            }
            MDC.put(TRACE_ID, traceId);

            String rpcId = httpRequest.getHeader(RPC_ID);
            if (rpcId == null || rpcId.length() == 0) {
                MDC.put(RPC_ID, rpcId);
            }

            MDC.put(CLIENT_IP, getClientIp(httpRequest));
        }catch(Exception ex){
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        MDC.remove(TRACE_ID);
        MDC.remove(RPC_ID);
        MDC.remove(CLIENT_IP);
    }

    private  String getClientIp(HttpServletRequest request) {
        if (request == null) {
            return "";
        }
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0) {
            ip = request.getRemoteAddr();
        }
        if (ip != null && ip.contains(",")) {
            ip = ip.split(",")[0];
        }
        if (ip != null) {
            int index = ip.indexOf(",");
            ip=(index > -1)? ip.substring(0, index) : ip;
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }
    
}

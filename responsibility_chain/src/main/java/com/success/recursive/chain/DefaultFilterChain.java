package com.success.recursive.chain;

import com.success.recursive.BaseReq;
import com.success.recursive.BaseRes;
import com.success.recursive.filter.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Title：过滤器链
 * @Author：wangchenggong
 * @Date 2021/1/25 14:20
 * @Description
 * @Version
 */
@Component
public class DefaultFilterChain implements FilterChain{

    private int index;

    @Autowired
    private List<Filter> filterList;

    @PostConstruct
    public void sortFilters(){
        if(!CollectionUtils.isEmpty(filterList)){
            Collections.sort(filterList, new Comparator<Filter>() {
                @Override
                public int compare(Filter o1, Filter o2) {
                    return o1.getWeight() - o2.getWeight();
                }
            });
        }
    }

    @Override
    public void doFilter(BaseReq baseReq, BaseRes baseRes) {

        if(index == filterList.size()){
            //过滤器逻辑执行完毕,重置index
            //TODO 这里可能存在并发问题
            index = 0;
            return;
        }

        Filter filter = filterList.get(index);
        index++;
        filter.doFilter(baseReq, baseRes, this);
    }


}

package com.success.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title：日志配置测试类
 * @Author：wangchenggong
 * @Date 2020/10/9 15:41
 * @Description
 * @Version
 */
@RestController
@RequestMapping("/log")
public class LogTestController {


    private static final Logger logger = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/test")
    public String test(@RequestParam(value = "level",required = false) String level){
        switch (level){
            case "debug":
                logger.debug("==========debug========");
                break;
            case "info":
                logger.info("*************info*************");
                break;
            case "warn":
                logger.warn("#############warn#############");
                break;
            case "error":
                logger.error("------------error------------");
                break;
            default:
                logger.info("------------default------------");
                break;
        }
        return level;
    }

}

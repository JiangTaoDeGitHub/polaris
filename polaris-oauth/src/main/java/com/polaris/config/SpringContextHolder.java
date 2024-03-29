package com.polaris.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     * 实现ApplicationContextAware接口的context注入函数，将其存入静态变量
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }
    /**
     * 去的存储在静态变量中的ApplicationContext
     */
    public static ApplicationContext getApplicationContext(){
        if (applicationContext == null){
            throw new IllegalStateException("applicaitonContext未注入,请在applicationContext-web.xml中注册SpringContextHolder" +
                    "或者在applicationContext.xml中配置扫描SpringContextHolder所在的包，然后给SpringContextHolder加上" +
                    "@Component注解");
        }
        return applicationContext;
    }
    /**
     * 从静态变量ApplicationContext取出bean，并为bean转型
     */
    public static <T> T getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }
}

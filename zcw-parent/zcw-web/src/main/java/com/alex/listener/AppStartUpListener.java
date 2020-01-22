package com.alex.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppStartUpListener implements ServletContextListener {
    Logger logger = LoggerFactory.getLogger(AppStartUpListener.class);
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("{}启动","AppStartUpListener");
        ServletContext servletContext = sce.getServletContext();
        //获取系统路径： /alex-web
        String contextPath = servletContext.getContextPath();
        servletContext.setAttribute("ctx",contextPath);
        logger.info("启动完成,访问路径是：{}",contextPath);
    }

    /**
     * 项目停止时调用
     * @param
     * @return
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

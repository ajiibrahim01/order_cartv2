package com.shop.infrastructure;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ApplicationContextListener
 *
 */
@WebListener
public class ApplicationContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	ServletContext ctx = sce.getServletContext();
    	String dbUrl = ctx.getInitParameter("jdbcUrl");
    	String dbUser = ctx.getInitParameter("jdbcUser");
    	String dbPass = ctx.getInitParameter("jdbcPass");
    	
    	DBUtils.setJdbcUrl(dbUrl);
    	DBUtils.setJdbcUser(dbUser);
    	DBUtils.setJdbcPass(dbPass);
    }
	
}

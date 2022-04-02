package com.gogakaka.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;
import java.util.EnumSet;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("onStartup!");
        FilterRegistration.Dynamic charaterEncodingFilter = servletContext.addFilter("charaterEncodingFilter", new CharacterEncodingFilter());
        charaterEncodingFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        charaterEncodingFilter.setInitParameter("encoding", "UTF-8");
        charaterEncodingFilter.setInitParameter("forceEncoding", "true");
        super.onStartup(servletContext);

    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // TODO Auto-generated method stub
        return new Class<?>[] {RootContextConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // TODO Auto-generated method stub
        return new Class<?>[] {ServletConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        // TODO Auto-generated method stub
        return new String[] {"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        //CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
        //characterEncodingFilter.setEncoding("UTF-8");

        //return new Filter[]{characterEncodingFilter};
        return null;
    }
}

package com.skypro.library.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


                    //  Настройка dispatcherServlet.
public class WebInitializerNew extends AbstractAnnotationConfigDispatcherServletInitializer {


    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ConfigBook.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

package com.zzs.demo.config;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	private static final Logger LOG = LoggerFactory.getLogger(MvcConfig.class);
	

    @Override
    /* 视图跳转控制器 */
    public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addRedirectViewController("/", "/login");
    	registry.addStatusController("/admin/**", HttpStatus.NOT_FOUND);
    	registry.addViewController("/login").setViewName("login");
    }
    
	/**
	 * 添加静态资源处理器
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		WebMvcConfigurer.super.addResourceHandlers(registry);
		// 通过 "/home.html" 请求, 来访问 /resource/static/home.html 静态资源
//	    registry.addResourceHandler("/home.html").addResourceLocations("classpath:/static/");

	}

	/**
	 * 匹配路由请求规则
	 */
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		WebMvcConfigurer.super.configurePathMatch(configurer);
//		    /*
//		     * 1.ServletMappings 设置的是 "/" 2.setUseSuffixPatternMatch默认设置为true,
//		     * 那么,"/user" 就会匹配 "/user.*",也就是说,"/user.html" 的请求会被 "/user" 的 Controller所拦截.
//		     * 3.如果该值为false,则不匹配
//		     */
//		    configurer.setUseSuffixPatternMatch(false);
//
//		    /*
//		     * setUseTrailingSlashMatch的默认值为true
//		     * 也就是说, "/user" 和 "/user/" 都会匹配到 "/user"的Controller
//		     */
//		    configurer.setUseTrailingSlashMatch(true);
	}
	
	/**
	 * 配置请求视图映射
	 * @return
	 */
  @Bean
  public InternalResourceViewResolver resourceViewResolver()
  {
      InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
      //请求视图文件的前缀地址
//      internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
//      //请求视图文件的后缀
//      internalResourceViewResolver.setSuffix(".jsp");
      return internalResourceViewResolver;
  }

  /**
   * 视图配置
   */
	   @Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
	     registry.viewResolver(resourceViewResolver()); 
	}
	
	   
}


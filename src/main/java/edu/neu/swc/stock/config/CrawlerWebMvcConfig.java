package edu.neu.swc.stock.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * <h1>MVC 配置类</h1>
 */
@Configuration
public class CrawlerWebMvcConfig extends WebMvcConfigurationSupport {
    /**
     * <h2>让 MVC 加载 Swagger 的静态资源</h2>
     * */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**").
                addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        super.addResourceHandlers(registry);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 允许跨域访问的路径
                .allowedOrigins("http://localhost:9000") // 允许跨域访问的源
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE") // 允许的请求方法类型
                .maxAge(168000) // 预检间隔时间
                .allowedHeaders("Auth-Token", "Content-Type", "Encrypt-Key", "industry-category", "business-data") // 允许头部设置
                .allowCredentials(true); // 是否允许发送cookie
    }
}

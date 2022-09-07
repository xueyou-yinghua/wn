package wn.Config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//匹配路径
                .allowCredentials(true)//允许凭证
                .allowedHeaders("*")//设置请求头
                .allowedMethods("GET","POST","DELETE","PUT")//请求方式
                .allowedOriginPatterns("*");
    }
}

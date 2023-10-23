package example.demo.config;


import example.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {
    // 注入拦截器
    private final LoginInterceptor loginInterceptor;

    public LoginConfig(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor) // 添加拦截器
                .addPathPatterns("/**") // 要拦截的请求路径
                .excludePathPatterns("/login"); // 不拦截的请求路径
    }
}

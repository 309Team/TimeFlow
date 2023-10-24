package TimeFlow.config;

import TimeFlow.controller.resolver.UserIdResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 参数解释器配置类
 */
@Configuration
public class ArgumentResolverConfig implements WebMvcConfigurer {

    private final UserIdResolver userIdResolver;

    public ArgumentResolverConfig(UserIdResolver userIdResolver) {
        this.userIdResolver = userIdResolver;
    }

    // 将参数解释器加入解释器中
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userIdResolver);
    }
}

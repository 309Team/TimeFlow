package TimeFlow.controller.resolver;

import TimeFlow.config.GetUserId;
import TimeFlow.util.JwtUtil;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class UserIdResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // 只有在参数前加了GetUserId才可以进行参数解析
        return parameter.hasParameterAnnotation(GetUserId.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        // 获取token
        String token = webRequest.getHeader("Authorization");

        // 在有token的情况下解析uid
        if (StringUtils.hasText(token)) {

            DecodedJWT decoded = JwtUtil.getToken(token);
            Integer uid = Integer.valueOf(decoded.getClaim("userId").asString());

            return uid;
        }

        return null; // 没有token，为空
    }
}

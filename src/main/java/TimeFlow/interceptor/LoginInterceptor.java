package TimeFlow.interceptor;


import TimeFlow.exception.LoginException;
import TimeFlow.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {


        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        // 获取请求头中的token
        String token = request.getHeader("Authorization");

        // 判断是否有token 没有则为未登录
        if (!StringUtils.hasText(token)) {
            throw new LoginException("当前未登录！");
        } else {
            // 验证token，正确则放行，否则抛出错误，由统一处理进行处理
            JwtUtil.verify(token);
        }
        return true;
    }
}

package TimeFlow.interceptor;


import TimeFlow.config.GetUserId;
import TimeFlow.exception.LoginException;
import TimeFlow.mapper.user.UserMapper;
import TimeFlow.pojo.User;
import TimeFlow.util.JwtUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class LoginInterceptor implements HandlerInterceptor {


    private final UserMapper userMapper;

    public LoginInterceptor(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

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
            DecodedJWT decoded = JwtUtil.getToken(token);
            Integer uid = Integer.valueOf(decoded.getClaim("userId").asString());
            User userByUid = userMapper.findUserByUid(uid);
            if (userByUid == null)
                throw new LoginException("没有该用户！");
        }
        return true;
    }
}

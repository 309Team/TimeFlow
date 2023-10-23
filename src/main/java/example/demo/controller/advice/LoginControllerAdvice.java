package example.demo.controller.advice;

import example.demo.exception.LoginException;
import example.demo.pojo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 验证登录token处理类
 */
@ControllerAdvice
public class LoginControllerAdvice {

    @ResponseBody
    @ExceptionHandler(LoginException.class)
    public Result handlerLoginException (LoginException e) {
        return Result.error(e.getMessage());
    }
}

package TimeFlow.controller.advice;

import TimeFlow.pojo.Result;
import TimeFlow.exception.LoginException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 验证登录token错误处理类
 */
@ControllerAdvice
public class LoginControllerAdvice {

    @ResponseBody
    @ExceptionHandler(LoginException.class)
    public Result handlerLoginException (LoginException e) {
        return Result.error(e.getMessage());
    }
}

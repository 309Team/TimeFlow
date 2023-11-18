package TimeFlow.controller.advice;

import TimeFlow.pojo.interact.Result;
import TimeFlow.exception.LoginException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 验证登录token错误处理类
 */
@RestControllerAdvice
public class LoginControllerAdvice {

    @ExceptionHandler({LoginException.class})
    public Result handlerLoginException (LoginException e) {
        return Result.error(4, e.getMessage());
    }
}

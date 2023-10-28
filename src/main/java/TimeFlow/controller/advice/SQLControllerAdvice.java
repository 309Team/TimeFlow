package TimeFlow.controller.advice;

import TimeFlow.pojo.interact.Result;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SQLControllerAdvice {

//    @ExceptionHandler({SQLException.class, SQLDataException.class})
    public Result SQLExceptionHandler(Exception e) {
        return Result.error(3, "数据处理失败");
    }
}

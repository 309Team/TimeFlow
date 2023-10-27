package TimeFlow.controller.advice;

import TimeFlow.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLDataException;
import java.sql.SQLException;

@RestControllerAdvice
public class SQLControllerAdvice {

//    @ExceptionHandler({SQLException.class, SQLDataException.class})
    public Result SQLExceptionHandler(Exception e) {
        return Result.error(3, "数据处理失败");
    }
}

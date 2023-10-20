package example.demo.pojo;

import lombok.Data;

@Data
public class Result {
    private ResultCode code;
    private String msg;
    private Object data;

    enum ResultCode {
        Success,
        Error
    }
    public Result(){
        msg = null;
        code = ResultCode.Success;
    }

    public Result(Integer code) {
        this.code = code == 1 ? ResultCode.Error : ResultCode.Success;
        msg = null;
    }

    public Result(Integer code, String msg) {
        this.code = code == 1 ? ResultCode.Error : ResultCode.Success;
        this.msg = msg;
    }

    public Result(Integer code, String msg, Object object) {
        this(code, msg);
        this.data = object;
    }

    public Result(Integer code, Object object) {
        this(code);
        this.data = object;
    }

}

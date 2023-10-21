package example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Boolean code; //Ture表示成功，False表示失败
    private String msg; //返回信息
    private Object data; //返回对象列表

    /**
     * 成功返回(有数据返回)
     * @param data 返回对象数据
     * @return Result对象
     *
     */
    static public Result success(Object data) {
        return new Result(true, "Success", data);
    }

    /**
     * 成功返回(无数据返回)
     * @return Result对象
     */
    static public Result success() {
        return new Result(true, "Success", null);
    }

    /**
     * 错误返回
     * @param msg 错误信息
     * @return Result对象
     */
    static  public Result error(String msg) {
        return new Result(false, msg, null);
    }

}

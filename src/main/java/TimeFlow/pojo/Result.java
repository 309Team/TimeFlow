package TimeFlow.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code; //0表示成功，其他表示失败
	private String msg; //返回信息
	private Object data; //返回对象列表

	/**
	 * 成功返回(有数据返回)
	 *
	 * @param data 返回对象数据
	 * @return Result对象
	 */
	static public Result success(Object data) {
        return new Result(0, "Success", data);
	}

	/**
	 * 成功返回(无数据返回)
	 *
	 * @return Result对象
	 */
	static public Result success() {
        return new Result(0, "Success", null);
	}

	/**
	 * 错误返回
	 *
	 * @param msg 错误信息
	 * @return Result对象
	 */
	static public Result error(String msg) {
        return new Result(1, msg, null);
	}

    /**
     * 错误返回（自定义代码）
     *
     * @param code 错误码
     * @param msg  错误信息
     * @return Result对象
     */
    static public Result err(Integer code, String msg) {
        return new Result(code, msg, null);
    }

}

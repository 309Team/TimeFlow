package TimeFlow.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String name;//用户名
	private Integer uid;//用户id
	private String password;//用户密码
}

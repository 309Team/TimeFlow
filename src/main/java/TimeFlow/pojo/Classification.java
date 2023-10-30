package TimeFlow.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 时段事项分类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classification {
	private Integer id;
	private String name;
	private String text;
}

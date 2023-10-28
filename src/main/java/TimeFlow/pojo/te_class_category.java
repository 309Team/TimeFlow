package TimeFlow.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class te_class_category {
	private Integer id;//关系映射id
	private Integer id_event;//事项id
	private Integer id_class;//类别id
}

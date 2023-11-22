package TimeFlow.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
public class LabelEvent {
	private Integer id; //事件id
	private String name; //事项名称
	private LocalDate attachDate; //事项附着日期
//	private List<Integer> inCategory; //所属类别
	private boolean setInViewPage; //是否纳入视图统计（无痕事件）
	private String text; //文本内容（事项注释）
	private boolean completed; // 事件是否完成
}

package TimeFlow.pojo.interact;

import TimeFlow.pojo.Classification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassStatistic {
	private int duration;//占用分钟数
    private Classification cls;

}

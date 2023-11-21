package TimeFlow.pojo.interact;

import TimeFlow.pojo.Classification;
import TimeFlow.pojo.TimeEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventStatistic {
	private int duration;//占用分钟数
	private TimeEvent TEvent;
}

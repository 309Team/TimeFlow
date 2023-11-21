package TimeFlow.service.interf.statistic;

import TimeFlow.pojo.interact.ClassStatistic;
import TimeFlow.pojo.interact.EventStatistic;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


public interface StatisticService {
	List<ClassStatistic> getClsStatistic(Integer uid, String startTime, String overTime);

	List<EventStatistic> getEvtStatistic(Integer uid, String startTime, String overTime);

}

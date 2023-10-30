package TimeFlow.service.interf.statistic;

import TimeFlow.pojo.interact.ClassStatistic;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;



public interface StatisticService {
	List<ClassStatistic> list(Integer uid, HashMap<String, String> D);
}

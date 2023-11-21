package TimeFlow.mapper.statistic;

import TimeFlow.pojo.Classification;
import TimeFlow.pojo.TimeEvent;
import TimeFlow.pojo.interact.EventStatistic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticMapper {


	List<Classification> listclass(String tableName);

	List<TimeEvent> listevent(String tableName, String midTabName, String startTime, String overTime, Integer id);

	Classification findClass(String midTabName, Integer eid, Integer cid);


	List<TimeEvent> findEvent(String tableName, String startTime,String overTime);



}

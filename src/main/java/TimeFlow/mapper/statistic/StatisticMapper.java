package TimeFlow.mapper.statistic;

import TimeFlow.pojo.TEClassification;
import TimeFlow.pojo.TimeEvent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author:你的名字
 * @Description:
 * @params:$
 * @return: $
 * @Date: 2023/10/30/11:37
 */

@Mapper
public interface StatisticMapper {


	List<TEClassification> listclass(String tableName);

	List<TimeEvent> listevent(String tableName, String midTabName, String startTime, String overTime, Integer id);

	TEClassification findClass(String midTabName,Integer eid,  Integer cid);
}

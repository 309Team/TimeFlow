package TimeFlow.controller.statistic;

import TimeFlow.config.GetUserId;
import TimeFlow.pojo.MomentEvent;
import TimeFlow.pojo.interact.ClassStatistic;
import TimeFlow.pojo.interact.Result;
import TimeFlow.service.interf.statistic.StatisticService;
import TimeFlow.util.TableNameUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/sta")
public class StatisticController {

	@Autowired
	private StatisticService STAService;

	@GetMapping()
	public Result list(@GetUserId Integer uid, @RequestBody HashMap<String, String> D) {

//		List<ClassStatistic> MEList = STAService.list(TableNameUtil.getTEName(uid),TableNameUtil.getTECLName() D.get("dateSTR"));
//		return Result.success(MEList);
	return null;
	}


}

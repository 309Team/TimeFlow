package TimeFlow.controller.statistic;

import TimeFlow.config.GetUserId;
import TimeFlow.pojo.interact.ClassStatistic;
import TimeFlow.pojo.interact.EventStatistic;
import TimeFlow.pojo.interact.Result;
import TimeFlow.service.interf.statistic.StatisticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/sta")
@CrossOrigin
public class StatisticController {

    @Autowired
    private StatisticService STAService;

    @GetMapping("/cls/{startTime}/{overTime}")
    public Result getClsStatistic(@GetUserId Integer uid, @PathVariable("startTime") String startTime,@PathVariable("overTime") String overTime) {
        List<ClassStatistic> list = STAService.getClsStatistic(uid, startTime,overTime);
        return Result.success(list);
    }

    @GetMapping("/evt/{startTime}/{overTime}")
    public Result getEvtStatistic(@GetUserId Integer uid, @PathVariable("startTime") String startTime,@PathVariable("overTime") String overTime) {
        List<EventStatistic> list = STAService.getEvtStatistic(uid, startTime,overTime);
        return Result.success(list);
    }

}

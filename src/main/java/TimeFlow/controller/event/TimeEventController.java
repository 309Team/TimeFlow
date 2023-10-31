package TimeFlow.controller.event;


import TimeFlow.config.GetUserId;
import TimeFlow.pojo.TimeEvent;
import TimeFlow.pojo.interact.Result;
import TimeFlow.service.interf.classification.ClassCategoryService;
import TimeFlow.service.interf.event.TimeEventService;
import TimeFlow.util.TableNameUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/event/te")
@CrossOrigin
public class TimeEventController {

    private final TimeEventService TEService;

    private final ClassCategoryService classCategoryService;

    public TimeEventController(TimeEventService TEService, ClassCategoryService classCategoryService) {
        this.TEService = TEService;
        this.classCategoryService = classCategoryService;
    }


    @GetMapping()
    public Result list(@GetUserId Integer uid, @RequestBody HashMap<String, String> D) {
        List<TimeEvent> TEList = TEService.list(TableNameUtil.getTEName(uid), D.get("dateSTR"));
        return Result.success(TEList);
    }

    @PostMapping()
    public Result add(@GetUserId Integer uid, @RequestBody TimeEvent newTE) {
        TEService.add(TableNameUtil.getTEName(uid), newTE);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@GetUserId Integer uid, @RequestBody HashMap<String, Integer> D) {
        TEService.delete(uid, D.get("id"));
        return Result.success();
    }

    @PatchMapping()
    public Result update(@GetUserId Integer uid, @RequestBody TimeEvent newTE) {
        TEService.update(TableNameUtil.getTEName(uid), newTE);
        return Result.success();
    }


    /**
     * 根据分类查事项
     *
     * @param uid 用户id
     * @param map "cid":[] 分类id List
     * @return 事项列表
     */
    @GetMapping("/class")
    Result listEventsOfClass(@GetUserId Integer uid, @RequestBody Map<String, List<Integer>> map) {
        List<Integer> cid = map.get("cid");
        // 获得符合的id
        List<Integer> eventIds = classCategoryService.listEventsByClass(uid, cid);

        // 从TE中获得事项
        return Result.success(TEService.listByClass(uid, eventIds));
    }
}

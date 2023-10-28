package TimeFlow.controller.event;


import TimeFlow.config.GetUserId;
import TimeFlow.pojo.LabelEvent;
import TimeFlow.pojo.interact.Result;
import TimeFlow.service.interf.event.LabelEventService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;


@RestController
public class LabelEventController {

    private final LabelEventService labelEventService;

    public LabelEventController(LabelEventService labelEventService) {
        this.labelEventService = labelEventService;
    }

    // 获得所有标签事件
    @GetMapping("/getAllLabelEvent")
    public Result getAllLabelEvent(@GetUserId Integer uid) {
        return Result.success(labelEventService.findAll(uid));
    }

    @GetMapping("/getDateLabelEvent")
    public Result getDateLabelEvent(@GetUserId Integer uid,
                                    @RequestBody HashMap<String, String> date) {

        // 对前端日期进行转换为LocalDate
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date.get("date"), fmt);

        // 进行查询
        return Result.success(labelEventService.findDate(uid, localDate));
    }

    @PostMapping("/addLabelEvent")
    public Result addLabelEvent(@GetUserId Integer uid, @RequestBody LabelEvent labelEvent) {
        labelEventService.labelEventInsert(uid, labelEvent);
        return Result.success();
    }

    @DeleteMapping("/deleteLE/{eid}")
    public Result deleteLabelEvent(@GetUserId Integer uid, @PathVariable Integer eid) {
        if (labelEventService.labelEventDelete(uid, eid) != 0)
            return Result.success();
        else
            return Result.error("表中无数据");
    }

    @PostMapping("/updateLE")
    public Result updateLabelEvent(@GetUserId Integer uid, @RequestBody LabelEvent labelEvent) {
        return labelEventService.labelEventUpdate(uid, labelEvent) == 0 ?
                Result.error("修改失败") : Result.success();
    }
}

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
@RequestMapping("/event/le")
@CrossOrigin
public class LabelEventController {

    private final LabelEventService labelEventService;

    public LabelEventController(LabelEventService labelEventService) {
        this.labelEventService = labelEventService;
    }

    // 获得所有标签事件
    @GetMapping
    public Result getAllLabelEvent(@GetUserId Integer uid) {
        return Result.success(labelEventService.findAll(uid));
    }

    @GetMapping("/{date}")
    public Result getDateLabelEvent(@GetUserId Integer uid,
                                    @PathVariable String date) {

        // 对前端日期进行转换为LocalDate
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, fmt);

        // 进行查询
        return Result.success(labelEventService.findDate(uid, localDate));
    }

    @PostMapping()
    public Result addLabelEvent(@GetUserId Integer uid, @RequestBody LabelEvent labelEvent) {
        labelEventService.labelEventInsert(uid, labelEvent);
        return Result.success();
    }

    @DeleteMapping("/{eid}")
    public Result deleteLabelEvent(@GetUserId Integer uid, @PathVariable Integer eid) {
        if (labelEventService.labelEventDelete(uid, eid) != 0)
            return Result.success();
        else
            return Result.error("表中无数据");
    }

    @PatchMapping()
    public Result updateLabelEvent(@GetUserId Integer uid, @RequestBody LabelEvent labelEvent) {
        return labelEventService.labelEventUpdate(uid, labelEvent) == 0 ?
                Result.error("修改失败") : Result.success();
    }

    @GetMapping("/month/{date}")
    public Result getMonthLabelEvent(@GetUserId Integer uid, @PathVariable String date) {
        // 对前端日期进行转换为LocalDate
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, fmt);

        HashMap<String, Integer> result = labelEventService.countLabelEventByMonth(uid, localDate);
        return Result.success(result);
    }

    @GetMapping("/year/{date}")
    public Result getYearLabelEvent(@GetUserId Integer uid, @PathVariable String date) {
        // 对前端日期进行转换为LocalDate
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, fmt);

        HashMap<String, Integer> result = labelEventService.countLabelEventByYear(uid, localDate);
        return Result.success(result);
    }
}

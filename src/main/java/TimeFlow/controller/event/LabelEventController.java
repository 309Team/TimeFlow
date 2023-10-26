package TimeFlow.controller.event;


import TimeFlow.config.GetUserId;
import TimeFlow.pojo.LabelEvent;
import TimeFlow.pojo.Result;
import TimeFlow.service.interf.event.LabelEventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}

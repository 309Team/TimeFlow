package TimeFlow.controller.event;


import TimeFlow.config.GetUserId;
import TimeFlow.pojo.LabelEvent;
import TimeFlow.pojo.Result;
import TimeFlow.service.interf.event.LabelEventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LabelEventController {

    private final LabelEventService labelEventService;

    public LabelEventController(LabelEventService labelEventService) {
        this.labelEventService = labelEventService;
    }

    @GetMapping("/getAllLabelEvent")
    public Result getAllLabelEvent(@GetUserId Integer uid) {
        return Result.success(labelEventService.findAll(uid));
    }
}

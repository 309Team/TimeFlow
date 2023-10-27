package TimeFlow.controller.event;


import TimeFlow.config.GetUserId;
import TimeFlow.pojo.Result;
import TimeFlow.service.interf.event.ClassificationService;
import TimeFlow.service.interf.event.MomentEventService;
import TimeFlow.util.TableNameUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/cls")
public class ClassificationController {

	@Autowired
	private ClassificationService CService;

	@GetMapping()
	public Result list(@GetUserId Integer uid){
		return Result.success(CService.list(TableNameUtil.getCLName(uid)));
	}

}

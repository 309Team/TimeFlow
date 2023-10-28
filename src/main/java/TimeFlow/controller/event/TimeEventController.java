package TimeFlow.controller.event;


import TimeFlow.config.GetUserId;
import TimeFlow.pojo.MomentEvent;
import TimeFlow.pojo.TimeEvent;
import TimeFlow.pojo.interact.Result;
import TimeFlow.service.interf.event.TimeEventService;
import TimeFlow.util.TableNameUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/te")
@Controller
public class TimeEventController {

	@Autowired
	private TimeEventService TEService;


	@GetMapping()
	public Result list(@GetUserId Integer uid, @RequestBody HashMap<String, String> D ) {
		List<TimeEvent> TEList = TEService.list(TableNameUtil.getTEName(uid), D.get("dateSTR"));
		return Result.success(TEList);
	}

	@PostMapping()
	public Result add(@GetUserId Integer uid, @RequestBody TimeEvent newTE){
		TEService.add(TableNameUtil.getTEName(uid) ,newTE);
		return Result.success();
	}

	@DeleteMapping
	public Result delete(@GetUserId Integer uid, @RequestBody HashMap<String,Integer> D){
		TEService.delete(TableNameUtil.getTEName(uid), D.get("id"));
		return Result.success();
	}

	@PatchMapping()
	public Result update(@GetUserId Integer uid, @RequestBody TimeEvent newTE){
		TEService.update(TableNameUtil.getTEName(uid) ,newTE);
		return Result.success();
	}

}

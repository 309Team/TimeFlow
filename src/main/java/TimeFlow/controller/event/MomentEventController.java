package TimeFlow.controller.event;


import TimeFlow.config.GetUserId;
import TimeFlow.pojo.MomentEvent;
import TimeFlow.pojo.TimeEvent;
import TimeFlow.pojo.interact.Grouping;
import TimeFlow.pojo.interact.Result;
import TimeFlow.service.interf.event.MomentEventService;
import TimeFlow.util.TableNameUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/event/me")
@CrossOrigin
public class MomentEventController {

	@Autowired
	private MomentEventService MEService;


	@GetMapping("/{dateSTR}")
	public Result list(@GetUserId Integer uid, @PathVariable("dateSTR") String dateSTR) {
//		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate date = LocalDate.parse(D.get("dateSTR"), fmt);
		List<MomentEvent> MEList = MEService.list(TableNameUtil.getMEName(uid), dateSTR);
		MEList.sort(new Comparator<MomentEvent>() {
			@Override
			public int compare(MomentEvent o1, MomentEvent o2) {
				return o1.getDeadline().compareTo(o2.getDeadline());
			}
		});
		return Result.success(MEList);
	}

	@PostMapping()
	public Result add(@GetUserId Integer uid, @RequestBody MomentEvent newME){
		MEService.add(TableNameUtil.getMEName(uid) ,newME);
		return Result.success();
	}

	@DeleteMapping()
	public Result delete(@GetUserId Integer uid, @RequestBody HashMap<String,Integer> D){
		MEService.delete(TableNameUtil.getMEName(uid), D.get("id"));
		return Result.success();
	}

	@PatchMapping()
	public Result update(@GetUserId Integer uid, @RequestBody MomentEvent newME){
		MEService.update(TableNameUtil.getMEName(uid) ,newME);
		return Result.success();
	}



}


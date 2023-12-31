package TimeFlow.controller.event;


import TimeFlow.config.GetUserId;
import TimeFlow.pojo.TimeEvent;
import TimeFlow.pojo.interact.Result;
import TimeFlow.service.interf.classification.ClassCategoryService;
import TimeFlow.service.interf.event.TimeEventService;
import TimeFlow.util.TableNameUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

	@GetMapping("/getday/{dateSTR}")
	public Result getday(@GetUserId Integer uid, @PathVariable("dateSTR") String dateSTR) {
		List<TimeEvent> TEList = TEService.getday(TableNameUtil.getTEName(uid), dateSTR);
		TEList.sort(new Comparator<TimeEvent>() {
			@Override
			public int compare(TimeEvent o1, TimeEvent o2) {
				return o1.getStartTime().compareTo(o2.getStartTime());
			}
		});
		return Result.success(TEList);
	}

	@GetMapping("/{dateSTR}")
	public Result list(@GetUserId Integer uid, @PathVariable("dateSTR") String dateSTR) {
		List<TimeEvent> TEList = TEService.list(TableNameUtil.getTEName(uid), dateSTR);
		TEList.sort(new Comparator<TimeEvent>() {
			@Override
			public int compare(TimeEvent o1, TimeEvent o2) {
				return o1.getStartTime().compareTo(o2.getStartTime());
			}
		});
		return Result.success(TEList);
	}

	@PostMapping()
	public Result add(@GetUserId Integer uid, @RequestBody TimeEvent newTE) {
		TEService.add(TableNameUtil.getTEName(uid), newTE);
		return Result.success(newTE);
	}

	@DeleteMapping("/{eid}")
	public Result delete(@GetUserId Integer uid, @PathVariable Integer eid) {
		TEService.delete(uid, eid);

		return Result.success();
	}

	@PatchMapping()
	public Result update(@GetUserId Integer uid, @RequestBody TimeEvent newTE) {
		TEService.update(TableNameUtil.getTEName(uid), newTE);
		return Result.success();
	}

	@GetMapping("/month/{dateSTR}")
	public Result getDayNum(@GetUserId Integer uid, @PathVariable("dateSTR") String dateSTR) {
		return Result.success(TEService.getDayNum(TableNameUtil.getTEName(uid), dateSTR));
	}


	@GetMapping("/year/{dateSTR}")
	public Result getmouthnum(@GetUserId Integer uid, @PathVariable("dateSTR") String dateSTR) {
		return Result.success(TEService.getMonthNum(TableNameUtil.getTEName(uid), dateSTR));
	}


	/**
	 * 根据分类查事项
	 *
	 * @param uid 用户id
	 * @param map "cid":[] 分类id List
	 * @return 事项列表
	 */
	@PostMapping("/getclass")
	Result listEventsOfClass(@GetUserId Integer uid, @RequestBody Map<String, List<Integer>> map) {
		List<Integer> cid = map.get("cid");
		// 获得符合的id
		List<Integer> eventIds = classCategoryService.listEventsByClass(uid, cid);

		// 从TE中获得事项
		return eventIds.isEmpty() ? Result.success(new ArrayList<TimeEvent>()) : Result.success(TEService.listByClass(uid, eventIds));
	}
}

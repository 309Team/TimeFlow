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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
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
		return Result.success();
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
	public Result getdaynum(@GetUserId Integer uid, @PathVariable("dateSTR") String dateSTR) {
		HashMap<String, Integer> RESULT = new HashMap<>();

		List<TimeEvent> TEList = TEService.getdaynum(TableNameUtil.getTEName(uid), dateSTR);

		for (TimeEvent te : TEList) {
			String MouthSTR = te.getStartTime().getYear() + "-" +
					te.getStartTime().getMonthValue() + "-" +
					te.getStartTime().getDayOfMonth();
			if (RESULT.get(MouthSTR) == null) {
				RESULT.put(MouthSTR, 1);
			} else
				RESULT.replace(MouthSTR, RESULT.get(MouthSTR) + 1);
		}
		return Result.success(RESULT);
	}


	@GetMapping("/year/{dateSTR}")
	public Result getmouthnum(@GetUserId Integer uid, @PathVariable("dateSTR") String dateSTR) {
		HashMap<String, Integer> RESULT = new HashMap<>();

		List<TimeEvent> TEList = TEService.getmouthnum(TableNameUtil.getTEName(uid), dateSTR);



		for (TimeEvent te : TEList) {
			String MonthValue = String.valueOf(te.getStartTime().getMonthValue());
			if (RESULT.get(MonthValue) == null) {
				RESULT.put(MonthValue, 1);
			} else
				RESULT.replace(MonthValue, RESULT.get(MonthValue) + 1);
		}
		return Result.success(RESULT);
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

package TimeFlow.service.interf.event;


import TimeFlow.pojo.LabelEvent;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public interface LabelEventService {
    List<LabelEvent> findAll(Integer uid);

    List<LabelEvent> findDate(Integer uid, LocalDate date);

    long labelEventInsert(Integer uid, LabelEvent labelEvent);

    long labelEventDelete(Integer uid, Integer eid);

    long labelEventUpdate(Integer uid, LabelEvent labelEvent);

    HashMap<String, Integer> CountLabelEventByMonth(Integer uid, LocalDate date);
}

package TimeFlow.service.interf.event;


import TimeFlow.pojo.LabelEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface LabelEventService {
    List<LabelEvent> findAll(Integer uid);

    List<LabelEvent> findDate(Integer uid, LocalDate date);

    long labelEventInsert(Integer uid, LabelEvent labelEvent);

    long labelEventDelete(Integer uid, Integer eid);
}

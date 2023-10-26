package TimeFlow.service.interf.event;


import TimeFlow.pojo.LabelEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface LabelEventService {
    List<LabelEvent> findAll(Integer uid);

    List<LabelEvent> findDate(Integer uid, LocalDate date);

    void labelEventInsert(Integer uid, LabelEvent labelEvent);
}

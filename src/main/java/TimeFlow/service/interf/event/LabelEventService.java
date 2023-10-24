package TimeFlow.service.interf.event;


import TimeFlow.pojo.LabelEvent;

import java.util.List;

public interface LabelEventService {
    List<LabelEvent> findAll(Integer uid);
}

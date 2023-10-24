package TimeFlow.service.impl.event;


import TimeFlow.mapper.event.LabelEventMapper;
import TimeFlow.pojo.LabelEvent;
import TimeFlow.service.interf.event.LabelEventService;
import TimeFlow.util.TableNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelEventServiceImp implements LabelEventService {

    private final LabelEventMapper labelEventMapper;

    public LabelEventServiceImp(LabelEventMapper labelEventMapper) {
        this.labelEventMapper = labelEventMapper;
    }

    @Override
    public List<LabelEvent> findAll(Integer uid) {
        return labelEventMapper.findAll(TableNameUtil.getLEName(uid));
    }
}

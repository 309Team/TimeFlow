package TimeFlow.service.impl.event;

import TimeFlow.mapper.event.MomentEventMapper;
import TimeFlow.pojo.MomentEvent;
import TimeFlow.service.interf.event.MomentEventService;
import TimeFlow.util.TableNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

@Service
public class MomentEventServiceImp implements MomentEventService {

    @Autowired
    private MomentEventMapper MEMapper;

    @Override
    public List<MomentEvent> list(String tableName, String date) {
        return MEMapper.list(tableName, date);
    }

    @Override
    public void add(String tableName, MomentEvent newME) {
        MEMapper.add(tableName, newME);
        return;
    }

    @Override
    public void delete(String tableName, Integer id) {
        MEMapper.delete(tableName, id);
    }

    @Override
    public void update(String tableName, MomentEvent newME) {
        MEMapper.update(tableName, newME);
    }

    @Override
    public HashMap<String, Integer> CountMomentEventByMonth(Integer uid, LocalDate date) {
        List<MomentEvent> momentEvents = MEMapper.CountMomentEventByMonth(date, TableNameUtil.getMEName(uid));

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String localDateStr = date.format(fmt);

        HashMap<String, Integer> result = new HashMap<>();
        for (MomentEvent event : momentEvents) {
            String format = event.getDeadline().format(fmt);
            if (result.containsKey(format)) {
                result.put(format, result.get(format) + 1);
            } else {
                result.put(format, 1);
            }
        }

        return result;
    }
}

package TimeFlow.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class TimeEvent {
    private Integer id; //事件id
    private String name; //事项名称
    private LocalDateTime startTime; //事项开始时间
    private LocalDateTime overTime; //事项结束时间
//    private Duration duration; //时间差
//    private List<Integer> inCategory; //所属类别
    private boolean setInViewPage; //是否纳入日视图统计（无痕事件）
    private String text; //文本内容（事项注释）
    private boolean isCompleted; //事件是否完成
}

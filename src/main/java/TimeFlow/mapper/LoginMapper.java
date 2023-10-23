package TimeFlow.mapper;

import TimeFlow.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    User login(User user);
}

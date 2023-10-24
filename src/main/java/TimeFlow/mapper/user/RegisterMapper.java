package TimeFlow.mapper.user;

import TimeFlow.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RegisterMapper {
    Integer userRegister(User user);

    User findUser(User user);

    Integer createTETable(@Param("tableName") String tableName);

    Integer createMETable(@Param("tableName") String tableName);

    Integer createLETable(@Param("tableName") String tableName);

}

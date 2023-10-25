package TimeFlow.mapper.user;

import TimeFlow.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    // 通过uid查找用户
    User findUserByUid(@Param("uid") Integer uid);

    // 通过用户名查找用户
    User findUserByName(@Param("name") String name);

    // 从用户表里删除用户
    void userDelete(@Param("uid") Integer uid);

    // 删除用户所建的表
    void dropTable(@Param("tableName") String tableName);

    // 更新用户数据
    void updateUserData(User user);

}

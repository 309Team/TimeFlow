package TimeFlow.service.impl.user;


import TimeFlow.mapper.classification.ClassCategoryMapper;
import TimeFlow.mapper.user.UserMapper;
import TimeFlow.pojo.User;
import TimeFlow.service.interf.user.UserService;
import TimeFlow.util.TableNameUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImp implements UserService {
    private final UserMapper userMapper;
    private final ClassCategoryMapper classCategoryMapper;

    public UserServiceImp(UserMapper userMapper, ClassCategoryMapper classCategoryMapper) {
        this.userMapper = userMapper;
        this.classCategoryMapper = classCategoryMapper;
    }

    @Override
    @Transactional
    public Boolean userDelete(Integer uid) {
        // 先找到是否有该uid的用户
        User userByUid = userMapper.findUserByUid(uid);

        // 没有该uid的用户，返回错误
        if (userByUid == null)
            return false;

        // 有该uid的用户，执行删除操作
        // 删除该uid所创建的表
        userMapper.dropTable(TableNameUtil.getLEName(uid));
        userMapper.dropTable(TableNameUtil.getMEName(uid));
        userMapper.dropTable(TableNameUtil.getTEName(uid));
        classCategoryMapper.dropTable(TableNameUtil.getMidTabName(uid));
        // 从用户表中删除
        userMapper.userDelete(uid);

        return true;
    }

    @Override
    @Transactional
    public Boolean userUpdate(User user) {
        // 先找到是否有该uid的用户
        User userByUid = userMapper.findUserByUid(user.getUid());

        // 没有该uid的用户，返回错误
        if (userByUid == null)
            return false;

        // 有该uid的用户，执行更新操作
        // 查找是否有重名的用户，有则不能修改
        User userByName = userMapper.findUserByName(user.getName());
        if (userByName != null)
            return false;
        else {
            // 对不修改的数据进行处理
            if (!StringUtils.hasText(user.getName()))
                user.setName(null);
            if (!StringUtils.hasText(user.getPassword()))
                user.setPassword(null);

            userMapper.updateUserData(user);
        }

        return true;
    }
}

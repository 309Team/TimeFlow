package TimeFlow.service.impl.user;

import TimeFlow.mapper.classification.ClassCategoryMapper;
import TimeFlow.mapper.user.RegisterMapper;
import TimeFlow.pojo.User;
import TimeFlow.service.interf.user.RegisterService;
import TimeFlow.util.TableNameUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterServiceImp implements RegisterService {

    final
    RegisterMapper registerMapper;
    final
    ClassCategoryMapper classCategoryMapper;

    public RegisterServiceImp(RegisterMapper registerMapper, ClassCategoryMapper classCategoryMapper) {
        this.registerMapper = registerMapper;
        this.classCategoryMapper = classCategoryMapper;
    }

    @Override
    public User findUser(User user) {
        return registerMapper.findUser(user);
    }


    @Override
    @Transactional
    public Integer userRegister(User user) {

        // 获取是否有这个用户名的用户
        User registeredUser = registerMapper.findUser(user);
        if (registeredUser != null)
            return 1; // 如果有，返回1
        else {
            // 没有，进行注册
            registerMapper.userRegister(user);

            if (user.getUid() == null)
                return 1; // 注册失败，返回1

            // 建表
            registerMapper.createMETable(TableNameUtil.getMEName(user.getUid()));
            registerMapper.createLETable(TableNameUtil.getLEName(user.getUid()));
            registerMapper.createTETable(TableNameUtil.getTEName(user.getUid()));
            classCategoryMapper.createTable(TableNameUtil.getMidTabName(user.getUid()));
        }

        return 0;
    }
}

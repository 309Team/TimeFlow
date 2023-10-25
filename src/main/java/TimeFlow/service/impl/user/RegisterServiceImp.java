package TimeFlow.service.impl.user;

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

    public RegisterServiceImp(RegisterMapper registerMapper) {
        this.registerMapper = registerMapper;
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

            // 找到uid
            User newUser = registerMapper.findUser(user);
            // 建表
            registerMapper.createMETable(TableNameUtil.getMEName(newUser.getUid()));
            registerMapper.createLETable(TableNameUtil.getLEName(newUser.getUid()));
            registerMapper.createTETable(TableNameUtil.getTEName(newUser.getUid()));
        }


        return 0;
    }
}

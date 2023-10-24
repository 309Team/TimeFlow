package TimeFlow.service.impl.user;

import TimeFlow.mapper.user.RegisterMapper;
import TimeFlow.pojo.User;
import TimeFlow.service.interf.user.RegisterService;
import TimeFlow.util.TableNameUtil;
import org.springframework.stereotype.Service;

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
    public void createTable(User user) {
        Integer uid = user.getUid();
        registerMapper.createMETable(TableNameUtil.getMEName(uid));
        registerMapper.createLETable(TableNameUtil.getLEName(uid));
        registerMapper.createTETable(TableNameUtil.getTEName(uid));
    }

    @Override
    public Integer userRegister(User user) {

        // 获取是否有这个用户名的用户
        User registeredUser = registerMapper.findUser(user);
        if (registeredUser != null)
            return 1; // 如果有，返回1
        else
            registerMapper.userRegister(user);

        return 0;
    }
}

package example.demo.services;

import com.springboot.mapper.UserMapper;
import com.springboot.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImp1 implements UserServices {

    final UserMapper userMapper;

    public UserServicesImp1(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> FindAll() {
       return userMapper.FindAll();
    }
}

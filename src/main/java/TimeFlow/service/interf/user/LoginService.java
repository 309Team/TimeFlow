package TimeFlow.service.interf.user;



import TimeFlow.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    User login(User user);
}

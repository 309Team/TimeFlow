package TimeFlow.controller.user;

import TimeFlow.config.GetUserId;
import TimeFlow.pojo.Result;
import TimeFlow.pojo.User;
import TimeFlow.service.interf.user.LoginService;
import TimeFlow.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin
public class LoginController {

    final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) {

        // 查询前端账号密码是否正确
        User loginUser = loginService.login(user);

        // 密码正确
        if (loginUser != null) {
            // 生成token
            String token = JwtUtil.createJWT(loginUser.getId().toString(), null);

            HashMap<String, String> map = new HashMap<>();
            map.put("token", token);
            return Result.success(map);
        } else {
            // 密码错误
            return Result.error("用户名或密码错误！");
        }
    }

    @RequestMapping("/hello")
    public Result hello(@GetUserId Integer id) {
        return Result.success(id);
    }
}

package TimeFlow.controller;

import TimeFlow.pojo.Result;
import TimeFlow.pojo.User;
import TimeFlow.service.LoginService;
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

        User loginUser = loginService.login(user);

        if (loginUser != null) {
            String token = JwtUtil.createJWT(loginUser.getId().toString(), null);

            HashMap<String, String> map = new HashMap<>();
            map.put("token", token);
            return Result.success(map);
        } else {
            return Result.error("用户名或密码错误！");
        }
    }

    @RequestMapping("/hello")
    public Result hello() {
        return Result.success();
    }
}

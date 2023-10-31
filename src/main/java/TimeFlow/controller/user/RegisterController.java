package TimeFlow.controller.user;

import TimeFlow.pojo.interact.Result;
import TimeFlow.pojo.User;
import TimeFlow.service.interf.user.RegisterService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RegisterController {

    final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/register")

    public Result register(@RequestBody User user) {
        // 请求在用户表中添加
        Integer code = registerService.userRegister(user);

        // 添加失败（用户名存在）
        if (code == 1)
            return Result.error(1, "用户名已被注册");

        // 添加成功
        return Result.success();
    }

}

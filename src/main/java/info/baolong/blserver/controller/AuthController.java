package info.baolong.blserver.controller;

import info.baolong.blserver.entity.User;
import info.baolong.blserver.entity.forms.AuthForm;
import info.baolong.blserver.service.UserService;
import info.baolong.blserver.shiro.JwtToken;
import info.baolong.blserver.utils.JwtUtils;
import info.baolong.blserver.utils.R;
import info.baolong.blserver.utils.SaltUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 包龙
 * @since 2022-07-06
 */
@Api("验证相关controller")
@RestController
@RequestMapping("/bl_server/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户认证登录方法")
    @PostMapping("login")
    public R login(@RequestBody AuthForm authForm) {
        System.out.println("测试登录！");

        User user = userService.getByUsername(authForm.getUsername());

        if (ObjectUtils.isEmpty(user)){
            return R.error().message("用户未注册");
        }

        if (!userService.verifyUser(user.getUsername(), authForm.getPassword())) {
            return R.error().message("账号或密码错误");
        }

        String jwtToken = JwtUtils.generate(user.getUsername());
        Subject subject = SecurityUtils.getSubject();
        subject.login(new JwtToken(jwtToken));

        return R.ok().message("登录成功").data("token", jwtToken);
    }

    @ApiOperation("注册用户controller")
    @PostMapping("register")
    public R register(@RequestBody AuthForm authForm) {
        String salt = SaltUtils.getSalt(8);
        // 加密密码
        String encodedPassword = new Md5Hash(authForm.getPassword(), salt, 21).toHex();
        // 保存用户
        userService.registerUser(authForm.getUsername(), encodedPassword, salt);
        return R.ok().message("注册成功");
    }

    @ApiOperation("退出登录controller")
    @PostMapping("logout")
    public R logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return R.ok();
    }

    @ApiOperation("获取用户信息controller")
    @GetMapping("get_info")
    public R getUser() {
        Subject subject = SecurityUtils.getSubject();
        String principal = (String) subject.getPrincipal();
        String username = JwtUtils.getUsername(principal);
        User user = userService.getByUsername(username);

        // const { roles, name, avatar } = data 前端需要至少这三个信息
        return R.ok().data("user", user);
    }
}

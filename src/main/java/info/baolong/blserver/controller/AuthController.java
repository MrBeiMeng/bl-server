package info.baolong.blserver.controller;

import info.baolong.blserver.service.UserService;
import info.baolong.blserver.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@RequestMapping("/book_manage_keshe/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户认证登录方法")
    @PostMapping("login")
    public R login() {
        System.out.println("测试登录！");
//        User user = EmailUtils.isEmail(loginForm.getUsername()) ?
//                userService.getByEmail(loginForm.getUsername()) :
//                userService.getByUsername(loginForm.getUsername());
//
//        if (!userService.verifyUser(user.getUsername(), loginForm.getPassword())) {
//            return R.error().message("账号或密码错误.");
//        }
//
//        if (!verifyCodeService.verifyCode(user.getEmail(), loginForm.getVerifyCode())) {
//
//            return R.error().message("验证码错误.");
//        }
//
//        String jwtToken = JwtUtils.generate(user.getUsername());
//        Subject subject = SecurityUtils.getSubject();
//        subject.login(new JwtToken(jwtToken));

//        return R.ok().data("token", jwtToken);
        return R.ok();
    }


    @ApiOperation("发送验证码controller")
    @GetMapping("get_verify_code")
    public R getVerifyCode(@ApiParam("接收验证码的email/用户名") String toEmail) {

//        //判断是否是邮箱
//        if (!EmailUtils.isEmail(toEmail)) {
//            toEmail = userService.getByUsername(toEmail).getEmail();
//        }
//
//        //拿到验证码
//        String verifyCode = verifyCodeService.getCode(toEmail);
//        // 检验toEmail 合法性
//        emailService.sendSimpleMail("1192384722@qq.com", toEmail, "请查收您的验证码", verifyCode);
//        return R.ok().message("发送成功").data("emailNumber",EmailUtils.blur(toEmail));
        return R.ok();
    }

    @ApiOperation("注册用户controller")
    @PostMapping("register")
    public R register() {
//        String salt = SaltUtils.getSalt(8);
//        // 加密密码
//        String encodedPassword = new Md5Hash(loginForm.getPassword(), salt, 21).toHex();
//        // 保存用户
//        userService.registerUser(loginForm.getUsername(), encodedPassword, salt);
        return R.ok();
    }

    @ApiOperation("退出登录controller")
    @PostMapping("logout")
    public R logout() {
//        Subject subject = SecurityUtils.getSubject();
//        subject.logout();
        return R.ok();
    }

    @ApiOperation("获取用户信息controller")
    @GetMapping("get_info")
    public R getUser() {
        return R.ok();
    }
}

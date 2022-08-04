package info.baolong.blserver.shiro;

import info.baolong.blserver.service.UserService;
import info.baolong.blserver.utils.JwtUtils;
import org.apache.juli.logging.LogFactory;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /*
     * 多重写一个support
     * 标识这个Realm是专门用来验证JwtToken
     * 不负责验证其他的token（UsernamePasswordToken）
     * */
    @Override
    public boolean supports(AuthenticationToken token) {
        //这个token就是从过滤器中传入的jwtToken
        return token instanceof JwtToken;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("开始授权");
        String jwt = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole("user");
        return authorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String jwt = (String) authenticationToken.getPrincipal();
        // 这里做一个用户日志
        String username = JwtUtils.getUsername(jwt);
        Logger logger = LoggerFactory.getLogger("JwtRealm");
        logger.info("---------------------------");
        logger.info("用户[{}] 调用controller",username);

        if(!JwtUtils.verify(jwt)){
            System.out.println("用户未认证");
            throw new IncorrectCredentialsException("Authorization token is invalid");
        }
        return new SimpleAuthenticationInfo(jwt,jwt,"JwtRealm");
    }
}


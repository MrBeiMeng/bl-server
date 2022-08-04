package info.baolong.blserver.aop;

import info.baolong.blserver.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class ControllerAop {

    @Autowired
    private UserService userService;

    @Pointcut(value = "execution(* info.baolong.blserver.controller.*.*(..))") //其中value可以写多种表达式定义切入点，后续详解
    public void pointCut() {
    }

    /**
     * 前置通知，在切点执行之前执行的操作
     */
    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        // 逻辑代码
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        assert requestAttributes != null;
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);

        assert request != null;
        String remoteIp = request.getRemoteAddr();
        String achievingPath = request.getServletPath();
        Object[] args = joinPoint.getArgs();



        Logger logger = LoggerFactory.getLogger("ControllerAop");
        logger.info("ip[{}]欲访问:[{}] 携带参数:[{}]",remoteIp,achievingPath,Arrays.toString(args));
    }
}

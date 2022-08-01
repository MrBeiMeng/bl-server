package info.baolong.blserver.service.impl;

import info.baolong.blserver.entity.User;
import info.baolong.blserver.mapper.UserMapper;
import info.baolong.blserver.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 包龙
 * @since 2022-08-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

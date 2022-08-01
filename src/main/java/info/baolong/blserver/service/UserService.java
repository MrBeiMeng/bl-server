package info.baolong.blserver.service;

import info.baolong.blserver.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 包龙
 * @since 2022-08-01
 */
public interface UserService extends IService<User> {
    void registerUser(String username, String encodedPassword, String salt);

    boolean verifyUser(String username, String password);

    User getByUsername(String username);
}

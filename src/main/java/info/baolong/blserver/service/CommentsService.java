package info.baolong.blserver.service;

import info.baolong.blserver.entity.Comments;
import com.baomidou.mybatisplus.extension.service.IService;
import info.baolong.blserver.entity.forms.CommentsForm;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 包龙
 * @since 2022-08-07
 */
public interface CommentsService extends IService<Comments> {

    void addComments(CommentsForm commentsForm);

    List<Comments> getByType(int type);
}

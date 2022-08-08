package info.baolong.blserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import info.baolong.blserver.entity.Comments;
import info.baolong.blserver.entity.forms.CommentsForm;
import info.baolong.blserver.mapper.CommentsMapper;
import info.baolong.blserver.service.CommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 包龙
 * @since 2022-08-07
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {

    @Override
    public void addComments(CommentsForm commentsForm) {
        if (StringUtils.isEmpty(commentsForm.getAuthor())){
            commentsForm.setAuthor("匿名");
        }

        Comments comments = new Comments();
        BeanUtils.copyProperties(commentsForm,comments);

        save(comments);
    }

    @Override
    public List<Comments> getByType(int type) {
        QueryWrapper<Comments> wrapper = new QueryWrapper<>();
        wrapper.eq("type",type);
        return list(wrapper);
    }
}

package info.baolong.blserver.controller;


import info.baolong.blserver.entity.Comments;
import info.baolong.blserver.entity.forms.CommentsForm;
import info.baolong.blserver.service.CommentsService;
import info.baolong.blserver.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 包龙
 * @since 2022-08-07
 */
@RestController
@RequestMapping("/bl_server/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @PostMapping("/add-comments")
    public R addComments(@RequestBody CommentsForm commentsForm){
        commentsService.addComments(commentsForm);
        return R.ok().message("添加成功");
    }

    @GetMapping("get-all")
    public R getAll(){
        List<Comments> list = commentsService.list();
        return R.ok().data("rows",list);
    }

    @GetMapping("get-by-type/{type}")
    public R getByType(@PathVariable int type){
        List<Comments> list = commentsService.getByType(type);
        return R.ok().data("rows",list);
    }
}


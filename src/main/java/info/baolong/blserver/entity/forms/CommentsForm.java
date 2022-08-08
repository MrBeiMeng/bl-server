package info.baolong.blserver.entity.forms;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CommentsForm {
    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "出处")
    @TableField("fromBook")
    private String fromBook;

    @ApiModelProperty(value = "Positive 1/negative 2")
    private Integer type;
}

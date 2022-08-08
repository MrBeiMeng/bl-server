package info.baolong.blserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 求职记录
 * </p>
 *
 * @author 包龙
 * @since 2022-08-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="JobStatus对象", description="求职记录")
public class JobStatus implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "公司")
    private String company;

    @ApiModelProperty(value = "投递状态 2 已投递 1 未投递")
    private Integer postSituation;

    @ApiModelProperty(value = "投递日期")
    private Date postDate;

    @ApiModelProperty(value = "投递岗位")
    private String positionApplied;

    @ApiModelProperty(value = "当前状态")
    private String status;

    @ApiModelProperty(value = "备注")
    private String remark;

    private String resumeId;

    @ApiModelProperty(value = "优先级 1 一般 2 重要 3 很重要")
    private Integer priority;

    @ApiModelProperty(value = "资料")
    private String jobData;

    @ApiModelProperty(value = "公司地址")
    private String companyAddress;

    @ApiModelProperty(value = "链接")
    private String companyLink;


}

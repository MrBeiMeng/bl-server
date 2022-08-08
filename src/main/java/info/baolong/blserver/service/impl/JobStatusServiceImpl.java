package info.baolong.blserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import info.baolong.blserver.entity.JobStatus;
import info.baolong.blserver.mapper.JobStatusMapper;
import info.baolong.blserver.service.JobStatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 求职记录 服务实现类
 * </p>
 *
 * @author 包龙
 * @since 2022-08-08
 */
@Service
public class JobStatusServiceImpl extends ServiceImpl<JobStatusMapper, JobStatus> implements JobStatusService {

    @Override
    public List<JobStatus> PriorityOrderList() {
        QueryWrapper<JobStatus> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("priority","post_date");
        return list(queryWrapper);
    }
}

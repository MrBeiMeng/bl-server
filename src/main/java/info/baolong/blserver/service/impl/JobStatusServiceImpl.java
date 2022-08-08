package info.baolong.blserver.service.impl;

import info.baolong.blserver.entity.JobStatus;
import info.baolong.blserver.mapper.JobStatusMapper;
import info.baolong.blserver.service.JobStatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}

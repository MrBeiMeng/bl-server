package info.baolong.blserver.controller;


import info.baolong.blserver.service.JobStatusService;
import info.baolong.blserver.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 求职记录 前端控制器
 * </p>
 *
 * @author 包龙
 * @since 2022-08-08
 */
@RestController
@RequestMapping("/bl_server/job-status")
public class JobStatusController {

    @Autowired
    private JobStatusService jobStatusService;

    @GetMapping("/get-all")
    public R getJobStatus(){
        return R.ok().data("rows",jobStatusService.list());
    }
}


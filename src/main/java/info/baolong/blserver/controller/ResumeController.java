package info.baolong.blserver.controller;


import info.baolong.blserver.entity.Resume;
import info.baolong.blserver.entity.forms.ResumeForm;
import info.baolong.blserver.service.ResumeService;
import info.baolong.blserver.utils.R;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 简历 前端控制器
 * </p>
 *
 * @author 包龙
 * @since 2022-08-08
 */
@RestController
@RequestMapping("/bl_server/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;


    @GetMapping("/get-by-id")
    public R getById(String resumeId){
        return R.ok().data("rows",resumeService.getById(resumeId));
    }

    @GetMapping("/get-all")
    public R getAll(String resumeId){
        return R.ok().data("rows",resumeService.list());
    }

    @PostMapping("/add")
    public R add(@RequestBody ResumeForm resumeForm){
        Resume resume = new Resume();
        BeanUtils.copyProperties(resumeForm,resume);
        resumeService.save(resume);
        return R.ok().message("添加成功");
    }
}


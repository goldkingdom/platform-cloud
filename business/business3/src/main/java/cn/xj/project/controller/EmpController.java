package cn.xj.project.controller;

import cn.xj.project.model.Emp;
import cn.xj.project.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Welink on 2017/5/2.
 */
@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/findAll")
    public List<Emp> findAll() {
        return empService.findAll();
    }

}

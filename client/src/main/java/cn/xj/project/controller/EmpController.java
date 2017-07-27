package cn.xj.project.controller;

import cn.xj.common.config.BaseConfig;
import cn.xj.common.model.Result;
import cn.xj.project.service.jpa.JpaEmpService;
import cn.xj.project.service.mybatis.MybatisEmpService;
import cn.xj.project.model.Emp;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Welink on 2017/4/26.
 */
@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private BaseConfig baseConfig;

    @Autowired
    private JpaEmpService jpaEmpService;

    @Autowired
    private MybatisEmpService mybatisEmpService;

    @RequestMapping("/findEmpById/{id}")
    public Object findEmpById(@PathVariable Long id) {
        Map vo = Maps.newHashMap();
        vo.put("id", id);
        Emp emp = mybatisEmpService.findEmpById(vo);
        Result result = new Result(baseConfig.getVersion(), Thread.currentThread().getStackTrace()[1].getMethodName(), emp);
        return result;
    }

    @RequestMapping("/findEmpListByPager")
    public Object findEmpListByPager() {
        Map params = Maps.newHashMap();
        params.put("name", "jack");
        Map pager = Maps.newHashMap();
        pager.put("currentPage", 1);
        pager.put("itemsPerPage", 10);
        Map vo = Maps.newHashMap();
        vo.put("params", params);
        vo.put("pager", pager);
        List<Emp> list = mybatisEmpService.findEmpListByPager(vo);
        Result result = new Result(baseConfig.getVersion(), Thread.currentThread().getStackTrace()[1].getMethodName(), list);
        return result;
    }

    @RequestMapping("/findAll")
    public Object findAll() {
        List<Emp> list = jpaEmpService.findAll();
        Result result = new Result(baseConfig.getVersion(), Thread.currentThread().getStackTrace()[1].getMethodName(), list);
        return result;
    }

}

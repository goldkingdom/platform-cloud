package cn.xj.project.controller;

import cn.xj.project.model.Emp;
import cn.xj.project.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private EmpService empService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/findEmpById")
    public Emp findEmpById(@RequestBody Map vo) {
        Emp emp = null;
        try {
            emp = empService.findEmpById(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }

    @RequestMapping("/findEmpListByPager")
    public List<Emp> findEmpListByPager(@RequestBody Map vo) {
        List<Emp> list = null;
        try {
            Map params = (Map) vo.get("params");
            Map pager = (Map) vo.get("pager");
            list = empService.findEmpListByPager(params, pager);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}

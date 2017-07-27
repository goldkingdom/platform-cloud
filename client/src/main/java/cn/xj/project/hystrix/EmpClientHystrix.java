package cn.xj.project.hystrix;

import cn.xj.project.model.Emp;
import cn.xj.project.service.jpa.JpaEmpService;
import cn.xj.project.service.mybatis.MybatisEmpService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Welink on 2017/7/18.
 */
@Component
public class EmpClientHystrix implements MybatisEmpService, JpaEmpService {

    @Override
    public List<Emp> findAll() {
        return null;
    }

    @Override
    public Emp findEmpById(@RequestBody Map vo) {
        return null;
    }

    @Override
    public List<Emp> findEmpListByPager(@RequestBody Map vo) {
        return null;
    }

}

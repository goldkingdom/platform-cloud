package cn.xj.project.hystrix.jpa;

import cn.xj.project.model.Emp;
import cn.xj.project.service.jpa.JpaEmpService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Welink on 2017/5/3.
 */
@Component
public class JpaEmpClientHystrix implements JpaEmpService {

    @Override
    public List<Emp> findAll() {
        return null;
    }

}

package cn.xj.project.service.jpa;

import cn.xj.project.hystrix.EmpClientHystrix;
import cn.xj.project.model.Emp;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Welink on 2017/5/3.
 */
@FeignClient(name = "${provider.jpa}", fallback = EmpClientHystrix.class)
public interface JpaEmpService {

    @RequestMapping("/emp/findAll")
    List<Emp> findAll();

}

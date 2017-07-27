package cn.xj.project.service.mybatis;

import cn.xj.project.hystrix.EmpClientHystrix;
import cn.xj.project.model.Emp;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Welink on 2017/4/26.
 */
@FeignClient(name = "${provider.mybatis}", fallback = EmpClientHystrix.class)
public interface MybatisEmpService {

    @RequestMapping("/emp/findEmpById")
    Emp findEmpById(@RequestBody Map vo);

    @RequestMapping("/emp/findEmpListByPager")
    List<Emp> findEmpListByPager(@RequestBody Map vo);

}

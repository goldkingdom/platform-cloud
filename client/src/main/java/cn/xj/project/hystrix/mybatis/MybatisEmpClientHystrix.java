package cn.xj.project.hystrix.mybatis;

import cn.xj.project.model.Emp;
import cn.xj.project.service.mybatis.MybatisEmpService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Welink on 2017/4/26.
 */
@Component
public class MybatisEmpClientHystrix implements MybatisEmpService {

    @Override
    public Emp findEmpById(Map vo) {
        return null;
    }

    @Override
    public List<Emp> findEmpListByPager(Map vo) {
        return null;
    }

}

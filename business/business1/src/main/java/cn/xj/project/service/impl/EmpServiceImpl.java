package cn.xj.project.service.impl;

import cn.xj.project.model.Emp;
import cn.xj.common.sql.service.SqlService;
import cn.xj.project.service.EmpService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Welink on 2017/4/26.
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private SqlService sqlService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Emp findEmpById(Map vo) throws Exception {
        StringBuffer sql = new StringBuffer("select * from emp where id = {id,Long}");
        List<Emp> list = sqlService.select(sql, vo, Emp.class);
        return list == null || list.size() == 0 ? null : list.get(0);
    }

    @Override
    public List<Emp> findEmpListByPager(Map params, Map pager) throws Exception {
        StringBuffer sql = new StringBuffer("select * from emp where name = {name,String}");
        List<Emp> list = sqlService.select(sql, params, pager, null, Emp.class);
        return list;
    }

}

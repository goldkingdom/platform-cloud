package cn.xj.project.service;

import cn.xj.project.model.Emp;

import java.util.List;
import java.util.Map;

/**
 * Created by Welink on 2017/4/26.
 */
public interface EmpService {

    Emp findEmpById(Map vo) throws Exception;

    List<Emp> findEmpListByPager(Map params, Map pager) throws Exception;

}

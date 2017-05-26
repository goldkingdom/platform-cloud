package cn.xj.project.service;

import cn.xj.project.model.Emp;
import cn.xj.project.repository.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Welink on 2017/5/2.
 */
@Service
public class EmpService {

    @Autowired
    private EmpDao empDao;

    public List<Emp> findAll() {
        return empDao.findAll(null);
    }

}

package cn.xj.project.service.impl;

import cn.xj.project.model.Emp;
import cn.xj.project.repository.EmpRepository;
import cn.xj.project.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Welink on 2017/5/2.
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepository empRepository;

    public List<Emp> findAll() {
        return empRepository.findAll(null);
    }

}

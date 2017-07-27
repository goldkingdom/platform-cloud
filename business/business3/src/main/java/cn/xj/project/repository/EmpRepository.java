package cn.xj.project.repository;

import cn.xj.project.model.Emp;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * Created by Welink on 2017/5/2.
 */
public interface EmpRepository extends Repository<Emp, Serializable>, JpaSpecificationExecutor<Emp> {
}

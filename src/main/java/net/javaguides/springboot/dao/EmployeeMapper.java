package net.javaguides.springboot.dao;

import net.javaguides.springboot.repository.EmployeeRepository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends EmployeeRepository {
}

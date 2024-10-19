package net.javaguides.springboot.dao;

import net.javaguides.springboot.repository.DepartmentRepository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentMapper extends DepartmentRepository {
}

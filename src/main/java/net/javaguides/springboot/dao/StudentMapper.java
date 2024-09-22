package net.javaguides.springboot.dao;

import net.javaguides.springboot.repository.StudentRepository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends StudentRepository {
}

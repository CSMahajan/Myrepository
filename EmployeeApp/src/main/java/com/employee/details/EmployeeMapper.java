package com.employee.details;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface EmployeeMapper {
	
	@Select("SELECT * FROM EMPLOYEE")
    List<Employee> getAllEmployees();

	@Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO EMPLOYEE (firstname, lastname, email, age) VALUES(#{firstname},#{lastname},#{email},#{age})")
    int addEmployee(Employee employee);
    
    @Update("UPDATE EMPLOYEE SET firstname = #{firstname},lastname=#{lastname},email=#{email},age=#{age} WHERE id=#{id}")
    int updateEmployee(Long id, String firstname, String lastname, String email, int age);
    
    @Delete("DELETE FROM EMPLOYEE WHERE id=#{id}")
    int deleteEmployee(Long id);

}

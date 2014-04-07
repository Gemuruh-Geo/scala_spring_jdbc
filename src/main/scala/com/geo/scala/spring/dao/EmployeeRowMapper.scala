package com.geo.scala.spring.dao

import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import com.geo.scala.spring.Employee
import com.geo.scala.spring.Employee

class EmployeeRowMapper extends RowMapper[Employee]{
	override def mapRow(rs:ResultSet, rowNum:Int):Employee = {
	  val employee = new Employee
	  employee.id = rs.getInt("ID")
	  employee.name = rs.getString("NAME")
	  employee.age = rs.getInt("AGE")
	  employee
	}
}
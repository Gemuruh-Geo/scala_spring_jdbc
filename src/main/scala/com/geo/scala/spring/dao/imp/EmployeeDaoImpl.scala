package com.geo.scala.spring.dao.imp

import com.geo.scala.spring.dao.EmployeeDao
import com.geo.scala.spring.Employee
import scala.collection.mutable.ArrayBuffer
import javax.sql.DataSource
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import com.geo.scala.spring.dao.EmployeeRowMapper
import com.geo.scala.spring.Employee
import com.geo.scala.spring.Employee
import com.geo.scala.spring.util.AllQuery
import scala.collection.JavaConverters._
import com.geo.scala.spring.util.JdbcTempalteUtil
import java.sql.Types
import org.springframework.jdbc.core.BatchPreparedStatementSetter
import java.sql.PreparedStatement


class EmployeeDaoImpl extends EmployeeDao{
  private var dataSource:DataSource = _;
  def setDataSource(dataSource:DataSource):Unit={
    this.dataSource = dataSource
    JdbcTempalteUtil.setDataSource(dataSource)
  }
  override def findById(id:Integer):Employee={
    val sql = AllQuery.select_by_id.toString()
    val employee:Employee = JdbcTempalteUtil.queryForObject(sql, Array[Object](id), new EmployeeRowMapper())
    employee
  }
  override def findAll():ArrayBuffer[Employee] = {
    val sql = AllQuery.select_all.toString()
    val it = JdbcTempalteUtil.queryForList(sql).asScala
    val employees = new ArrayBuffer[Employee]
    for(m<-it){
      val empl = new Employee
      empl.id = m.get("ID").asInstanceOf[Long].toInt
      empl.name = m.get("NAME").asInstanceOf[String]
      empl.age = m.get("AGE").asInstanceOf[Long].toInt
      employees+=empl
    }
    employees
  }
  override def insert(employee:Employee):Unit = {
    val sql = AllQuery.insert.toString
    JdbcTempalteUtil.update(sql, Array[Object](employee.id:java.lang.Integer,employee.name,employee.age:java.lang.Integer), Array[Int](Types.INTEGER,Types.VARCHAR,Types.INTEGER))
    
  }
  override def batchInsert(employees:ArrayBuffer[Employee]):Unit={
    val sql = AllQuery.insert.toString
    JdbcTempalteUtil.batchUpdate(sql,new BatchPreparedStatementSetter(){
      override def setValues(ps:PreparedStatement, i:Int){
        val emp = employees(i)
        ps.setInt(1, emp.id)
        ps.setString(2, emp.name)
        ps.setInt(3, emp.age)
        
      }
      override def getBatchSize():Int={
        employees.size
      }
    })
  }
}
package com.geo.scala.spring.main

import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.context.ConfigurableApplicationContext
import com.geo.scala.spring.dao.EmployeeDao
import scala.collection.mutable.ArrayBuffer
import com.geo.scala.spring.Employee

object Main {
	def main(args:Array[String]):Unit={
	  val appContext:ConfigurableApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml")
	  val employeeDao = appContext.getBean("employeeDAO").asInstanceOf[EmployeeDao]
	  
	  
	  /*Insert single data*/
	  /*val employee = new Employee
	  employee.id = 130
	  employee.name = "Gemuruh"
	  employee.age = 26
	  employeeDao.insert(employee);*/
	  
	  /*Batch Insert*/
	  
	  /*--------Find By ID------------*/
	  println(employeeDao.findById(110))
	  
	  /*---------Find All -----------*/
	  val ab = employeeDao.findAll
	  ab.foreach(a=>{
	    println(s"Employee id = ${a.id}, Employee name = ${a.name}, Employee Age = ${a.age}")
	  })
	}
}
package com.geo.scala.spring.dao

import com.geo.scala.spring.Employee
import scala.collection.mutable.ArrayBuffer

trait EmployeeDao {
  def findById(id:Integer):Employee
  def findAll():ArrayBuffer[Employee]
  def insert(employee:Employee)
  def batchInsert(employees:ArrayBuffer[Employee]);
}
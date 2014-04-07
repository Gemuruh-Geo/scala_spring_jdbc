package com.geo.scala.spring.util

object AllQuery extends Enumeration{
  type SQL = Value
  val select_all = Value("select * from employee")
  val select_by_id = Value("select * from employee where id=?")
  val insert = Value("insert into employee(ID,NAME,AGE) values(?,?,?)")

}
package com.akv.app.item
import scala.collection.mutable.Set

object ItemDao {

//  private var items = Set(Item(1,"Shirt",12.5,3),Item(2,"pant",12.2,2))

  private var items = Set[Item]()

  val listItems: Set[Item] = items

  def findById(id:Int): Option[Item] = {
    items.find(_.itemId==id)
  }

  def getItem(id:Int): Any = {
    findById(id) match {
      case Some(i) => i
      case None => Map("message" -> "Item Not found")

    }
  }

  def addItem(item:Item): Map[String,String] = {
    findById(item.itemId) match {
      case Some(i) => Map("message" -> "Item already exists")
      case None => {
        items += item
        println(items)
        Map("message" -> "Item Created Successfully")
      }
    }
  }

  def updateItem(item:Item): Map[String,String] = {
    findById(item.itemId) match {
      case Some(i) => {
       items -= i += item
        println(items)
        Map("message" -> "Existing Item,updated Successfully")
      }
      case None => {
        items += item
        Map("message" -> "New Item, created Successfully")
      }
    }
  }

  def removeItem(id: Int): Map[String,String] = {
    findById(id) match {
      case Some(i) => {
        items -= i
        println(items)
        Map("message" -> "Existing item,removed Successfully")
      }
      case None => {
        Map("message" -> "Item not found")
      }
    }
  }

}

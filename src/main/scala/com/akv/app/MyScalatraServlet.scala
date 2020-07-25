package com.akv.app

import org.scalatra._
import com.akv.app._
import com.akv.app.item.{Item, ItemDao}
// JSON-related libraries
import org.json4s.{DefaultFormats, Formats}
// JSON handling support from Scalatra
import org.scalatra.json._

class MyScalatraServlet extends ScalatraServlet with JacksonJsonSupport{

  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  // Before every action runs, set the content type to be in JSON format.
  before() {
    contentType = formats("json")
  }

  get("/items/") {
    ItemDao.listItems
  }

  get("/items/:id") {
    ItemDao.getItem(params("id").toInt)
  }

  post("/items/") {
    val item:Item = parsedBody.extract[Item]
    ItemDao.addItem(item)
  }

  put("/items/") {
    val item:Item = parsedBody.extract[Item]
    ItemDao.updateItem(item)
  }

  delete("/items/:id") {
    ItemDao.removeItem(params("id").toInt)
  }
}

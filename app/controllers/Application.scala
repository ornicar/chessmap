package controllers

import concurrent.Future
import play.api.libs.EventSource
import play.api._
import play.api.libs.iteratee.{ Iteratee, Enumerator, Concurrent }
import play.api.mvc._
import play.api.Play.current

import akka.actor.Actor
import akka.actor.Props
import akka.event.Logging

import play.api.libs.concurrent.Akka
import play.api.libs.concurrent.Execution.Implicits._

import models.LichessStream
import models.LichessStream._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def stream = Action {
    val source = LichessStream.enumerator &> lineParser &>
      toIpLocation &> toLocation &> withOpponentLocation &>
      asJson &> EventSource()

    Ok.chunked(source).as("text/event-stream")
  }
}

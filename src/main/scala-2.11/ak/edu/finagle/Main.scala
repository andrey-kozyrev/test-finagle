package ak.edu.finagle

import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http.{Method, Request, Response, Status}
import com.twitter.util.{Await, Future}
import com.typesafe.scalalogging.StrictLogging

import scala.io.StdIn

/**
  * @author Andrey Kozyrev on 6/14/16.
  */
object Main extends App with StrictLogging {

  def server() = Http.serve(":8888", new Service[Request, Response] {
    override def apply(request: Request): Future[Response] = {
      logger.info("service.apply")
      Future.value(
        Response(request.version, Status.Ok)
      )
    }
  })

  def client(): Unit = {
    val cli = Http.newService("www.scala-lang.org:80")
    val req = Request(Method.Get, "/")
    req.host = "www.scala-lang.org"
    val res = cli(req)
    res.onSuccess(r => logger.info("res: {}", r))
  }

  logger.info("start")
  //server()
  client()
  StdIn.readLine()
}

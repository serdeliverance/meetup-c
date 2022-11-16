package io.github.meetupc.adapters.in.web

import io.github.meetupc.application.port.in.CreateMeetupUseCase
import org.http4s.dsl.Http4sDsl
import cats.effect.IO
import org.http4s.server.Router
import org.http4s.HttpRoutes

case class MeetupEndpoints(createMeetupUseCase: CreateMeetupUseCase) extends Http4sDsl[IO] {

    val routes = HttpRoutes.of[IO]{
        case body @ POST ->  Root / "meetups" =>
            Ok()
    }

}
package io.github.meetupc.application.service

import munit.CatsEffectSuite
import io.github.meetupc.application.port.service.CreateMeetupService
import io.github.meetupc.application.port.in.CreateMeetupCommand
import java.time.Instant
import cats.effect.IO
import java.time.Duration
import scala.concurrent.duration._
import io.github.meetupc.domain.Meetup

class CreateMeetupServiceSpec extends CatsEffectSuite {

    lazy val createMeetupService = new CreateMeetupService()

    test("meetup creation") {
        // TODO replace this value for something more realistic such as now + 7 days
        val date = Instant.now()
        val cmd = CreateMeetupCommand("Hexagonal Arch in Scala", 5, date)
        createMeetupService.create(cmd).map { result => assertEquals(result, Meetup(1, "Hexagonal Arch in Scala", 5, date)) }
    }
}
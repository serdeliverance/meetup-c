package io.github.meetupc.application.port.service

import io.github.meetupc.application.port.in.CreateMeetupUseCase
import cats.effect.IO
import io.github.meetupc.application.port.in.CreateMeetupCommand
import io.github.meetupc.domain.Meetup
import java.util.UUID

class CreateMeetupService extends CreateMeetupUseCase {

  def create(cmd: CreateMeetupCommand): IO[Meetup] = IO.delay(Meetup(Some(UUID.randomUUID()), cmd.title, cmd.attendants, cmd.date))
}

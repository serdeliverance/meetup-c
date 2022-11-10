package io.github.meetupc.application.port.in

import cats.effect.IO
import io.github.meetupc.domain.Meetup

trait CreateMeetupUseCase {

  def create(cmd: CreateMeetupCommand): IO[Meetup]
}

package io.github.meetupc.application.port.out

package io.github.meetupc.application.port.out

import _root_.io.github.meetupc.domain.Meetup
import cats.effect.IO

trait MeetupRepository {

  def create(meetup: Meetup): IO[Meetup]
}

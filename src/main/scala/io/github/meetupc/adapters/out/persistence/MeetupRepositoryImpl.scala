package io.github.meetupc.adapters.out.persistence

import io.github.meetupc.application.port.out.io.github.meetupc.application.port.out.MeetupRepository
import cats.effect.IO
import io.github.meetupc.domain.Meetup
import skunk.Session
import skunk.Command
import skunk.codec.all._
import skunk.implicits._
import io.github.meetupc.adapters.out.persistence.uuid.ID
import skunk.Codec

class MeetupRepositoryImpl(session: Session[IO]) extends MeetupRepository {
  import MeetupSQL._

  def create(meetup: Meetup): IO[Meetup] =
    session
      .prepare(insertMeetupCmd)
      .use(preparedCmd => {
        ID.gen()
          .map(id => meetup.copy(id = Some(id)))
          .flatMap(newMeetup => {
            preparedCmd.execute(newMeetup).as(newMeetup)
          })
      })
}

private object MeetupSQL {
  val codec: Codec[Meetup] = ???

  val insertMeetupCmd =
    sql"""
        INSERT INTO meetup
        VALUES ($codec)
        """.command
}

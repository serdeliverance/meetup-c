package io.github.meetupc

import cats.effect.IOApp
import cats.effect.{ IO, Resource }
import natchez.Trace.Implicits.noop
import io.github.meetupc.config.Database.{ DbConfig, checkPostgresConnection }
import skunk.Session
import io.github.meetupc.adapters.out.migrator.Migrator
import io.github.meetupc.config.Database.checkPostgresConnection

object Main extends IOApp.Simple {

  def run: IO[Unit] = {
    // temporal
    // TODO use resources and finishing setting up
    val r = for {
      _ <- Resource.eval(Migrator.initializeDb(DbConfig("jdbc:postgresql://localhost:45432/meetupdb", "root", "root")))
      pool <- Session
        .pooled[IO](
          host = "localhost",
          port = 45432,
          user = "root",
          password = Some("root"),
          database = "meetupdb",
          max = 10
          )
          .evalTap(checkPostgresConnection)
    } yield pool

    r.use(_ => IO(()))
  }
}

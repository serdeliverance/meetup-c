package io.github.meetupc

import cats.effect.IOApp
import cats.effect.IO
import io.github.meetupc.adapters.in.job.Migration
import io.github.meetupc.adapters.out.migration.DbConfig

object Main extends IOApp.Simple {

  def run: IO[Unit] =
    Migration.initializeDb(DbConfig("jdbc:postgresql://localhost:45432/meetupdb", "root", "root"))
}

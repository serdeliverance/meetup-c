package io.github.meetupc.adapters.in.job

import cats.effect.IO
import org.flywaydb.core.Flyway
import io.github.meetupc.config.Database.DbConfig

object Migration {

  def initializeDb(dbConfig: DbConfig): IO[Unit] =
    IO.delay {
        val fw =
          Flyway
            .configure()
            .dataSource(dbConfig.url, dbConfig.user, dbConfig.password)
            .load()
        fw.migrate()
      }
      .as(())
}

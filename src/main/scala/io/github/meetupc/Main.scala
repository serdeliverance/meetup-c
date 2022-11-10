package io.github.meetupc

import cats.effect.IOApp
import cats.effect.IO

object Main extends IOApp.Simple {

  def run: IO[Unit] =
    IO.delay("hello")
}

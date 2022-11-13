package io.github.meetupc.adapters.out.persistence.uuid

import cats.effect.IO
import java.util.UUID

object ID {
  def gen() = IO.delay(UUID.randomUUID())
}

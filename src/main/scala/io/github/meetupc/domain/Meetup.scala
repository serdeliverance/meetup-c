package io.github.meetupc.domain

import java.time.LocalDateTime
import java.time.Instant
import java.util.UUID

case class Meetup(id: Option[UUID], name: String, attendants: Int, date: Instant)

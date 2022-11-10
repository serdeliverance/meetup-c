package io.github.meetupc.domain

import java.time.LocalDateTime
import java.time.Instant

case class Meetup(id: Long, name: String, attendants: Int, date: Instant)

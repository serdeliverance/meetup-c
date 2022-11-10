package io.github.meetupc.application.port.in

import java.time.Instant

case class CreateMeetupCommand(title: String, attendants: Int, date: Instant)

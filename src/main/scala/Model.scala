package io.metabookmarks.webui.shared

import java.util.UUID

import play.api.libs.json.{Format, Json, Reads, __}

sealed trait Element

case class Bookmark(id: UUID, url: String) extends Element

case class BookmarkSet(id: String, name: String, description: Option[String]) extends Element



import julienrf.json.derived

object Element {
  implicit val format: Format[Element] =
    derived.flat.oformat((__ \ "type").format[String])
}

object Bookmark {
  implicit val read: Reads[Bookmark] = Json.reads[Bookmark]
}

object BookmarkSet {
  implicit val read: Reads[BookmarkSet] = Json.reads[BookmarkSet]
}
package jp.gr.pigumer.nextsibling

import java.io.InputStream
import java.nio.charset.StandardCharsets

import org.specs2.mutable.Specification

import scala.xml.XML

class XMLtoKeyValueSpec extends Specification {

  private def toByteArray(input: InputStream) =
    Stream.continually(input.read).takeWhile(_ != -1).map(_.toByte).toArray

  "XMLtoKeyValue" should {
    "toMap" in {
      val test = Thread.currentThread().getContextClassLoader.getResourceAsStream("test.xml")
      val root = new String(toByteArray(test), StandardCharsets.UTF_8)
      val map = XMLtoKeyValue.toMap(XML.loadString(root))
      map("foo") must_== "FOO"
      map("bar") must_== "BAR"
      map("baz") must_== "BAZ"
    }
  }
}

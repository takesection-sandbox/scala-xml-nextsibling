package jp.gr.pigumer.nextsibling

import scala.annotation.tailrec
import scala.xml._

object XMLtoKeyValue {

  @tailrec
  private def keyValue(nodes: Seq[Node], list: Seq[(String, String)]): Seq[(String, String)] = {
    nodes match {
      case head +: tail ⇒
        val headNode: Node = head
        val nextSibling: Node = tail(0)

        keyValue(tail.drop(1), list :+ (headNode.text -> nextSibling.text))
      case _ ⇒ list
    }
  }

  def toMap(node: Node): Map[String, String] =
    keyValue(node.child.filter(n ⇒ n.isInstanceOf[Elem]), Seq.empty).toMap
}

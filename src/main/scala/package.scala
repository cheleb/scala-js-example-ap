import com.thoughtworks.binding.Binding
import com.thoughtworks.binding.Binding.BindingSeq
import org.scalajs.dom.Node

import scala.xml.{Elem, NodeBuffer}

/**
  * Created by olivier.nouguier@gmail.com on 16/09/2017.
  */
package object test {
  implicit def makeIntellijHappy[T<:org.scalajs.dom.raw.Node](x: scala.xml.Node): Binding[T] =
    throw new AssertionError("This should never execute.")
  implicit def makeIntellijHappy(x: BindingSeq[Elem]): BindingSeq[Node] =
    throw new AssertionError("This should never execute.")
  implicit def mmm(str: String): Binding[String] =
    throw new AssertionError("This should never execute.")
  implicit def nb(nb: NodeBuffer): Binding.BindingSeq[Node] =
    throw new AssertionError("This should never execute.")


}

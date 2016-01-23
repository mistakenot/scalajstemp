package spatutorial.client.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.language.implicitConversions
import scala.scalajs.js
import scalacss.ScalaCssReact._
import scalacss.Defaults._

object SearchInput {
  @inline private def bss = GlobalStyles.bootstrapStyles
  case class Props(
    onSubmit: String => Unit,
    buttonText: String = "Submit",
    defaultValue: String = "Search for...",
    onChange: String => Unit = _ => ()
    //style: CommonStyle.Value = CommonStyle.default
  )

  val component = ReactComponentB[Props]("Panel")
    .renderP((_, p) =>
      <.div(bss.formGroup,
        <.div(bss.inputGroup,
          <.input(bss.formControl, ^.placeholder := p.defaultValue),
          <.span(bss.inputGroupBtn,
            <.button(^.className := "btn btn-default")(
              p.buttonText
            )
          )
        )
      )
    ).build

  def apply(props: Props) = component(props)
}

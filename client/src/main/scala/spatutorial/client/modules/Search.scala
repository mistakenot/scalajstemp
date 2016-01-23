package spatutorial.client.modules

import diode.react.ReactPot._
import diode.react._
import diode.data.Pot
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import spatutorial.client.components.Bootstrap._
import spatutorial.client.components._
import spatutorial.client.logger._
import spatutorial.client.services._
import spatutorial.shared._

import scalacss.ScalaCssReact._

object Search {
  case class Props(searchModel: ModelProxy[SearchModel])
  case class State(searchTerm: String)

  class Backend($: BackendScope[Props, State]) {
    @inline private def bss = GlobalStyles.bootstrapStyles

    def render(p: Props, s: State) = {
      Panel(Panel.Props("Search"),
        <.div(bss.formGroup)(
          <.div(bss.row)(
            <.div(bss.col(6))(
              SearchInput(SearchInput.Props(s => println(s)))
            ),
            <.div(bss.col(6))(
              "world"
            )
          )
        )
      )
    }
  }

  val component = ReactComponentB[Props]("Search")
    .initialState(State(""))
    .renderBackend[Backend]
    .build

  def apply(searchModel: ModelProxy[SearchModel]) = component(Props(searchModel))
}

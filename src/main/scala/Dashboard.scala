package io.metabookmarks.webui

import com.thoughtworks.binding.Binding.{Var, Vars}
import com.thoughtworks.binding.{dom, Binding}

import org.scalajs.dom.raw._
import org.scalajs.dom.{console, DragEvent, Event}

class Dashboard  { 

  @dom
  def listBookmarks: Binding[HTMLDivElement] =
    <div>
      <ul>
        <li>
          <span ondragstart={e: DragEvent =>
}>
            <i>bookmark</i>
          </span> <button onclick={_: Event =>
          }>
          <i>delete</i>
        </button>
          <button onclick={_: Event =>
            
           }>
            <i>edit</i>
          </button>

        </li>
      </ul>

    </div>

  @dom
  def dialogUI(theId: String): Binding[HTMLElement] = <aside id={theId}>
    <div>
      <fieldset>
        
      </fieldset>
     
       </div>
  </aside>


  



  


}

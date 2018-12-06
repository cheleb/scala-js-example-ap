package io.metabookmarks.webui

import com.thoughtworks.binding.Binding.{Var, Vars}
import com.thoughtworks.binding.{dom, Binding}
import io.metabookmarks.webui.shared.{Bookmark, BookmarkSet, Element}
import org.scalajs.dom.raw._
import org.scalajs.dom.{console, DragEvent, Event}


class BookmarkSetForm(var name: String = null, var description: String = null)

class Dashboard(origin: String)  {

  val originService: String = origin

  private val bookmarks = Vars.empty[Bookmark]

  private val sets = Vars.empty[BookmarkSet]

  private def addBookmark(bookmark: Bookmark) = bookmarks.value += bookmark

  private def addSet(s: BookmarkSet) = sets.value += s

  /**
    * Refresh bookmarks and set.
    * <br />
    * Used when navigating through folders.
    *
    * @param elements Element to render
    */
  private def render(elements: List[Element]): Unit = {
    bookmarks.value.clear()
    sets.value.clear()
    elements.foreach {
      case b: Bookmark =>
        addBookmark(b)
      case s: BookmarkSet =>
        addSet(s)
    }
  }

  @dom
  def listBookmarks: Binding[HTMLDivElement] =
    <div>
      <ul class="mdc-list">
        {for (bookmark <- bookmarks) yield {
        <li class="mdc-list-item">
          <span data:draggable="true" ondragstart={e: DragEvent =>
}>
            <i class="mdc-list-item__start-detail material-icons" data:aria-hidden="true">bookmark</i>{if (bookmark.url.indexOf("?") == -1)
            bookmark.url
          else
            bookmark.url.substring(0, bookmark.url.indexOf("?"))}
          </span> <button class="mdc-button" onclick={_: Event =>
          }>
          <i class="material-icons mdc-button__icon">delete</i>
        </button>
          <button class="mdc-button" onclick={_: Event =>
            val form = new BookmarkSetForm
           }>
            <i class="material-icons mdc-button__icon">edit</i>
          </button>

        </li>
      }}
      </ul>

    </div>

  @dom
  def dialogUI(newSet: BookmarkSetForm)(id: String): Binding[HTMLElement] = <aside class="mdc-dialog" id={id}>
    <div class="mdc-dialog__surface">
      <fieldset>
        <form>
          <div class="mdc-form-field">
            <div class="mdc-textfield" data:data-mdc-auto-init="MDCTextfield">
              <label for="name" class="mdc-textfield__label">
                Name
              </label>
              <input id="name" name="name" type="text" class="mdc-textfield__input" onchange={event: Event =>
              newSet.name = event.srcElement.asInstanceOf[HTMLInputElement].value}/>
              <div class="mdc-textfield__bottom-line"></div>
            </div>
          </div>
          <div class="mdc-text-field mdc-text-field--textarea">
            <textarea name="description" id="description" class="mdc-text-field__input" rows={8} cols={40} placeholder="Enter something about yourself" onchange={event: Event =>
              newSet.description = event.srcElement.asInstanceOf[HTMLInputElement].value}></textarea>
          </div>
        </form>
      </fieldset>
      <footer class="mdc-dialog__footer">
        <button type="button" class="mdc-button mdc-dialog__footer__button mdc-dialog__footer__button--cancel">
          Decline</button>
        <button type="button" class="mdc-button mdc-dialog__footer__button mdc-dialog__footer__button--accept mdc-dialog__action">
          Accept</button>
      </footer>
       </div>
  </aside>


  def onDrop(setId: String, va: Binding.Var[String], orig: String): DragEvent => Unit = {
    e =>
  }



  @dom
  def bookmarkSets: Binding[HTMLDivElement] = {

    def enterSet(set: BookmarkSet) : Event => Unit = {
      e: Event =>
        e.preventDefault()
    }

    <div>
      {for (set <- sets) yield {
      val dClass = Var("padded-left")

      <div id={set.id} class={dClass.bind} ondrop={onDrop(set.id, dClass, "padded-left")} ondragenter={e: DragEvent =>
        e.preventDefault()
        dClass.value = "drag-over"}
           ondragover={e: DragEvent =>
             e.preventDefault()}
           ondragleave={e: DragEvent =>
             e.preventDefault()
             if (e.target.asInstanceOf[HTMLElement].id == set.id) {
               dClass value_= "padded-left"
             }}
          >
        <div class="mdc-card mdc-card--theme-dark flipcard">
          <div class="front">
            <section class="mdc-card__primary" onclick={enterSet(set)}>
              <h1 class="mdc-card__title mdc-card__title--small title">
                {set.name}
              </h1>
            </section>
            <section class="mdc-card__actions">
              Lllslslsl sksks sksk skks ksksksksk
            </section>
          </div>
          <div class="back">
            <section class="mdc-card__primary" onclick={enterSet(set)}>
              <h1 class="mdc-card__title mdc-card__title--small title">
                {set.name}
              </h1>
            </section>
            <section class="mdc-card__actions">
              <button class="mdc-button mdc-button--compact mdc-card__action" onclick={_: Event =>
}>
                <i class="material-icons mdc-list-item__start-detail" data:aria-hidden="true">
                  delete</i>
              </button>
            </section>
          </div>
        </div>
      </div>
    }}<div class="new-set">
      <button class="mdc-fab material-icons" data:aria-label="Favorite" onclick={_: Event =>
        }>
        <span class="mdc-fab__icon">
          add
        </span>
      </button>
    </div>
    </div>

  }


}

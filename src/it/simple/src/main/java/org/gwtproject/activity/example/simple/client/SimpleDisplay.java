package org.gwtproject.activity.example.simple.client;

import java.util.function.Consumer;

import org.gwtproject.activity.shared.Activity;

import elemental2.dom.Element;

public class SimpleDisplay implements Consumer<Activity.View> {
  
  private Element displayElement;
  
  public SimpleDisplay(Element displayElement) {
    this.displayElement = displayElement;
  }

  @Override
  public void accept(Activity.View next) {
    Element current = (Element) displayElement.firstChild;

    Element nextElement = next == null ? null : ((SimpleView) next).asElement();

    if (current != null) {
      if (nextElement != null) {
        displayElement.replaceChild(nextElement, current);
      } else {
        displayElement.removeChild(current);
      }
    } else {
      if (nextElement != null) {
        displayElement.appendChild(nextElement);
      }
    }
  }

}

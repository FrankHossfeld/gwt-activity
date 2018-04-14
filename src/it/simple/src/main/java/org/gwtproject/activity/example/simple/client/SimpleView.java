package org.gwtproject.activity.example.simple.client;

import org.gwtproject.activity.shared.Activity.View;

import elemental2.dom.Element;

public class SimpleView implements View {
  private final Element element;

  public SimpleView(Element element) {
    this.element = element;
  }

  public Element asElement() {
    return element;
  }
}

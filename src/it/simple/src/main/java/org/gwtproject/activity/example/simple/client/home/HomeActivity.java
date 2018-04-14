package org.gwtproject.activity.example.simple.client.home;

import static elemental2.dom.DomGlobal.document;

import java.util.function.Consumer;

import org.gwtproject.activity.example.simple.client.SimpleView;
import org.gwtproject.activity.shared.AbstractActivity;
import org.gwtproject.activity.shared.Activity;

import com.google.gwt.event.shared.EventBus;

import elemental2.dom.HTMLElement;

public class HomeActivity extends AbstractActivity implements Activity {

  @Override
  public void start(Consumer<View> container, EventBus eventBus) {
    HTMLElement span = (HTMLElement) document.createElement("span");
    span.innerHTML = "Home (redirecting to About)";
    
    container.accept(new SimpleView(span));
  }

}

package org.gwtproject.activity.example.simple.client.about;

import java.util.function.Consumer;

import org.gwtproject.activity.example.simple.client.SimpleView;
import org.gwtproject.activity.shared.AbstractActivity;
import org.gwtproject.activity.shared.Activity;

import com.google.gwt.event.shared.EventBus;

import elemental2.dom.HTMLElement;

import static elemental2.dom.DomGlobal.document;

public class AboutActivity extends AbstractActivity implements Activity {

  private AboutPlace place;
  
  public AboutActivity(AboutPlace place) {
    this.place = place;
  }

  @Override
  public void start(Consumer<View> container, EventBus eventBus) {
    String param = place.getParam();
    if (param == null) { param = "empty"; }
    
    HTMLElement span = (HTMLElement) document.createElement("span");
    span.innerHTML = "About (" + param + ")";
    
    container.accept(new SimpleView(span));
  }

}

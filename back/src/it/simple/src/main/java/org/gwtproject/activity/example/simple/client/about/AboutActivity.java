package org.gwtproject.activity.example.simple.client.about;

import org.gwtproject.activity.shared.AbstractActivity;
import org.gwtproject.activity.shared.Activity;
import org.gwtproject.event.shared.EventBus;
import org.gwtproject.user.client.ui.AcceptsOneWidget;

import com.google.gwt.user.client.ui.Label;

public class AboutActivity extends AbstractActivity implements Activity {

  private AboutPlace place;
  
  public AboutActivity(AboutPlace place) {
    this.place = place;
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    String param = place.getParam();
    if (param == null) { param = "empty"; }
    
    Label label = new Label("About (" + param + ")");
    
    panel.setWidget(label::asWidget); // temporary workaround
  }

}

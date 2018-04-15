package org.gwtproject.activity.example.simple.client.home;

import org.gwtproject.activity.shared.AbstractActivity;
import org.gwtproject.activity.shared.Activity;
import org.gwtproject.event.shared.EventBus;
import org.gwtproject.user.client.ui.AcceptsOneWidget;

import com.google.gwt.user.client.ui.Label;

public class HomeActivity extends AbstractActivity implements Activity {

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    Label label = new Label("Home (redirecting to About)");
    
    panel.setWidget(label::asWidget); // temporary workaround
  }

}

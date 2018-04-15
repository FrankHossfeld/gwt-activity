package org.gwtproject.activity.example.simple.client;

import org.gwtproject.activity.example.simple.client.about.AboutPlace;
import org.gwtproject.activity.example.simple.client.home.HomePlace;
import org.gwtproject.activity.shared.ActivityManager;
import org.gwtproject.activity.shared.ActivityMapper;
import org.gwtproject.event.shared.EventBus;
import org.gwtproject.event.shared.SimpleEventBus;
import org.gwtproject.place.shared.Place;
import org.gwtproject.place.shared.PlaceController;
import org.gwtproject.place.shared.PlaceHistoryHandler;
import org.gwtproject.place.shared.PlaceHistoryMapper;
import org.gwtproject.timer.client.Timer;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class SimpleEntry implements EntryPoint {

  @Override
  public void onModuleLoad() {
    SimplePanel display = new SimplePanel();

    EventBus eventBus = new SimpleEventBus();

    ActivityMapper activityMapper = new SimpleActivityMapper();
    ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
    
    //temporary workaround
    activityManager.setDisplay((iw) -> display.setWidget(iw == null ? null : iw::asWidget));

    PlaceController placeController = new PlaceController(eventBus);
    PlaceHistoryMapper placeHistoryMapper = new SimplePlaceHistoryMapperImpl();
    PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(placeHistoryMapper);
    Place defaultPlace = new HomePlace();

    historyHandler.register(placeController, eventBus, defaultPlace);

    RootPanel.get().add(display);
    historyHandler.handleCurrentHistory();

    new Timer() {
      @Override
      public void run() {
        placeController.goTo(new AboutPlace("timer"));
      }
    }.schedule(5000);
  }

}

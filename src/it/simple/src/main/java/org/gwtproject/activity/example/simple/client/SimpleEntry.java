package org.gwtproject.activity.example.simple.client;

import static elemental2.dom.DomGlobal.document;

import org.gwtproject.activity.example.simple.client.about.AboutPlace;
import org.gwtproject.activity.example.simple.client.home.HomePlace;
import org.gwtproject.activity.shared.ActivityManager;
import org.gwtproject.activity.shared.ActivityMapper;
import org.gwtproject.event.shared.EventBus;
import org.gwtproject.event.shared.SimpleEventBus;

import com.google.gwt.core.client.EntryPoint;
import org.gwtproject.place.shared.Place;
import org.gwtproject.place.shared.PlaceController;
import org.gwtproject.place.shared.PlaceHistoryHandler;
import org.gwtproject.place.shared.PlaceHistoryMapper;

import com.google.gwt.user.client.Timer;

import elemental2.dom.Element;

public class SimpleEntry implements EntryPoint {

  @Override
  public void onModuleLoad() {
    Element displayElement = (Element) document.createElement("div");

    EventBus eventBus = new SimpleEventBus();

    ActivityMapper activityMapper = new SimpleActivityMapper();
    ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
    activityManager.setDisplay(new SimpleDisplay(displayElement));

    PlaceController placeController = new PlaceController(eventBus);
    PlaceHistoryMapper placeHistoryMapper = new SimplePlaceHistoryMapperImpl();
    PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(placeHistoryMapper);
    Place defaultPlace = new HomePlace();

    historyHandler.register(placeController, eventBus, defaultPlace);

    document.body.appendChild(displayElement);
    historyHandler.handleCurrentHistory();

    new Timer() {
      @Override
      public void run() {
        placeController.goTo(new AboutPlace("timer"));
      }
    }.schedule(5000);
  }

}

package org.gwtproject.activity.example.simple.client;

import static elemental2.dom.DomGlobal.document;

import org.gwtproject.activity.example.simple.client.about.AboutPlace;
import org.gwtproject.activity.example.simple.client.home.HomePlace;
import org.gwtproject.activity.shared.ActivityManager;
import org.gwtproject.activity.shared.ActivityMapper;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Timer;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

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
    SimplePlaceHistoryMapper placeHistoryMapper = GWT.create(SimplePlaceHistoryMapper.class);
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

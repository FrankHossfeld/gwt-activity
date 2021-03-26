/*
 * Copyright © 2018 The GWT Project Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

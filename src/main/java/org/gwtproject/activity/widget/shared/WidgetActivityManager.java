/*
 * Copyright 2010 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.gwtproject.activity.widget.shared;

import org.gwtproject.activity.shared.ActivityManager;
import org.gwtproject.event.shared.EventBus;
import org.gwtproject.place.shared.PlaceChangeEvent;
import org.gwtproject.place.shared.PlaceChangeRequestEvent;
import org.gwtproject.user.client.ui.AcceptsOneWidget;
import org.gwtproject.user.client.ui.IsWidget;

/**
 * <p>Drop-in replacement for {@link com.google.gwt.activity.shared.ActivityManager}.</p>
 * 
 * <p>Note: wraps {@link org.gwtproject.activity.shared.ActivityManager} rather than
 * extending it which prevents casting between {@link ActivityManager} and
 * {@link WidgetActivityManager}. Two alternatives exist:</p>
 * 
 *  <ul>
 *    <li>access wrapped {@link ActivityManager} via {@link #getDelegateManager()}
 *    <li>provide your own {@link ActivityManager}-derived implementation
 *  <ul>
 */
public class WidgetActivityManager implements PlaceChangeEvent.Handler,
  PlaceChangeRequestEvent.Handler {

  private final ActivityManager<IsWidget> delegate;
  
  public WidgetActivityManager(WidgetActivityMapper mapper, EventBus eventBus) {
    delegate = new ActivityManager<>(mapper, eventBus);
  }

  @Override
  public void onPlaceChangeRequest(PlaceChangeRequestEvent event) {
    delegate.onPlaceChangeRequest(event);
  }

  @Override
  public void onPlaceChange(PlaceChangeEvent event) {
    delegate.onPlaceChange(event);
  }

  /**
  * Returns wrapped {@link ActivityManager<IsWidget>}.
  */
  public ActivityManager<IsWidget> getDelegateManager() {
    return delegate;
  }
  
  /**
  * Returns an event bus which is in use by the currently running activity.
  * <p>
  * Any handlers attached to the returned event bus will be de-registered when
  * the current activity is stopped.
  *
  * @return the event bus used by the current activity
  */
  public EventBus getActiveEventBus() {
    return delegate.getActiveEventBus();
  }

  /**
   * Sets the display for the receiver, and has the side effect of starting or
   * stopping its monitoring the event bus for place change events.
   * <p>
   * If you are disposing of an ActivityManager, it is important to call
   * setDisplay(null) to get it to de-register from the event bus, so that it can
   * be garbage collected.
   * 
   * @param display an instance of AcceptsOneWidget
   */
  public void setDisplay(AcceptsOneWidget display) {
    delegate.setDisplay(display == null ? null : display::setWidget);
  }

}

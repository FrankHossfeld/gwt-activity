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

import org.gwtproject.activity.shared.ActivityDisplay;
import org.gwtproject.activity.shared.ActivityManager;
import org.gwtproject.event.shared.EventBus;
import org.gwtproject.user.client.ui.AcceptsOneWidget;
import org.gwtproject.user.client.ui.IsWidget;

/**
 * Drop-in replacement for {@link com.google.gwt.activity.shared.ActivityManager}.
 */
public class WidgetActivityManager extends ActivityManager<IsWidget> {

  private AcceptsOneWidget widgetDisplay;

  private ActivityDisplay<IsWidget> wrapperDisplay;

  public WidgetActivityManager(WidgetActivityMapper mapper, EventBus eventBus) {
    super(mapper, eventBus);
  }

  public void setDisplay(AcceptsOneWidget display) {
    // since ActivityManager holds a reference to passed display,
    // make sure we return same ActivityDisplay for same AcceptsOneWidget
    // NOTE: ActivityManager really doesn't care for instance eqaulity,
    // all it cares is transitions to/from null, so possible simplification
    // could be to provide new wrapper in each call 
    if (display == null) {
      wrapperDisplay = null;
    } else if (display != widgetDisplay) {
      widgetDisplay = display;
      wrapperDisplay = display::setWidget;
    }
    super.setDisplay(wrapperDisplay);
  }

}
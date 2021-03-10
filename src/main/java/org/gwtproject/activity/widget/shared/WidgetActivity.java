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

import org.gwtproject.activity.shared.Activity;
import org.gwtproject.activity.shared.ActivityDisplay;
import org.gwtproject.event.shared.EventBus;
import org.gwtproject.user.client.ui.AcceptsOneWidget;
import org.gwtproject.user.client.ui.IsWidget;

/**
 * Drop-in replacement for {@link com.google.gwt.activity.shared.Activity}.
 */
public interface WidgetActivity extends Activity<IsWidget> {

  default void start(ActivityDisplay<IsWidget> panel, EventBus eventBus) {
    start((AcceptsOneWidget) panel::show, eventBus);
  }

  void start(AcceptsOneWidget panel, EventBus eventBus);

}

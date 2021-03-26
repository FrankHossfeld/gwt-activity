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
package org.gwtproject.activity.example.simple.client.home;

import org.gwtproject.activity.shared.AbstractActivity;
import org.gwtproject.activity.shared.Activity;
import org.gwtproject.event.shared.EventBus;
import org.gwtproject.user.client.ui.AcceptsOneWidget;

import org.gwtproject.user.client.ui.Label;

public class HomeActivity extends AbstractActivity implements Activity {

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    Label label = new Label("Home (redirecting to About)");
    
    panel.setWidget(label::asWidget); // temporary workaround
  }

}

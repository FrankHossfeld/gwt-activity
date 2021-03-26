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

import org.gwtproject.activity.example.simple.client.about.AboutActivity;
import org.gwtproject.activity.example.simple.client.about.AboutPlace;
import org.gwtproject.activity.example.simple.client.home.HomeActivity;
import org.gwtproject.activity.example.simple.client.home.HomePlace;
import org.gwtproject.activity.shared.Activity;
import org.gwtproject.activity.shared.ActivityMapper;
import org.gwtproject.place.shared.Place;

public class SimpleActivityMapper implements ActivityMapper {

  @Override
  public Activity getActivity(Place place) {
    if (place instanceof HomePlace) {
      return new HomeActivity();
    }
    
    if (place instanceof AboutPlace) {
      return new AboutActivity((AboutPlace)place);
    }
    
    return null;
  }
}

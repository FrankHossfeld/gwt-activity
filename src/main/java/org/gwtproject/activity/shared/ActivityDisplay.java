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
package org.gwtproject.activity.shared;

import org.gwtproject.activity.widget.shared.WidgetActivityDisplay;

/** Display used to show views of type {@code V}.
 * 
 * @param <V> view type ({@code IsWidget}, {@code HTMLElement}, ...)
 */
public interface ActivityDisplay<V> {

  /**
   * Set the element to display, replacing the previously displayed
   * element if there was one.
   *
   * @param view object to display, or <code>null</code> to clear display
   *
   * @see WidgetActivityDisplay
   */
  void show(V view);

}

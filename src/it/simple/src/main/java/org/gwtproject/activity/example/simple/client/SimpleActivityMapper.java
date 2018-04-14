package org.gwtproject.activity.example.simple.client;

import org.gwtproject.activity.example.simple.client.about.AboutActivity;
import org.gwtproject.activity.example.simple.client.about.AboutPlace;
import org.gwtproject.activity.example.simple.client.home.HomeActivity;
import org.gwtproject.activity.example.simple.client.home.HomePlace;
import org.gwtproject.activity.shared.Activity;
import org.gwtproject.activity.shared.ActivityMapper;

import com.google.gwt.place.shared.Place;

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

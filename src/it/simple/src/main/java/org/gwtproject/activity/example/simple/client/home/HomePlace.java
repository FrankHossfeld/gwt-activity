package org.gwtproject.activity.example.simple.client.home;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class HomePlace extends Place {
  
  // not parametrized

  @Prefix("home")
  public static class Tokenizer implements PlaceTokenizer<HomePlace> {

    @Override
    public HomePlace getPlace(String token) {
      return null;
    }

    @Override
    public String getToken(HomePlace place) {
      return null;
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) { return true; }
    if (obj == null) { return false; }
    if (getClass() != obj.getClass()) { return false; }
    return true;
  }
  
  @Override
  public int hashCode() {
    return 0;
  }
}

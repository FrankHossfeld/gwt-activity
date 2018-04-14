package org.gwtproject.activity.example.simple.client.about;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class AboutPlace extends Place {
  
  @Prefix("about")
  public static class Tokenizer implements PlaceTokenizer<AboutPlace> {

    @Override
    public AboutPlace getPlace(String token) {
      return new AboutPlace(token);
    }

    @Override
    public String getToken(AboutPlace place) {
      return place.getParam();
    }
  }

  /**
   * Sample param of the place, could be id of the item being displayed (for detail view)
   */
  private final String param;
  
  public AboutPlace(String param) {
    this.param = param;
  }

  public String getParam() {
    return param;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((param == null) ? 0 : param.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AboutPlace other = (AboutPlace) obj;
    if (param == null) {
      if (other.param != null)
        return false;
    } else if (!param.equals(other.param))
      return false;
    return true;
  }
}

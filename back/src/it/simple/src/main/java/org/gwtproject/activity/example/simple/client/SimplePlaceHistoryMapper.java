package org.gwtproject.activity.example.simple.client;

import org.gwtproject.activity.example.simple.client.about.AboutPlace;
import org.gwtproject.activity.example.simple.client.home.HomePlace;
import org.gwtproject.place.shared.PlaceHistoryMapper;
import org.gwtproject.place.shared.WithTokenizers;

@WithTokenizers({ HomePlace.Tokenizer.class, AboutPlace.Tokenizer.class })
public interface SimplePlaceHistoryMapper extends PlaceHistoryMapper {

}

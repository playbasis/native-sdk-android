package com.playbasis.pbcore.rest.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.playbasis.pbcore.domain.model.Birthdate;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class GsonBirthdateAdapter implements JsonSerializer<Birthdate>, JsonDeserializer<Birthdate> {

  public static final String TAG = "GsonBirthdateAdapter";
  private final DateFormat dateFormat;

  public GsonBirthdateAdapter() {
    dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
  }

  @Override
  public synchronized JsonElement serialize(Birthdate date, Type type,
JsonSerializationContext jsonSerializationContext) {
    return new JsonPrimitive(dateFormat.format(date));
  }

  @Override
  public synchronized Birthdate deserialize(JsonElement jsonElement, Type type,
                                       JsonDeserializationContext jsonDeserializationContext) {
    try {
      Date date = dateFormat.parse(jsonElement.getAsString());
      return new Birthdate(date);
    } catch (ParseException e) {
      throw new JsonParseException(e);
    }
  }
}

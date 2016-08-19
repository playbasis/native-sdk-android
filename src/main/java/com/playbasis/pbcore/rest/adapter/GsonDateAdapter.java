package com.playbasis.pbcore.rest.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by gregoire barret on 5/14/15.
 * For MasuProj project.
 * <p/>
 * Parse the date to string and the string to Date of json parsing.
 */
public class GsonDateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

  public static final String TAG = "GsonDateAdapter";
  private final DateFormat dateFormat;

  /**
   * Constructor of the Type adapter, the date is on the yyyy-MM-dd'T'HH:mm:ssZ" format.
   */
  public GsonDateAdapter() {
    dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
    dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
  }

  /**
   * Constructor of the Type adapter.
   */
  public GsonDateAdapter(String format) {
    dateFormat = new SimpleDateFormat(format, Locale.US);
    dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
  }

  /**
   * Serialise the {@link Date} object into {@link JsonElement}
   *
   * @param date                     date to serialize
   * @param type                     Not used
   * @param jsonSerializationContext Not used
   * @return String JsonElement for set the date into json
   */
  @Override
  public synchronized JsonElement serialize(Date date, Type type,
                                            JsonSerializationContext jsonSerializationContext) {
    return new JsonPrimitive(dateFormat.format(date));
  }

  /**
   * Deserialize the {@link JsonElement} date string into {@link Date}
   *
   * @param jsonElement                string date to deserialize
   * @param type                       not used
   * @param jsonDeserializationContext not used
   * @return {@link Date} object
   */
  @Override
  public synchronized Date deserialize(JsonElement jsonElement, Type type,
                                       JsonDeserializationContext jsonDeserializationContext) {
    try {
      return dateFormat.parse(jsonElement.getAsString());
    } catch (ParseException e) {
      throw new JsonParseException(e);
    }
  }
}

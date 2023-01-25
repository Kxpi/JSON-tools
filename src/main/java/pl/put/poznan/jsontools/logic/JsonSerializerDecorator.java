package pl.put.poznan.jsontools.logic;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Abstract class used as a base for all serializers that decorate other ones */
public abstract class JsonSerializerDecorator implements JsonSerializer {

  JsonSerializer jsonSerializer;
  List<String> strings;

  /**
   * Creates a JsonSerializerDecorator object
   *
   * @param jsonSerializer serializer used to return parsed json
   * @param strings array of strings
   */
  JsonSerializerDecorator(JsonSerializer jsonSerializer, String[] strings) {
    this.jsonSerializer = jsonSerializer;
    this.strings = new ArrayList<>(Arrays.asList(strings));
  }

  /** Abstract method that serialize given JSON */
  public abstract String serialize(JsonNode jsonNode);
}

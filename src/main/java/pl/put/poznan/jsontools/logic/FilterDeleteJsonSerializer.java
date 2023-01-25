package pl.put.poznan.jsontools.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

/** Class that manages deleting properties from JSON file */
public class FilterDeleteJsonSerializer extends JsonSerializerDecorator {
  private static final Logger logger = LoggerFactory.getLogger(FilterDeleteJsonSerializer.class);

  /**
   * Creates a FilterDeleteJsonSerializer object
   *
   * @param jsonSerializer serializer used to return parsed json
   * @param strings array of kept JSON parameters
   */
  FilterDeleteJsonSerializer(JsonSerializer jsonSerializer, String[] strings) {
    super(jsonSerializer, strings);
    logger.debug("Created FilterDeleteJsonSerializer object");
  }

  /**
   * Method that deletes specified parameters of JSON file
   *
   * @param jsonNode formatted JSON file
   * @return serialized JSON file in String format
   */
  @Override
  public String serialize(JsonNode jsonNode) {
    logger.debug("Deleting specified properties of given JSON");
    List<String> keys = new ArrayList<>();
    Iterator<String> iterator = jsonNode.fieldNames();
    iterator.forEachRemaining(e -> keys.add(e));
    ObjectNode objectNode = (ObjectNode) jsonNode;
    for (String key : keys) {
      if (strings.contains(key)) {
        objectNode.remove(key);
      }
    }
    return jsonSerializer.serialize(objectNode);
  }
}

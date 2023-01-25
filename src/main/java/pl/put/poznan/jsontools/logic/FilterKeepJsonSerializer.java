package pl.put.poznan.jsontools.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** Class that manages deleting properties from JSON file */
public class FilterKeepJsonSerializer extends JsonSerializerDecorator {

  private static final Logger logger = LoggerFactory.getLogger(FilterKeepJsonSerializer.class);

  /**
   * Creates a FilterKeepJsonSerializer object
   *
   * @param jsonSerializer serializer used to return parsed json
   * @param strings array of kept JSON parameters
   */
  FilterKeepJsonSerializer(JsonSerializer jsonSerializer, String[] strings) {
    super(jsonSerializer, strings);
    logger.debug("Created FilterKeepJsonSerializer object");
  }

  /**
   * Method that deletes omitted parameters of JSON file
   *
   * @param jsonNode formatted JSON file
   * @return serialized JSON file in String format
   */
  @Override
  public String serialize(JsonNode jsonNode) {
    logger.debug("Deleting omitted properties of given JSON");
    List<String> keys = new ArrayList<>();
    Iterator<String> iterator = jsonNode.fieldNames();
    iterator.forEachRemaining(e -> keys.add(e));
    ObjectNode objectNode = (ObjectNode) jsonNode;
    for (String key : keys) {
      if (!strings.contains(key)) {
        objectNode.remove(key);
      }
    }
    return jsonSerializer.serialize(objectNode);
  }
}

package pl.put.poznan.jsontools.logic;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Usage: new MinifyJsonSerializer().serialize(jsonNode);
 */
public class MinifyJsonSerializer implements JsonSerializer {
    @Override
    public String serialize(JsonNode jsonNode) {
        return jsonNode.toString();
    }
}

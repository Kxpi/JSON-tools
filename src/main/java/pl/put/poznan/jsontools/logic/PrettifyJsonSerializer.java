package pl.put.poznan.jsontools.logic;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Usage: new PrettifyJsonSerializer().serialize(jsonNode);
 */
public class PrettifyJsonSerializer implements JsonSerializer {
    @Override
    public String serialize(JsonNode jsonNode) {
        return jsonNode.toPrettyString();
    }
}

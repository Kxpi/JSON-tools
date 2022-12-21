package pl.put.poznan.jsontools.logic;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * An interface for all JSON serializers
 */
public interface JsonSerializer {

    /**
     * Serializes the object into a JSON string
     * @param jsonNode The object to be serialized
     * @return A JSON representation of the object
     */
    String serialize(JsonNode jsonNode);
}

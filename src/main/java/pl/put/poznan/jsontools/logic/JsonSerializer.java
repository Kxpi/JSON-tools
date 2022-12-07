package pl.put.poznan.jsontools.logic;

import com.fasterxml.jackson.databind.JsonNode;

public interface JsonSerializer {

    String serialize(JsonNode jsonNode);
}

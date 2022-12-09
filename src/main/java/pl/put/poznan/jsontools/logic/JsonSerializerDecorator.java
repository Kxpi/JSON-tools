package pl.put.poznan.jsontools.logic;

import com.fasterxml.jackson.databind.JsonNode;

public abstract class JsonSerializerDecorator {

    JsonSerializer jsonSerializer;
    String[] strings;

    JsonSerializerDecorator(JsonSerializer jsonSerializer, String[] strings){
        this.jsonSerializer = jsonSerializer;
        this.strings = strings;
    }

    public abstract String serialize(JsonNode jsonNode);
}

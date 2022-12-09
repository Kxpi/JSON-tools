package pl.put.poznan.jsontools.logic;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class JsonSerializerDecorator {

    JsonSerializer jsonSerializer;
    List<String> strings;

    JsonSerializerDecorator(JsonSerializer jsonSerializer, String[] strings){
        this.jsonSerializer = jsonSerializer;
        this.strings = new ArrayList<>(Arrays.asList(strings));
    }

    public abstract String serialize(JsonNode jsonNode);
}

package pl.put.poznan.jsontools.logic;

import com.fasterxml.jackson.databind.JsonNode;

public class ValueTypesJsonSerializer extends JsonSerializerDecorator {
    ValueTypesJsonSerializer(JsonSerializer jsonSerializer, String[] strings) {
        super(jsonSerializer, strings);
    }

    @Override
    public String serialize(JsonNode jsonNode) {
        // TODO: iterate over the jsonNode and create a new JsonNode object
        //       to be serialized
        return jsonSerializer.serialize(jsonNode);
    }
}

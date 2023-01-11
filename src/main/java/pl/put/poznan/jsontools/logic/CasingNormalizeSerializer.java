package pl.put.poznan.jsontools.logic;

import com.fasterxml.jackson.databind.JsonNode;

public class CasingNormalizeSerializer extends JsonSerializerDecorator {
    CasingNormalizeSerializer(JsonSerializer jsonSerializer, String[] strings) {
        super(jsonSerializer, strings);
    }

    @Override
    public String serialize(JsonNode jsonNode) {
        // TODO: implement
        return jsonSerializer.serialize(jsonNode);
    }
}

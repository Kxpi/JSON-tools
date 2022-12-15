package pl.put.poznan.jsontools.logic;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.*;

public class FilterDeleteJsonSerializer extends JsonSerializerDecorator {
    FilterDeleteJsonSerializer(JsonSerializer jsonSerializer, String[] strings) {
        super(jsonSerializer, strings);
    }

    @Override
    public String serialize(JsonNode jsonNode) {
        // TODO: test if this shi works
        List<String> keys = new ArrayList<>();
        Iterator<String> iterator = jsonNode.fieldNames();
        iterator.forEachRemaining(e -> keys.add(e));
        ObjectNode objectNode = (ObjectNode) jsonNode;
        for (String key : keys) {
            if (strings.contains(key)){
                objectNode.remove(key);
            }
        }
        return jsonSerializer.serialize(objectNode);
    }

}

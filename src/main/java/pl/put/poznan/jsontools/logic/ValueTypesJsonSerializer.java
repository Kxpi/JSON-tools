package pl.put.poznan.jsontools.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import pl.put.poznan.jsontools.logic.types.TypeDetector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ValueTypesJsonSerializer extends JsonSerializerDecorator {

    private static final Logger logger = LoggerFactory.getLogger(FilterKeepJsonSerializer.class);

    ValueTypesJsonSerializer(JsonSerializer jsonSerializer, String[] strings) {
        super(jsonSerializer, strings);
    }

    @Override
    public String serialize(JsonNode jsonNode) {
        logger.debug("Changing values to types");
        List<String> keys = new ArrayList<>();
        Iterator<String> iterator = jsonNode.fieldNames();
        iterator.forEachRemaining(e -> keys.add(e));
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        for (String key : keys) {
            objectNode.put(key, TypeDetector.getTypeForNode(jsonNode.path(key)).toString());
        }
        return jsonSerializer.serialize(objectNode);
    }
}

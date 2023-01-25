package pl.put.poznan.jsontools.logic;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CasingNormalizeSerializer extends JsonSerializerDecorator {

    private static final Logger logger = LoggerFactory.getLogger(FilterDeleteJsonSerializer.class);
    CasingNormalizeSerializer(JsonSerializer jsonSerializer, String[] strings) {
        super(jsonSerializer, strings);
        logger.debug("Created CasingNormalizeSerializer object");
    }

    @Override
    public String serialize(JsonNode jsonNode) {
        // TODO: implement
        logger.debug("Normalizing key casing");
        return jsonSerializer.serialize(jsonNode);
    }
}

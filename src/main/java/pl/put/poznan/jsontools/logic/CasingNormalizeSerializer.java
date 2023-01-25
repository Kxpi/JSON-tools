package pl.put.poznan.jsontools.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.jsontools.logic.casings.CaseCoder;
import pl.put.poznan.jsontools.logic.casings.CaseCoderFactory;
import pl.put.poznan.jsontools.logic.casings.CasingDetector;
import pl.put.poznan.jsontools.logic.casings.CasingScheme;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CasingNormalizeSerializer extends JsonSerializerDecorator {

    private static final Logger logger = LoggerFactory.getLogger(CasingNormalizeSerializer.class);
    CaseCoderFactory caseCoderFactory;
    CaseCoder newCaseCoder;

    CasingNormalizeSerializer(JsonSerializer jsonSerializer, String[] strings) {
        super(jsonSerializer, strings);
        CasingScheme newCasingScheme;
        logger.debug(strings[0]);
        switch (strings[0]) {
            case "snake":
                newCasingScheme = CasingScheme.SNAKE_CASE;
            case "camel":
                newCasingScheme = CasingScheme.CAMEL_CASE;
            default:
                logger.debug("Unknown casing type");
                newCasingScheme = CasingScheme.UNKNOWN;
        }
        caseCoderFactory = new CaseCoderFactory();
        newCaseCoder = caseCoderFactory.create(newCasingScheme);
        logger.debug("Created CasingNormalizeSerializer object");
    }

    @Override
    public String serialize(JsonNode jsonNode) {
        // TODO: implement
        logger.debug("Normalizing key casing");
        List<String> keys = new ArrayList<>();
        Iterator<String> iterator = jsonNode.fieldNames();
        iterator.forEachRemaining(e -> keys.add(e));
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        CasingDetector casingDetector = new CasingDetector();
        for (String oldKey : keys) {
            CasingScheme oldCasingScheme = casingDetector.detectCasingScheme(oldKey);
            CaseCoder oldCaseCoder = caseCoderFactory.create(oldCasingScheme);
            String[] words = oldCaseCoder.decode(oldKey);
            String newKey = newCaseCoder.encode(words);
            logger.debug(newKey);
            logger.debug(words[0]);
            objectNode.put(newKey, jsonNode.get(oldKey));
        }

        return jsonSerializer.serialize(objectNode);
    }
}

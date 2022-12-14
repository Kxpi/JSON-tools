package pl.put.poznan.jsontools.rest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.jsontools.logic.BasicSerializerFactory;
import pl.put.poznan.jsontools.logic.CompoundSerializerFactory;
import pl.put.poznan.jsontools.logic.JsonSerializer;

import java.util.Arrays;


@RestController
@RequestMapping("/json")
public class JsonToolsController {

    private static final Logger logger = LoggerFactory.getLogger(JsonToolsController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(
            @RequestBody String inputJson,
            @RequestParam(name="format", defaultValue="minified") String format,
            @RequestParam(name="action", defaultValue="echo") String action) throws JsonProcessingException {

        // log the parameters
        logger.debug(format);
        logger.debug(action);

        // Deserialize the JSON
        // TODO: Handle exceptions and remove `throws` from signature
        ObjectMapper mapper = new ObjectMapper();
        JsonNode parsedJson = mapper.readTree(inputJson);

        // Prepare serializer based on the request
        BasicSerializerFactory bsFactory = new BasicSerializerFactory();
        CompoundSerializerFactory csFactory = new CompoundSerializerFactory();

        // First, create base serializer (one that converts an object to JSON)
        // And then, extend its functionality by making more complex serializer over it
        JsonSerializer serializer;
        serializer = bsFactory.create(format);
        serializer = csFactory.create(action, serializer);

        // Perform transforms here...
        // outputJson = serializer.serialize(parsedJson);
        String outputJson = mapper.writeValueAsString(parsedJson);

        return outputJson;
    }
}



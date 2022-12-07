package pl.put.poznan.jsontools.rest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
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
            @RequestParam(name="transforms", defaultValue="echo") String[] transforms) throws JsonProcessingException {

        // log the parameters
        logger.debug(format);
        logger.debug(Arrays.toString(transforms));

        // Deserialize the JSON
        // TODO: Handle exceptions and remove `throws` from signature
        ObjectMapper mapper = new ObjectMapper();
        JsonNode parsedJson = mapper.readTree(inputJson);

        // Prepare serializer based on the request
        // Maybe: Create a serializer factory?
        JsonSerializer serializer = null;

        // Perform transforms here...
        // outputJson = serializer.serialize(parsedJson);
        String outputJson = mapper.writeValueAsString(parsedJson);

        return outputJson;
    }
}



package pl.put.poznan.jsontools.rest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.put.poznan.jsontools.logic.BasicSerializerFactory;
import pl.put.poznan.jsontools.logic.CompoundSerializerFactory;
import pl.put.poznan.jsontools.logic.JsonSerializer;

import java.security.InvalidParameterException;
import java.util.Arrays;


@RestController
@RequestMapping("/json")
public class JsonToolsController {

    private static final Logger logger = LoggerFactory.getLogger(JsonToolsController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(
            @RequestBody String inputJson,
            @RequestParam(name="format", defaultValue="minified") String format,
            @RequestParam(name="action", defaultValue="echo") String action) {

        // log the parameters
        logger.info("New incoming request");
        logger.debug("Requested format: " + format + ", action(s) to perform: " + action);

        // Deserialize the JSON
        String outputJson;
        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode parsedJson = mapper.readTree(inputJson);

            // Prepare serializer based on the request
            BasicSerializerFactory bsFactory = new BasicSerializerFactory();
            CompoundSerializerFactory csFactory = new CompoundSerializerFactory();

            // First, create base serializer (one that converts an object to JSON)
            // And then, extend its functionality by making a more complex serializer over it
            JsonSerializer serializer;
            serializer = bsFactory.create(format);
            serializer = csFactory.create(action, serializer);

            // Perform transforms here
            outputJson = serializer.serialize(parsedJson);
        }catch(JsonProcessingException e){
            logger.warn("Invalid JSON was sent with the request");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "The requested JSON is not well-formed.", e);
        }catch(InvalidParameterException e){
            logger.warn("Invalid action was requested: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    e.getMessage(), e);
        }

        logger.info("Processing finished successfully");
        return outputJson;
    }
}



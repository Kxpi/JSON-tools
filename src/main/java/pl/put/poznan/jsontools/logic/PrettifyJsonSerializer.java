package pl.put.poznan.jsontools.logic;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for formatting JSON output as string
 */
public class PrettifyJsonSerializer implements JsonSerializer {

    private static final Logger logger = LoggerFactory.getLogger(PrettifyJsonSerializer.class);

    public PrettifyJsonSerializer() {
        logger.debug("Created PrettifyJsonSerializer");
    }

    /**
     * Converts a JSON to a String
     * @param jsonNode JSON to convert
     * @return prettified String
     */
    @Override
    public String serialize(JsonNode jsonNode) {
        logger.debug("Prettifying JSON");
        return jsonNode.toPrettyString();
    }
}

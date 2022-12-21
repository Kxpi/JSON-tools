package pl.put.poznan.jsontools.logic;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for formatting JSON output as a minified string
 */
public class MinifyJsonSerializer implements JsonSerializer {

    private static final Logger logger = LoggerFactory.getLogger(MinifyJsonSerializer.class);

    public MinifyJsonSerializer() {
        logger.debug("Created MinifyJsonSerializer");
    }

    /**
     * Converts a JSON to a String
     * @param jsonNode JSON to convert
     * @return minified String
     */
    @Override
    public String serialize(JsonNode jsonNode) {
        logger.debug("Minifying JSON");
        return jsonNode.toString();
    }
}

package pl.put.poznan.jsontools.logic;

import java.security.InvalidParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Class that manages the creation of basic JSON serializers */
public class BasicSerializerFactory {

  private static final Logger logger = LoggerFactory.getLogger(MinifyJsonSerializer.class);

  /**
   * Creates a basic JsonSerializer for formatting JSON output
   *
   * @param outputFormat Accepts: "minified" or "pretty"
   * @return Basic JsonSerializer (either minifying or prettifying)
   * @throws InvalidParameterException When the `outputFormat` is unrecognized
   */
  public JsonSerializer create(String outputFormat) throws InvalidParameterException {
    logger.debug("Creating basic JsonSerializer using a factory");
    switch (outputFormat) {
      case "minified":
        return new MinifyJsonSerializer();
      case "pretty":
        return new PrettifyJsonSerializer();
    }

    throw new InvalidParameterException(
        outputFormat + " is not a valid key for a basic JSON serializer.");
  }
}

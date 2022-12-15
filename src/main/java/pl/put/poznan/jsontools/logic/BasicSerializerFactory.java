package pl.put.poznan.jsontools.logic;

import java.security.InvalidParameterException;

public class BasicSerializerFactory {

    public JsonSerializer create(String outputFormat) throws InvalidParameterException{
        switch(outputFormat){
            case "minified":
                return new MinifyJsonSerializer();
            case "pretty":
                return new PrettifyJsonSerializer();
        }

        throw new InvalidParameterException(outputFormat + " is not a valid key for a basic JSON serializer.");
    }
}

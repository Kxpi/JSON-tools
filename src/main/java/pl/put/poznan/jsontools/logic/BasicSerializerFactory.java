package pl.put.poznan.jsontools.logic;

import java.security.InvalidParameterException;

public class BasicSerializerFactory {

    public JsonSerializer create(String outputFormat) throws InvalidParameterException{
        switch(outputFormat){
            case "minified":
                return null; // new MinifiedJsonSerializer();
            case "pretty":
                return null; // new PrettyJsonSerializer();
        }

        throw new InvalidParameterException(outputFormat + " is not a valid key for a basic JSON serializer.");
    }
}

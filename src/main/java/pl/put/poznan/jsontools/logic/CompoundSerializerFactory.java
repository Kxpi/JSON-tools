package pl.put.poznan.jsontools.logic;

import java.security.InvalidParameterException;

/**
 * Class that manages the creation of compound JSON serializers
 */
public class CompoundSerializerFactory {

    /**
     * Creates a serializer, based on the key specifying all the transforms requested.
     *
     * The key is built as follows: operation1:param1,param2;operation2:param1,param2
     *
     * @param rawTransformsKey The definition of serializers
     * @param baseSerializer Basic serializer to provide the core functionality
     * @return A compound serializer
     */
    public JsonSerializer create(String rawTransformsKey, JsonSerializer baseSerializer) {
        String[] transformKeys = parseInput(rawTransformsKey);

        JsonSerializer outermostSerializer = baseSerializer;
        for(String transformKey : transformKeys){
            TransformDesignator td = splitTransformAndArguments(transformKey);
            outermostSerializer = createSerializer(td, outermostSerializer);
        }

        return outermostSerializer;
    }

    /**
     * Parses the transform string into tokens that specify individual transforms
     * @param transformsKey The raw key from user
     * @return An array of portions that specify one transform each
     */
    String[] parseInput(String transformsKey){
        return transformsKey.split(";");
    }

    /**
     * Creates a transform designator based on a string key with transform name and arguments.
     * @param transformKey The key of a transform, like: operation:param1,param2
     * @return The parsed transform designator
     */
    TransformDesignator splitTransformAndArguments(String transformKey){
        String[] idArgs = transformKey.split(":", 2);

        if(idArgs.length == 1){
            return new TransformDesignator(idArgs[0], new String[]{});
        }

        String[] args = idArgs[1].split(",");
        return new TransformDesignator(idArgs[0], args);
    }

    /**
     * Creates a serializer based on the designator and thus extends another serializer
     * @param td The designator
     * @param innerSerializer The inner serializer that will be used by the newly-created one
     * @return A compound serializer
     * @throws InvalidParameterException When the transform ID is unrecognized
     */
    JsonSerializer createSerializer(TransformDesignator td, JsonSerializer innerSerializer) throws InvalidParameterException{
        switch(td.transformId){
            case "remove":
                return new FilterDeleteJsonSerializer(innerSerializer, td.arguments);
            case "keep":
                return new FilterKeepJsonSerializer(innerSerializer, td.arguments);
            case "casing":
                return new CasingNormalizeSerializer(innerSerializer, td.arguments);
            case "echo":
                return innerSerializer; // Special case - does nothing more than inner serializer
        }

        throw new InvalidParameterException(td.transformId + " is not a valid key for a compound JSON serializer.");
    }

    /**
     * Represents a pair of transform ID and its arguments
     */
    static class TransformDesignator {
        public final String transformId;
        public final String[] arguments;

        public TransformDesignator(String transformId, String[] arguments){
            this.transformId = transformId;
            this.arguments = arguments;
        }
    }
}

package pl.put.poznan.jsontools.logic.types;

import com.fasterxml.jackson.databind.JsonNode;

public class TypeDetector {

    public ValueType getTypeForNode(JsonNode node){
        return ValueType.UNKNOWN;
    }
}

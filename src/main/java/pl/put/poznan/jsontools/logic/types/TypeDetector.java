package pl.put.poznan.jsontools.logic.types;

import com.fasterxml.jackson.databind.JsonNode;

public class TypeDetector {

    static public ValueType getTypeForNode(JsonNode node){
        if (node.isValueNode()) {
            if (node.isTextual()) {
                return ValueType.STRING;
            } else if (node.isInt()) {
                return ValueType.NUMBER;
            } else if (node.isLong()) {
                return ValueType.NUMBER;
            } else if (node.isDouble()) {
                return ValueType.NUMBER;
            } else if (node.isBoolean()) {
                return ValueType.BOOLEAN;
            } else if (node.isBigDecimal()) {
                return ValueType.NUMBER;
            } else if (node.isBigInteger()) {
                return ValueType.NUMBER;
            } else if (node.isNull() || node.isMissingNode()) {
                return ValueType.NULL;
            }
        } else if (node.isArray()) {
            return ValueType.ARRAY;
        } else if (node.isObject()) {
            return ValueType.OBJECT;
        }
        return ValueType.UNKNOWN;
    }
}

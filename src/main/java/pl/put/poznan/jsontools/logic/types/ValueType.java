package pl.put.poznan.jsontools.logic.types;

/**
 * An enum representing value types available in JSON
 */
public enum ValueType {
    /** Means that the value type hasn't been recognized properly */
    UNKNOWN("unknown"),

    STRING("string"),
    NUMBER("number"),
    BOOLEAN("boolean"),
    NULL("null"),
    ARRAY("array"),
    OBJECT("object");

    private final String valueCode;

    ValueType(String code) {
        valueCode = code;
    }

    /**
     * @return The type name in a form that can be printed to the user
     */
    @Override
    public String toString(){
        return valueCode;
    }
}

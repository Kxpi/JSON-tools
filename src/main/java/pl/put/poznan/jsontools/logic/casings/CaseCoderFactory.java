package pl.put.poznan.jsontools.logic.casings;

public class CaseCoderFactory {

    public CaseCoder create(CasingScheme scheme) {
        switch(scheme) {
            case SNAKE_CASE:
                return new SnakeCaseCoder();
            case CAMEL_CASE:
                return new CamelCaseCoder();
            default:
                return new UnknownCaseCoder();
        }
    }
}

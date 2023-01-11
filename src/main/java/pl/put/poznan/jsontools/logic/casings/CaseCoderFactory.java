package pl.put.poznan.jsontools.logic.casings;

public class CaseCoderFactory {

    public CaseCoder create(CasingScheme scheme) {
        switch(scheme) {
            // TODO: implement other coders
            default:
                return new UnknownCaseCoder();
        }
    }
}

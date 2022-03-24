package learn.solar.models;

// -- enum representing the 5 materials

public enum Material {
    MULTICRYSTALLINE_SILICON("MULTI"),
    MONOCRYSTALLINE_SILICON("MONO"),
    AMORPHOUS_SILICON("AMORPHOUS"),
    CADMIUM_TELLURIDE("CADMIUM"),
    COPPER_INDIUM("COPPER"),
    ;


    public final String label;

    Material(String label) {
        this.label = label;
    }
}

package pl.marlena;


enum Sex {
    
    F("female"), M("male");

    private final String name;

    Sex(String name) {
        this.name = name;
    }
}

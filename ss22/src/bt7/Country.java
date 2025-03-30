package bt7;

class Country {
    private int id;
    private String code;
    private String name;

    public Country() {
    }
    public Country(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[ ID: " + id + " | CODE: \"" + code + "\" | NAME: \"" + name + "\" ]";
    }
}


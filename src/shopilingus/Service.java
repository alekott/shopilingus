package shopilingus;

public class Service {

    private static int nextId = 0;

    private int id;
    private String name;
    private double price;
    private int durationInMinutes;
    private ShopType type;

    public Service(String name, double price, int durationInMinutes, ShopType type) {
        this.id = Service.nextId++;
        this.name = name;
        this.price = price;
        this.durationInMinutes = durationInMinutes;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

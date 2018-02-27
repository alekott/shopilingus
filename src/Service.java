public class Service {

    private static int nextId = 0;

    public int id;
    private String name;
    private double price;
    private int durationInMinutes;

    public Service(String name, double price, int durationInMinutes){
        this.id = Service.nextId++;
        this.name = name;
        this.price = price;
        this.durationInMinutes = durationInMinutes;
    }
}

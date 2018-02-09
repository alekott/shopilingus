public class Employee {

    public String name;
    public String[] skills;
    private boolean isAvailable;

    public Employee(String name, String[] skills) {
        this.name = name;
        this.skills = skills;
        this.isAvailable = true;
    }
}

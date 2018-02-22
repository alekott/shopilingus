package shopilingus;

public class Employee {

    private String name;
    private String[] skills;
    private boolean isAvailable;

    public Employee(String name, String[] skills) {
        this.name = name;
        this.skills = skills;
        this.isAvailable = true;
    }

    public String getName() {
        return name;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }
}

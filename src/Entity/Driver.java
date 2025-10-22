package Entity;

public class Driver {
    int id;
    String name;
    boolean available;
    public Driver(int id, String name, boolean available) {
        this.id = id;
        this.name = name;
        this.available = available;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isAvailable() {return available;}

    public void setAvailable(boolean available) {this.available = available;}

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Automobile {
    String name;
    int weight;

    public Automobile(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Name : " + name + ",  Weight : " + weight;
    }
}

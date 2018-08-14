package combinatorics;

public class Product {

    private String name;
    private double calories;
    private double proteins;

    public Product(String name, double calories, double proteins) {
        this.name = name;
        this.calories = calories;
        this.proteins = proteins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", proteins=" + proteins +
                '}';
    }
}

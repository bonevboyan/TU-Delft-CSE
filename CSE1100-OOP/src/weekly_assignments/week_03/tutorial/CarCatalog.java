package weekly_assignments.week_03.tutorial;

import java.util.ArrayList;

public class CarCatalog {

    // Your fields here
    ArrayList<Car> cars;

    public CarCatalog() {
        this.cars = new ArrayList<>();
    }

    public ArrayList<Car> getCatalog() {
        return cars;
    }

    public int getCatalogSize() {
        return cars.size();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public boolean contains(Car car) {
        return cars.contains(car);
    }
}
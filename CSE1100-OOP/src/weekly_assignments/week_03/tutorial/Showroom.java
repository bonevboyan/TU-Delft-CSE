package weekly_assignments.week_03.tutorial;

public class Showroom {
    Car[] cars;
    int amount;

    public Showroom(int size) {
        cars = new Car[size];
    }

    public int getShowroomSize() {
        return cars.length;
    }

    public Car getCar(int i) {
        if (i >= amount) {
            throw new IllegalArgumentException();
        }

        return cars[i];
    }

    public int getAmount() {
        return amount;
    }

    public void addCar(Car car) {
        if(amount >= cars.length) {
            throw new IllegalArgumentException();
        }

        cars[amount] = car;
        amount++;
    }

}
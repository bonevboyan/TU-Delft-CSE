package weekly_assignments.week_03.tutorial;

import java.util.Objects;

public class Car {

    private String licencePlate;
    private String brand;

    public Car(String licencePlate, String brand) {
        this.licencePlate = licencePlate;
        this.brand = brand;
    }

    public String getLicencePlate() {
        return this.licencePlate;
    }

    public String getBrand() {
        return this.brand;
    }

    public boolean equals(Object other) {
        if(other instanceof Car) {
            Car that = (Car) other;

            return Objects.equals(this.licencePlate, that.licencePlate) &&
                    this.brand.equals(that.brand);
        }
        return false;
    }

}
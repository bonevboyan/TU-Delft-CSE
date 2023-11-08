package practice_exams.deezer;

public class Ad extends Playable {
    private double price;

    /**
     * Creates an ad
     *
     * @param name   of the ad
     * @param length of the ad
     * @param price  of the ad
     */
    public Ad(String name, String length, double price) {
        super(name, length);
        this.price = price;
    }

    /**
     * @return the price of the ad
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return the ad converted to a String
     */
    @Override
    public String toString() {
        return "AD: " + super.toString();
    }
}

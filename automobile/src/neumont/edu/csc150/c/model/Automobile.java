package neumont.edu.csc150.c.model;

abstract public class Automobile {

    private int condition;

    public enum Make {
        FORD, CHEVY, HONDA, TOYOTA
    }

    public void Automobile() {}

    public static final int rentalPrice;


    public void setRentalPrice(double rentalPrice) {
        validateRentalPrice(rentalPrice);
        this.rentalPrice = rentalPrice;
    }

//    abstract protected void validateRentalPrice(double rentalPrice);

    protected void validateValueInRange(int value, getRentalPriceMin(), getRentlPriceMax()) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(String.format("value must be between %d and %d",
                    min, max));
        }
    }

    abstract protected int getRentalPriceMin();

    abstract protected int getRentalPriceMax();


    public int getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        return String.format("Year = %d \n Make = %s \nModel = %s \n Cost = %d\n Condition = %s",
                this.getYear(), String.valueOf(this.getMake()), this.getModel(), this.getCost(), this.getCondition());
    }

}

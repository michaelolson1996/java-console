package neumont.edu.csc150.c.model;

public class Truck extends Automobile {


    @Override
    protected void validateRentalPrice(double rentalPrice) {
        if ( rentalPrice < 65 || rentalPrice > 96) {
            throw new IllegalArgumentException("must be between 65 and 96");
        }
    }
}

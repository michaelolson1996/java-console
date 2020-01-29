package neumont.edu.csc150.c.model;

public class Sedan extends Automobile {

    @Override
    protected int getRentalPriceMin() {
        return 40;
    }

    protected int getRentalPrice

    @Override
    protected void validateRentalPrice(double rentalPrice) {
        if ( rentalPrice < 40 || rentalPrice > 75) {
            throw new IllegalArgumentException("must be between 40 and 75");
        }
    }
}


package org.fundacionjala.coding.juan.movies;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Juan Pablo
 */
public class CustomerTest {

    private static final double MINORPRICE = 1.5;
    private static final int DAYONE = 1;


    /**
     * Test Movie When NameCustomer Is Word.
     */
    @Test
    public void testingGivenaCustomerName() {

        // given:
        final Customer customer = new Customer("Jorge");

        // when:
        final String actualResult = customer.getName();

        // then:
        final String expectedResult = "Jorge";

        assertEquals(expectedResult, actualResult);
    }

    /**
     * test Movie When Day Rented Is less For Children.
     */
    @Test
    public void testMovieWhenDayRentedISLessForChildren() {

        // given:
        final Customer customer = new Customer("Test");
        customer.addRental(new Rental(new Children("The Revenant"), DAYONE));

        // when:
        final double actualResult = customer.calculateTotalAmount();

        // then:

        assertEquals(MINORPRICE, actualResult, 0);
    }

    /**
     * Test customer class.
     */
    @Test
    public void testCustomer() {
        // given
        Customer customer = new Customer("Juan");
        customer.addRental(new Rental(new NewRelease("The Avengers"), 2));
        customer.addRental(new Rental(new Regular("Iron Man"), 1));

        // when
        final String actualResult = customer.generateDetail();

        // then
        final String expectedResult = "Rental Record for Juan\n"
                + "\tThe Avengers\t6.0\n"
                + "\tIron Man\t1.5\n"
                + "Amount owed is 7.5\n"
                + "You earned 3 frequent renter points";
        assertEquals(actualResult, expectedResult);
    }


}

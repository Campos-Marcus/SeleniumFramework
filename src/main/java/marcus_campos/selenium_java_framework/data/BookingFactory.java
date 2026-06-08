package marcus_campos.selenium_java_framework.data;

import marcus_campos.selenium_java_framework.api.models.Booking;
import marcus_campos.selenium_java_framework.api.models.BookingDates;
import net.datafaker.Faker;

public class BookingFactory {

    private static final Faker faker = new Faker();

    public static Booking createBooking() {

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2026-06-01");
        bookingDates.setCheckout("2026-06-10");

        Booking booking = new Booking();
        booking.setFirstname(faker.name().firstName());
        booking.setLastname(faker.name().lastName());
        booking.setTotalprice(faker.number().numberBetween(100, 1000));
        booking.setDepositpaid(true);
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");

        return booking;
    }
}
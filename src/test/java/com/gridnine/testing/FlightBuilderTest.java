//test application made by Sergey Tarasov
package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class FlightBuilderTest extends FlightBuilder {

    @Override
    public List<Flight> createFlights() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        return Arrays.asList(
                // рейс, уже отправлявшийся в прошлом
                createFlight(threeDaysFromNow.minusDays(10), threeDaysFromNow),
                // обычный рейс
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(4)),
                // обчный рейс с несколькими сегментами
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)),
                // еще один рейс в прошлом
                createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow),
                // рейс с отправлением раньше прибытия
                createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6)),
                // рейс с временем на земле более 2 часов
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)),
                // Broken multi flight
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(4),
                        threeDaysFromNow.plusHours(8), threeDaysFromNow.plusHours(7)));
    }
}

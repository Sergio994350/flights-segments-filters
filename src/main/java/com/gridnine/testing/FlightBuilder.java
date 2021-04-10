//test application made by Sergey Tarasov
package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Factory class to get sample list of flights.
 */
public class FlightBuilder {
    private Integer flightId = 0;
    private Integer segmentId = 0;

    public List<Flight> createFlights() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        return Arrays.asList(
                // Обычный рейс продолжительностью 2 часа
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                // Обычный мульти-сегментный рейс
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)),
                // рейс, выполнявшийся в прошлом
                createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow),
                // вылет раньше, чем прибытие
                createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6)),
                // рейс с ожиданием на земле более 2 часов
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)),
                // рейс с ожиданием на земле 2 часа
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4),
                        threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7)));

    }


    protected Flight createFlight(final LocalDateTime... dates) {
        if ((dates.length % 2) != 0) {
            throw new IllegalArgumentException(
                    "пожалуйста, используйте четное количество дней");
        }
        List<Segment> segments = new ArrayList<>(dates.length / 2);
        for (int i = 0; i < (dates.length - 1); i += 2) {
            segmentId += 1;
            segments.add(new Segment(dates[i], dates[i + 1], segmentId));
        }
        flightId += 1;
        return new Flight(segments, flightId);
    }
}




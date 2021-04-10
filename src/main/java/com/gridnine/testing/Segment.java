//test application made by Sergey Tarasov
package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Bean that represents a flight segment.
 */
public class Segment {

    private final Integer id;
    private final LocalDateTime departureDate;
    private final LocalDateTime arrivalDate;

    Segment(final LocalDateTime departure, final LocalDateTime arrival, Integer id) {
        departureDate = Objects.requireNonNull(departure);
        arrivalDate = Objects.requireNonNull(arrival);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    LocalDateTime getDepartureDate() {
        return departureDate;
    }

    LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd' T 'HH:mm");
        return '(' + departureDate.format(formatter) + '|' + arrivalDate.format(formatter)
                + ')';
    }

}

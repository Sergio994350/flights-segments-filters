//test application made by Sergey Tarasov
package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Bean that represents a flight.
 */
public class Flight {

    private final Integer id;
    private final List<Segment> segments;

    Flight(final List<Segment> segs, Integer id) {
        segments = segs;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }

}
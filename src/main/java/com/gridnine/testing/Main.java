//test application made by Sergey Tarasov
package com.gridnine.testing;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        FlightBuilder flightBuilder = new FlightBuilder();
        List<Flight> flightList = flightBuilder.createFlights();

        SegmentFilter segmentFilter = new SegmentFilterImpl();
        segmentFilter.showAllSegments(flightList);

        System.out.println("\nФильтр номер 1. Сегменты с датой отправления после текущего времени");
        System.out.println("..................................");
        segmentFilter.getDepartureTimeBeforeNow(flightList);

        System.out.println("Фильтр номер 2. Сегменты с датой прибытия раньше времени отправления");
        System.out.println("..................................");
        segmentFilter.getArrivalDateLessDepartureDate(flightList);

        System.out.println("Фильтр номер 3. Время трансфера более двух часов");
        System.out.println("..................................");
        segmentFilter.getFlightWithTransferMoreThanTwoHours(flightList);

    }
}

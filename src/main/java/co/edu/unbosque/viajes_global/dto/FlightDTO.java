package co.edu.unbosque.viajes_global.dto;

public record FlightDTO(Integer idFlight, Integer flightType, Integer touristPlaceOrigin,
                        Integer touristPlaceDestination, String dateBegin, String dateEnd, Integer passengersNumber,
                        Integer airline, Double baseFee, Double taxes, Double charges, Double total) {
}

package co.edu.unbosque.viajes_global.dto;

public record FlightDetailDTO(Integer flightDetailId, FlightDTO flight, Integer passengerType, Integer baggageType,
                              Integer seat) {
}

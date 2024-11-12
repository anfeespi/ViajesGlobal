package co.edu.unbosque.viajes_global.dto;

import java.util.Date;

public record HotelDetailDTO(Integer hotelDetailId, HotelDTO hotel, Date beginDate, Date endDate, Integer guestNumber,
                             Double totalValue) {
}

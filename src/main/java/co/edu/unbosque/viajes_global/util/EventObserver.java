package co.edu.unbosque.viajes_global.util;

import co.edu.unbosque.viajes_global.dto.ExcursionDiscountDTO;
import co.edu.unbosque.viajes_global.dto.FlightDiscountDTO;
import co.edu.unbosque.viajes_global.dto.HotelDiscountDTO;

public interface EventObserver {
    void newHotelDiscount(HotelDiscountDTO discountDTO);
    void newFlightDiscount(FlightDiscountDTO discountDTO);
    void newExcursionDiscount(ExcursionDiscountDTO discountDTO);
}

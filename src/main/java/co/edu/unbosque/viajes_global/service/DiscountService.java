package co.edu.unbosque.viajes_global.service;

import co.edu.unbosque.viajes_global.dto.ExcursionDiscountDTO;
import co.edu.unbosque.viajes_global.dto.FlightDiscountDTO;
import co.edu.unbosque.viajes_global.dto.HotelDiscountDTO;
import co.edu.unbosque.viajes_global.repository.ExcursionDiscountRepository;
import co.edu.unbosque.viajes_global.repository.FlightDiscountRepository;
import co.edu.unbosque.viajes_global.repository.HotelDiscountRepository;
import co.edu.unbosque.viajes_global.util.DataMapper;
import co.edu.unbosque.viajes_global.util.EventManager;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    @Autowired
    private HotelDiscountRepository hotelDiscountRepository;

    @Autowired
    private ExcursionDiscountRepository excursionDiscountRepository;

    @Autowired
    private FlightDiscountRepository flightDiscountRepository;

    @Autowired
    private EventManager eventObserver;

    @Autowired
    private DataMapper dataMapper;

    public HotelDiscountDTO addHotelDiscount(HotelDiscountDTO hotelDiscountDTO) {
        eventObserver.newHotelDiscount(hotelDiscountDTO);
        return dataMapper.hotelDiscountToHotelDiscountDTO(hotelDiscountRepository.save(dataMapper.hotelDiscountDTOToHotelDiscount(hotelDiscountDTO)));
    }

    public FlightDiscountDTO addFlightDiscount(FlightDiscountDTO flightDiscountDTO) {
        eventObserver.newFlightDiscount(flightDiscountDTO);
        return dataMapper.flightDiscountToFlightDiscountDTO(flightDiscountRepository.save(dataMapper.flightDiscountDTOToFlightDiscount(flightDiscountDTO)));
    }

    public ExcursionDiscountDTO addExcursionDiscount(ExcursionDiscountDTO excursionDiscountDTO) {
        eventObserver.newExcursionDiscount(excursionDiscountDTO);
        return dataMapper.excursionDiscountToExcursionDiscountDTO(excursionDiscountRepository.save(dataMapper.excursionDiscountDTOToExcursionDiscount(excursionDiscountDTO)));
    }

    public HotelDiscountDTO getHotelById(Integer hotelDiscountId) {
        return dataMapper.hotelDiscountToHotelDiscountDTO(hotelDiscountRepository.findById(hotelDiscountId).orElseThrow(() -> new EntityNotFoundException("Cannot find hotel")));
    }

    public FlightDiscountDTO getFlightById(Integer flightDiscountId) {
        return dataMapper.flightDiscountToFlightDiscountDTO(flightDiscountRepository.findById(flightDiscountId).orElseThrow(() -> new EntityNotFoundException("Cannot find flight discount")));
    }

    public ExcursionDiscountDTO getExcursionById(Integer excursionDiscountId) {
        return dataMapper.excursionDiscountToExcursionDiscountDTO(excursionDiscountRepository.findById(excursionDiscountId).orElseThrow(() -> new EntityNotFoundException("Cannot find excursion discount")));
    }
}

package co.edu.unbosque.viajes_global.service;

import co.edu.unbosque.viajes_global.dto.HotelDetailDTO;
import co.edu.unbosque.viajes_global.exception.ElementNotPresentException;
import co.edu.unbosque.viajes_global.model.Hotel;
import co.edu.unbosque.viajes_global.model.HotelDetail;
import co.edu.unbosque.viajes_global.repository.HotelDetailRepository;
import co.edu.unbosque.viajes_global.repository.HotelRepository;
import co.edu.unbosque.viajes_global.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelDetailRepository hotelDetailRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private DataMapper dataMapper;

    public HotelService() {

    }

    public List<HotelDetailDTO> getAllHotelDetails() {
        return hotelDetailRepository.findAll().stream().map(dataMapper::hotelDetailToHotelDetailDTO).toList();
    }

    public Page<HotelDetailDTO> getAllHotelDetails(Pageable pageable) {
        List<HotelDetailDTO> hotelDetailDTOS = getAllHotelDetails();

        return new PageImpl<>(hotelDetailDTOS, pageable, hotelDetailDTOS.size());
    }

    public HotelDetailDTO getHotelById(Integer hotelId) {
        if (hotelDetailRepository.existsById(hotelId)) {
            return dataMapper.hotelDetailToHotelDetailDTO(hotelDetailRepository.findById(hotelId).get());
        }

        throw new ElementNotPresentException();
    }

    public HotelDetailDTO registerHotel(HotelDetailDTO hotelDetailDTO) {
        HotelDetail entity = dataMapper.hotelDetailDTOToHotelDetail(hotelDetailDTO);
        Hotel toSave = entity.getHotel();
        hotelRepository.save(toSave);
        return dataMapper.hotelDetailToHotelDetailDTO(hotelDetailRepository.save(entity));
    }
}

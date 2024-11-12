package co.edu.unbosque.viajes_global.service;

import co.edu.unbosque.viajes_global.dto.ExcursionDetailDTO;
import co.edu.unbosque.viajes_global.exception.ElementNotPresentException;
import co.edu.unbosque.viajes_global.model.Excursion;
import co.edu.unbosque.viajes_global.model.ExcursionDetail;
import co.edu.unbosque.viajes_global.repository.ExcursionDetailRepository;
import co.edu.unbosque.viajes_global.repository.ExcursionRepository;
import co.edu.unbosque.viajes_global.util.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcursionService {
    @Autowired
    private ExcursionDetailRepository excursionDetailRepository;

    @Autowired
    private ExcursionRepository excursionRepository;

    @Autowired
    private DataMapper dataMapper;

    public ExcursionService() {

    }

    public List<ExcursionDetailDTO> getAllExcursions() {
        return excursionDetailRepository.findAll().stream().map(dataMapper::excursionDetailToExcursionDetailDTO).toList();
    }

    public Page<ExcursionDetailDTO> getAllExcursions(Pageable pageable) {
        List<ExcursionDetailDTO> excursionDetailDTOS = getAllExcursions();
        return new PageImpl<>(excursionDetailDTOS, pageable, excursionDetailDTOS.size());
    }

    public ExcursionDetailDTO getExcursionById(Integer id) {
        if (excursionRepository.existsById(id)) {
            return dataMapper.excursionDetailToExcursionDetailDTO(excursionDetailRepository.findById(id).get());
        }
        throw new ElementNotPresentException();
    }

    public ExcursionDetailDTO registerExcursion(ExcursionDetailDTO excursionDetailDTO) {
        ExcursionDetail entity = dataMapper.excursionDetailDTOToExcursionDetail(excursionDetailDTO);
        Excursion toSave = entity.getExcursion();
        excursionRepository.save(toSave);
        return dataMapper.excursionDetailToExcursionDetailDTO(entity);
    }
}

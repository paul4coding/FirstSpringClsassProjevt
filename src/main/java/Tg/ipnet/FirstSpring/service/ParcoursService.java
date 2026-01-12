package Tg.ipnet.FirstSpring.service;

import java.util.List;
import Tg.ipnet.FirstSpring.dto.ParcoursDTO;

public interface ParcoursService {
    ParcoursDTO create(ParcoursDTO dto);

    ParcoursDTO update(Long id, ParcoursDTO dto);

    void delete(Long id);

    List<ParcoursDTO> list();

    ParcoursDTO getParcours(Long id);
}

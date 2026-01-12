package Tg.ipnet.FirstSpring.service;

import java.util.List;
import Tg.ipnet.FirstSpring.dto.UeDTO;

public interface UeService {
    UeDTO create(UeDTO dto);

    UeDTO update(Long id, UeDTO dto);

    void delete(Long id);

    List<UeDTO> list();

    UeDTO getUe(Long id);
}

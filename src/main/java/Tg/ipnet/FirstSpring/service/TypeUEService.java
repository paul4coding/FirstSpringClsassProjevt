package Tg.ipnet.FirstSpring.service;

import java.util.List;
import Tg.ipnet.FirstSpring.dto.TypeUEDTO;

public interface TypeUEService {
    TypeUEDTO create(TypeUEDTO dto);

    TypeUEDTO update(Long id, TypeUEDTO dto);

    void delete(Long id);

    List<TypeUEDTO> list();

    TypeUEDTO getTypeUE(Long id);
}

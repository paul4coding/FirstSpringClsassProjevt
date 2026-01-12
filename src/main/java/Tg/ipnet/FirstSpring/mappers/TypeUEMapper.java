package Tg.ipnet.FirstSpring.mappers;

import org.springframework.stereotype.Component;
import Tg.ipnet.FirstSpring.dto.TypeUEDTO;
import Tg.ipnet.FirstSpring.entity.TypeUE;

@Component
public class TypeUEMapper {

    public TypeUE toEntity(TypeUEDTO dto) {
        TypeUE t = new TypeUE();
        t.setLibelle(dto.getLibelle());
        t.setDescription(dto.getDescription());
        return t;
    }

    public TypeUEDTO toDTO(TypeUE t) {
        TypeUEDTO dto = new TypeUEDTO();
        dto.setId(t.getId());
        dto.setLibelle(t.getLibelle());
        dto.setDescription(t.getDescription());
        return dto;
    }
}

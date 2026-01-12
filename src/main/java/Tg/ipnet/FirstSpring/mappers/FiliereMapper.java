package Tg.ipnet.FirstSpring.mappers;

import org.springframework.stereotype.Component;
import Tg.ipnet.FirstSpring.dto.FiliereDTO;
import Tg.ipnet.FirstSpring.entity.Filiere;

@Component
public class FiliereMapper {

    public Filiere toEntity(FiliereDTO dto) {
        Filiere f = new Filiere();
        f.setNom(dto.getNom());
        f.setDescription(dto.getDescription());
        return f;
    }

    public FiliereDTO toDTO(Filiere f) {
        FiliereDTO dto = new FiliereDTO();
        dto.setId(f.getId());
        dto.setNom(f.getNom());
        dto.setDescription(f.getDescription());
        return dto;
    }
}

package Tg.ipnet.FirstSpring.mappers;

import org.springframework.stereotype.Component;

import Tg.ipnet.FirstSpring.dto.AnneeDTO;
import Tg.ipnet.FirstSpring.entity.Annee;

@Component
public class AnneeMapper {

    public Annee toEntity(AnneeDTO dto){
        Annee a = new Annee();
        a.setDateDebut(dto.getDateDebut());
        a.setDateFin(dto.getDateFin());
        a.setEstActive(dto.getEstActive());
        return a;
    }

    public AnneeDTO toDTO(Annee a){
        AnneeDTO dto = new AnneeDTO();
        dto.setId(a.getId());
        dto.setDateDebut(a.getDateDebut());
        dto.setDateFin(a.getDateFin());
        dto.setEstActive(a.getEstActive());
        return dto;
    }
}

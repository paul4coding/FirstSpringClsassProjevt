package Tg.ipnet.FirstSpring.mappers;

import org.springframework.stereotype.Component;
import Tg.ipnet.FirstSpring.dto.UeDTO;
import Tg.ipnet.FirstSpring.entity.Ue;
import Tg.ipnet.FirstSpring.repository.ParcoursRepository;
import Tg.ipnet.FirstSpring.repository.TypeUERepository;

@Component
public class UeMapper {

    private final TypeUERepository typeUERepository;
    private final ParcoursRepository parcoursRepository;

    public UeMapper(TypeUERepository typeUERepository, ParcoursRepository parcoursRepository) {
        this.typeUERepository = typeUERepository;
        this.parcoursRepository = parcoursRepository;
    }

    public Ue toEntity(UeDTO dto) {
        Ue ue = new Ue();
        ue.setCodeUE(dto.getCodeUE());
        ue.setIntituleUE(dto.getIntituleUE());
        ue.setCredit(dto.getCredit());

        if (dto.getTypeUEId() != null) {
            ue.setTypeUE(typeUERepository.findById(dto.getTypeUEId())
                    .orElseThrow(() -> new RuntimeException("TypeUE not found")));
        }
        if (dto.getParcoursId() != null) {
            ue.setParcours(parcoursRepository.findById(dto.getParcoursId())
                    .orElseThrow(() -> new RuntimeException("Parcours not found")));
        }
        return ue;
    }

    public UeDTO toDTO(Ue ue) {
        UeDTO dto = new UeDTO();
        dto.setId(ue.getId());
        dto.setCodeUE(ue.getCodeUE());
        dto.setIntituleUE(ue.getIntituleUE());
        dto.setCredit(ue.getCredit());

        if (ue.getTypeUE() != null) {
            dto.setTypeUEId(ue.getTypeUE().getId());
            dto.setTypeUELibelle(ue.getTypeUE().getLibelle());
        }
        if (ue.getParcours() != null) {
            dto.setParcoursId(ue.getParcours().getId());
            dto.setParcoursNom(ue.getParcours().getNom());
        }
        return dto;
    }
}

package Tg.ipnet.FirstSpring.mappers;

import org.springframework.stereotype.Component;
import Tg.ipnet.FirstSpring.dto.ParcoursDTO;
import Tg.ipnet.FirstSpring.entity.Parcours;
import Tg.ipnet.FirstSpring.repository.FiliereRepository;

@Component
public class ParcoursMapper {

    private final FiliereRepository filiereRepository;

    public ParcoursMapper(FiliereRepository filiereRepository) {
        this.filiereRepository = filiereRepository;
    }

    public Parcours toEntity(ParcoursDTO dto) {
        Parcours p = new Parcours();
        p.setNom(dto.getNom());
        p.setNbrSemestre(dto.getNbrSemestre());

        if (dto.getFiliereId() != null) {
            p.setFiliere(filiereRepository.findById(dto.getFiliereId())
                    .orElseThrow(() -> new RuntimeException("Filiere not found")));
        }
        return p;
    }

    public ParcoursDTO toDTO(Parcours p) {
        ParcoursDTO dto = new ParcoursDTO();
        dto.setId(p.getId());
        dto.setNom(p.getNom());
        dto.setNbrSemestre(p.getNbrSemestre());
        if (p.getFiliere() != null) {
            dto.setFiliereId(p.getFiliere().getId());
            dto.setFiliereNom(p.getFiliere().getNom());
        }
        return dto;
    }
}

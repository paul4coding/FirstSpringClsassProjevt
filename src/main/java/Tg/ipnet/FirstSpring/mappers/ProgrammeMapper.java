package Tg.ipnet.FirstSpring.mappers;

import org.springframework.stereotype.Component;
import Tg.ipnet.FirstSpring.dto.ProgrammeDTO;
import Tg.ipnet.FirstSpring.entity.Programme;
import Tg.ipnet.FirstSpring.repository.AnneeRepository;
import Tg.ipnet.FirstSpring.repository.ParcoursRepository;
import Tg.ipnet.FirstSpring.repository.UERepository;

@Component
public class ProgrammeMapper {

    private final ParcoursRepository parcoursRepository;
    private final AnneeRepository anneeRepository;
    private final UERepository ueRepository;

    public ProgrammeMapper(ParcoursRepository parcoursRepository, AnneeRepository anneeRepository,
            UERepository ueRepository) {
        this.parcoursRepository = parcoursRepository;
        this.anneeRepository = anneeRepository;
        this.ueRepository = ueRepository;
    }

    public Programme toEntity(ProgrammeDTO dto) {
        Programme p = new Programme();
        p.setLibelle(dto.getLibelle());
        p.setDescription(dto.getDescription());

        if (dto.getParcoursId() != null) {
            p.setParcours(parcoursRepository.findById(dto.getParcoursId())
                    .orElseThrow(() -> new RuntimeException("Parcours not found")));
        }
        if (dto.getAnneeId() != null) {
            p.setAnnee(anneeRepository.findById(dto.getAnneeId())
                    .orElseThrow(() -> new RuntimeException("Annee not found")));
        }
        if (dto.getUeId() != null) {
            p.setUe(ueRepository.findById(dto.getUeId())
                    .orElseThrow(() -> new RuntimeException("UE not found")));
        }
        return p;
    }

    public ProgrammeDTO toDTO(Programme p) {
        ProgrammeDTO dto = new ProgrammeDTO();
        dto.setId(p.getId());
        dto.setLibelle(p.getLibelle());
        dto.setDescription(p.getDescription());

        if (p.getParcours() != null) {
            dto.setParcoursId(p.getParcours().getId());
            dto.setParcoursNom(p.getParcours().getNom());
        }
        if (p.getAnnee() != null) {
            dto.setAnneeId(p.getAnnee().getId());
        }
        if (p.getUe() != null) {
            dto.setUeId(p.getUe().getId());
        }
        return dto;
    }
}

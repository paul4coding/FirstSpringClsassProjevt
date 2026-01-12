package Tg.ipnet.FirstSpring.mappers;

import org.springframework.stereotype.Component;
import Tg.ipnet.FirstSpring.dto.InscriptionDTO;
import Tg.ipnet.FirstSpring.entity.Inscription;
import Tg.ipnet.FirstSpring.repository.AnneeRepository;
import Tg.ipnet.FirstSpring.repository.EtudiantRepository;
import Tg.ipnet.FirstSpring.repository.ParcoursRepository;

@Component
public class InscriptionMapper {

    private final AnneeRepository anneeRepository;
    private final EtudiantRepository etudiantRepository;
    private final ParcoursRepository parcoursRepository;

    public InscriptionMapper(AnneeRepository anneeRepository, EtudiantRepository etudiantRepository,
            ParcoursRepository parcoursRepository) {
        this.anneeRepository = anneeRepository;
        this.etudiantRepository = etudiantRepository;
        this.parcoursRepository = parcoursRepository;
    }

    public Inscription toEntity(InscriptionDTO dto) {
        Inscription i = new Inscription();
        i.setDateInscription(dto.getDateInscription());
        i.setEtatInscription(dto.getEtatInscription());
        i.setMontant(dto.getMontant());

        if (dto.getAnneeId() != null) {
            i.setAnnee(anneeRepository.findById(dto.getAnneeId())
                    .orElseThrow(() -> new RuntimeException("Annee not found")));
        }
        if (dto.getEtudiantId() != null) {
            i.setEtudiant(etudiantRepository.findById(dto.getEtudiantId())
                    .orElseThrow(() -> new RuntimeException("Etudiant not found")));
        }
        if (dto.getParcoursId() != null) {
            i.setParcours(parcoursRepository.findById(dto.getParcoursId())
                    .orElseThrow(() -> new RuntimeException("Parcours not found")));
        }
        return i;
    }

    public InscriptionDTO toDTO(Inscription i) {
        InscriptionDTO dto = new InscriptionDTO();
        dto.setId(i.getId());
        dto.setDateInscription(i.getDateInscription());
        dto.setEtatInscription(i.getEtatInscription());
        dto.setMontant(i.getMontant());

        if (i.getAnnee() != null) {
            dto.setAnneeId(i.getAnnee().getId());
        }
        if (i.getEtudiant() != null) {
            dto.setEtudiantId(i.getEtudiant().getId());
            dto.setEtudiantNom(i.getEtudiant().getNom() + " " + i.getEtudiant().getPrenom());
        }
        if (i.getParcours() != null) {
            dto.setParcoursId(i.getParcours().getId());
            dto.setParcoursNom(i.getParcours().getNom());
        }
        return dto;
    }
}

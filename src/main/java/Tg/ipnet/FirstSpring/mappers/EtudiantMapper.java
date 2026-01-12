package Tg.ipnet.FirstSpring.mappers;

import org.springframework.stereotype.Component;

import Tg.ipnet.FirstSpring.dto.EtudiantDTO;
import Tg.ipnet.FirstSpring.entity.Etudiant;

@Component
public class EtudiantMapper {

    public Etudiant toEntity(EtudiantDTO dto) {
        Etudiant e = new Etudiant();
        e.setMatricule(dto.getMatricule());
        e.setNom(dto.getNom());
        e.setPrenom(dto.getPrenom());
        e.setDateNaissance(dto.getDateNaissance());
        e.setAdresse(dto.getAdresse());
        e.setEmail(dto.getEmail());
        e.setNumtel(dto.getNumtel());
        return e;
    }

    public EtudiantDTO toDTO(Etudiant e) {
        EtudiantDTO dto = new EtudiantDTO();
        dto.setId(e.getId());
        dto.setMatricule(e.getMatricule());
        dto.setNom(e.getNom());
        dto.setPrenom(e.getPrenom());
        dto.setDateNaissance(e.getDateNaissance());
        dto.setAdresse(e.getAdresse());
        dto.setEmail(e.getEmail());
        dto.setNumtel(e.getNumtel());
        return dto;
    }
}

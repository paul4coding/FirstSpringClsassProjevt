package Tg.ipnet.FirstSpring.mappers;

import org.springframework.stereotype.Component;
import Tg.ipnet.FirstSpring.dto.NoteDTO;
import Tg.ipnet.FirstSpring.entity.Note;
import Tg.ipnet.FirstSpring.repository.InscriptionRepository;
import Tg.ipnet.FirstSpring.repository.UERepository;

@Component
public class NoteMapper {

    private final UERepository ueRepository;
    private final InscriptionRepository inscriptionRepository;

    public NoteMapper(UERepository ueRepository, InscriptionRepository inscriptionRepository) {
        this.ueRepository = ueRepository;
        this.inscriptionRepository = inscriptionRepository;
    }

    public Note toEntity(NoteDTO dto) {
        Note n = new Note();
        n.setNoteObtenue(dto.getNoteObtenue());
        n.setDateObtention(dto.getDateObtention());
        n.setTypeEvaluation(dto.getTypeEvaluation());

        if (dto.getUeId() != null) {
            n.setUe(ueRepository.findById(dto.getUeId())
                    .orElseThrow(() -> new RuntimeException("UE not found")));
        }
        if (dto.getInscriptionId() != null) {
            n.setInscription(inscriptionRepository.findById(dto.getInscriptionId())
                    .orElseThrow(() -> new RuntimeException("Inscription not found")));
        }
        return n;
    }

    public NoteDTO toDTO(Note n) {
        NoteDTO dto = new NoteDTO();
        dto.setId(n.getId());
        dto.setNoteObtenue(n.getNoteObtenue());
        dto.setDateObtention(n.getDateObtention());
        dto.setTypeEvaluation(n.getTypeEvaluation());

        if (n.getUe() != null) {
            dto.setUeId(n.getUe().getId());
            // Assuming we might want more UE info, but sticking to basics for now
            dto.setUeIntitule(n.getUe().getIntituleUE());
        }
        if (n.getInscription() != null) {
            dto.setInscriptionId(n.getInscription().getId());
        }
        return dto;
    }
}

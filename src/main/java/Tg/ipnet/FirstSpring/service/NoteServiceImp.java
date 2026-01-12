package Tg.ipnet.FirstSpring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Tg.ipnet.FirstSpring.dto.NoteDTO;
import Tg.ipnet.FirstSpring.entity.Note;
import Tg.ipnet.FirstSpring.mappers.NoteMapper;
import Tg.ipnet.FirstSpring.repository.NoteRepository;

@Service
@Transactional
public class NoteServiceImp implements NoteService {

    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    public NoteServiceImp(NoteRepository noteRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }

    @Override
    public NoteDTO create(NoteDTO dto) {
        Note n = noteMapper.toEntity(dto);
        return noteMapper.toDTO(noteRepository.save(n));
    }

    @Override
    public NoteDTO update(Long id, NoteDTO dto) {
        Note n = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note non trouvée"));
        n.setNoteObtenue(dto.getNoteObtenue());
        n.setDateObtention(dto.getDateObtention());
        n.setTypeEvaluation(dto.getTypeEvaluation());

        // Update relations
        Note updateFromDto = noteMapper.toEntity(dto);
        n.setUe(updateFromDto.getUe());
        n.setInscription(updateFromDto.getInscription());

        return noteMapper.toDTO(noteRepository.save(n));
    }

    @Override
    public void delete(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public List<NoteDTO> list() {
        return noteRepository.findAll()
                .stream()
                .map(noteMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public NoteDTO getNote(Long id) {
        return noteMapper.toDTO(
                noteRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Note non trouvée")));
    }
}

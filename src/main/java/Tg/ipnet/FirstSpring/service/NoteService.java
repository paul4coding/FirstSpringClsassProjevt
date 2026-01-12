package Tg.ipnet.FirstSpring.service;

import java.util.List;
import Tg.ipnet.FirstSpring.dto.NoteDTO;

public interface NoteService {
    NoteDTO create(NoteDTO dto);

    NoteDTO update(Long id, NoteDTO dto);

    void delete(Long id);

    List<NoteDTO> list();

    NoteDTO getNote(Long id);
}

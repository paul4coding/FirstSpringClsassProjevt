package Tg.ipnet.FirstSpring.service;

import java.util.List;
import Tg.ipnet.FirstSpring.dto.ProgrammeDTO;

public interface ProgrammeService {
    ProgrammeDTO create(ProgrammeDTO dto);

    ProgrammeDTO update(Long id, ProgrammeDTO dto);

    void delete(Long id);

    List<ProgrammeDTO> list();

    ProgrammeDTO getProgramme(Long id);
}

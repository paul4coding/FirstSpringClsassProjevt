package Tg.ipnet.FirstSpring.service;

import java.util.List;
import Tg.ipnet.FirstSpring.dto.EtudiantDTO;

public interface EtudiantService {
    EtudiantDTO create(EtudiantDTO dto);

    EtudiantDTO update(Long id, EtudiantDTO dto);

    void delete(Long id);

    List<EtudiantDTO> list();

    EtudiantDTO getEtudiant(Long id);
}

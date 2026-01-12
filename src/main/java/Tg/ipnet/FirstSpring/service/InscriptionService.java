package Tg.ipnet.FirstSpring.service;

import java.util.List;
import Tg.ipnet.FirstSpring.dto.InscriptionDTO;

public interface InscriptionService {
    InscriptionDTO create(InscriptionDTO dto);

    InscriptionDTO update(Long id, InscriptionDTO dto);

    void delete(Long id);

    List<InscriptionDTO> list();

    InscriptionDTO getInscription(Long id);
}

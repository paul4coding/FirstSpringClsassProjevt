package Tg.ipnet.FirstSpring.service;

import java.util.List;
import Tg.ipnet.FirstSpring.dto.FiliereDTO;

public interface FiliereService {
	FiliereDTO create(FiliereDTO dto);

	FiliereDTO update(Long id, FiliereDTO dto);

	void delete(Long id);

	List<FiliereDTO> list();

	FiliereDTO getFiliere(Long id);
}

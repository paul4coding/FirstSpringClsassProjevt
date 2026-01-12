package Tg.ipnet.FirstSpring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Tg.ipnet.FirstSpring.dto.FiliereDTO;
import Tg.ipnet.FirstSpring.entity.Filiere;
import Tg.ipnet.FirstSpring.mappers.FiliereMapper;
import Tg.ipnet.FirstSpring.repository.FiliereRepository;

@Service
@Transactional
public class FiliereServiceImp implements FiliereService {

	private final FiliereRepository filiereRepository;
	private final FiliereMapper filiereMapper;

	public FiliereServiceImp(FiliereRepository filiereRepository, FiliereMapper filiereMapper) {
		this.filiereRepository = filiereRepository;
		this.filiereMapper = filiereMapper;
	}

	@Override
	public FiliereDTO create(FiliereDTO dto) {
		Filiere f = filiereMapper.toEntity(dto);
		return filiereMapper.toDTO(filiereRepository.save(f));
	}

	@Override
	public FiliereDTO update(Long id, FiliereDTO dto) {
		Filiere f = filiereRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Filiere non trouvé"));
		f.setNom(dto.getNom());
		f.setDescription(dto.getDescription());
		return filiereMapper.toDTO(filiereRepository.save(f));
	}

	@Override
	public void delete(Long id) {
		filiereRepository.deleteById(id);
	}

	@Override
	public List<FiliereDTO> list() {
		return filiereRepository.listFiliere()
				.stream()
				.map(filiereMapper::toDTO)
				.collect(Collectors.toList());
	}

	@Override
	public FiliereDTO getFiliere(Long id) {
		return filiereMapper.toDTO(
				filiereRepository.findById(id)
						.orElseThrow(() -> new RuntimeException("Filiere non trouvé")));
	}
}

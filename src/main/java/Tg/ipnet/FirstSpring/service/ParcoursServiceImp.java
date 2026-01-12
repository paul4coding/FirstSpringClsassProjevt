package Tg.ipnet.FirstSpring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Tg.ipnet.FirstSpring.dto.ParcoursDTO;
import Tg.ipnet.FirstSpring.entity.Parcours;
import Tg.ipnet.FirstSpring.mappers.ParcoursMapper;
import Tg.ipnet.FirstSpring.repository.ParcoursRepository;

@Service
@Transactional
public class ParcoursServiceImp implements ParcoursService {

    private final ParcoursRepository parcoursRepository;
    private final ParcoursMapper parcoursMapper;

    public ParcoursServiceImp(ParcoursRepository parcoursRepository, ParcoursMapper parcoursMapper) {
        this.parcoursRepository = parcoursRepository;
        this.parcoursMapper = parcoursMapper;
    }

    @Override
    public ParcoursDTO create(ParcoursDTO dto) {
        Parcours p = parcoursMapper.toEntity(dto);
        return parcoursMapper.toDTO(parcoursRepository.save(p));
    }

    @Override
    public ParcoursDTO update(Long id, ParcoursDTO dto) {
        Parcours p = parcoursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parcours non trouvé"));
        p.setNom(dto.getNom());
        p.setNbrSemestre(dto.getNbrSemestre());
        // Handling foreign key updates if necessary?
        // Typically updates might not change parent unless explicitly handled.
        // For now, only scalar fields. If relations need update, extra logic needed.
        return parcoursMapper.toDTO(parcoursRepository.save(p));
    }

    @Override
    public void delete(Long id) {
        parcoursRepository.deleteById(id);
    }

    @Override
    public List<ParcoursDTO> list() {
        return parcoursRepository.findAll()
                .stream()
                .map(parcoursMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ParcoursDTO getParcours(Long id) {
        return parcoursMapper.toDTO(
                parcoursRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Parcours non trouvé")));
    }
}

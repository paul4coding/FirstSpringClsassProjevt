package Tg.ipnet.FirstSpring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Tg.ipnet.FirstSpring.dto.ProgrammeDTO;
import Tg.ipnet.FirstSpring.entity.Programme;
import Tg.ipnet.FirstSpring.mappers.ProgrammeMapper;
import Tg.ipnet.FirstSpring.repository.ProgrammeRepository;

@Service
@Transactional
public class ProgrammeServiceImp implements ProgrammeService {

    private final ProgrammeRepository programmeRepository;
    private final ProgrammeMapper programmeMapper;

    public ProgrammeServiceImp(ProgrammeRepository programmeRepository, ProgrammeMapper programmeMapper) {
        this.programmeRepository = programmeRepository;
        this.programmeMapper = programmeMapper;
    }

    @Override
    public ProgrammeDTO create(ProgrammeDTO dto) {
        Programme p = programmeMapper.toEntity(dto);
        return programmeMapper.toDTO(programmeRepository.save(p));
    }

    @Override
    public ProgrammeDTO update(Long id, ProgrammeDTO dto) {
        Programme p = programmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programme non trouvé"));

        p.setLibelle(dto.getLibelle());
        p.setDescription(dto.getDescription());
        // For relationships, we usually need the repository to fetch the entity proxy
        // or verify it exists.
        // Simplified approach: rely on Mapper to create new entity from DTO and copy
        // relevant fields,
        // or update fields individually.
        // Better approach for update: Fetch existing entity, update properties.
        // Update relations if IDs changed.

        // However, ProgrammeMapper toEntity creates a new Entity.
        // If we want to support updating relations via ID in DTO:
        Programme updateFromDto = programmeMapper.toEntity(dto);
        p.setParcours(updateFromDto.getParcours());
        p.setAnnee(updateFromDto.getAnnee());
        p.setUe(updateFromDto.getUe());

        return programmeMapper.toDTO(programmeRepository.save(p));
    }

    @Override
    public void delete(Long id) {
        programmeRepository.deleteById(id);
    }

    @Override
    public List<ProgrammeDTO> list() {
        return programmeRepository.findAll()
                .stream()
                .map(programmeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProgrammeDTO getProgramme(Long id) {
        return programmeMapper.toDTO(
                programmeRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Programme non trouvé")));
    }
}

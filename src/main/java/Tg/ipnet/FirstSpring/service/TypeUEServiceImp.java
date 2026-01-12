package Tg.ipnet.FirstSpring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Tg.ipnet.FirstSpring.dto.TypeUEDTO;
import Tg.ipnet.FirstSpring.entity.TypeUE;
import Tg.ipnet.FirstSpring.mappers.TypeUEMapper;
import Tg.ipnet.FirstSpring.repository.TypeUERepository;

@Service
@Transactional
public class TypeUEServiceImp implements TypeUEService {

    private final TypeUERepository typeUERepository;
    private final TypeUEMapper typeUEMapper;

    public TypeUEServiceImp(TypeUERepository typeUERepository, TypeUEMapper typeUEMapper) {
        this.typeUERepository = typeUERepository;
        this.typeUEMapper = typeUEMapper;
    }

    @Override
    public TypeUEDTO create(TypeUEDTO dto) {
        TypeUE t = typeUEMapper.toEntity(dto);
        return typeUEMapper.toDTO(typeUERepository.save(t));
    }

    @Override
    public TypeUEDTO update(Long id, TypeUEDTO dto) {
        TypeUE t = typeUERepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Type UE non trouvé"));
        t.setLibelle(dto.getLibelle());
        t.setDescription(dto.getDescription());
        return typeUEMapper.toDTO(typeUERepository.save(t));
    }

    @Override
    public void delete(Long id) {
        typeUERepository.deleteById(id);
    }

    @Override
    public List<TypeUEDTO> list() {
        return typeUERepository.findAll()
                .stream()
                .map(typeUEMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TypeUEDTO getTypeUE(Long id) {
        return typeUEMapper.toDTO(
                typeUERepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Type UE non trouvé")));
    }
}

package Tg.ipnet.FirstSpring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Tg.ipnet.FirstSpring.dto.UeDTO;
import Tg.ipnet.FirstSpring.entity.Ue;
import Tg.ipnet.FirstSpring.mappers.UeMapper;
import Tg.ipnet.FirstSpring.repository.UERepository;

@Service
@Transactional
public class UeServiceImp implements UeService {

    private final UERepository ueRepository;
    private final UeMapper ueMapper;

    public UeServiceImp(UERepository ueRepository, UeMapper ueMapper) {
        this.ueRepository = ueRepository;
        this.ueMapper = ueMapper;
    }

    @Override
    public UeDTO create(UeDTO dto) {
        Ue u = ueMapper.toEntity(dto);
        return ueMapper.toDTO(ueRepository.save(u));
    }

    @Override
    public UeDTO update(Long id, UeDTO dto) {
        Ue ue = ueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UE non trouvée"));
        ue.setCodeUe(dto.getCodeUE());
        ue.setIntituleUe(dto.getIntituleUE());
        ue.setCredit(dto.getCredit());

        Ue updateFromDto = ueMapper.toEntity(dto);
        ue.setTypeUE(updateFromDto.getTypeUE());
        ue.setParcours(updateFromDto.getParcours());

        return ueMapper.toDTO(ueRepository.save(ue));
    }

    @Override
    public void delete(Long id) {
        ueRepository.deleteById(id);
    }

    @Override
    public List<UeDTO> list() {
        return ueRepository.findAll()
                .stream()
                .map(ueMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UeDTO getUe(Long id) {
        return ueMapper.toDTO(
                ueRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("UE non trouvée")));
    }
}

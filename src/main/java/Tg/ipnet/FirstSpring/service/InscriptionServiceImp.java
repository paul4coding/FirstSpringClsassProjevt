package Tg.ipnet.FirstSpring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Tg.ipnet.FirstSpring.dto.InscriptionDTO;
import Tg.ipnet.FirstSpring.entity.Inscription;
import Tg.ipnet.FirstSpring.mappers.InscriptionMapper;
import Tg.ipnet.FirstSpring.repository.InscriptionRepository;

@Service
@Transactional
public class InscriptionServiceImp implements InscriptionService {

    private final InscriptionRepository inscriptionRepository;
    private final InscriptionMapper inscriptionMapper;

    public InscriptionServiceImp(InscriptionRepository inscriptionRepository, InscriptionMapper inscriptionMapper) {
        this.inscriptionRepository = inscriptionRepository;
        this.inscriptionMapper = inscriptionMapper;
    }

    @Override
    public InscriptionDTO create(InscriptionDTO dto) {
        Inscription i = inscriptionMapper.toEntity(dto);
        return inscriptionMapper.toDTO(inscriptionRepository.save(i));
    }

    @Override
    public InscriptionDTO update(Long id, InscriptionDTO dto) {
        Inscription i = inscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscription non trouvée"));

        i.setDateInscription(dto.getDateInscription());
        i.setEtatInscription(dto.getEtatInscription());
        i.setMontant(dto.getMontant());

        // Update relations
        Inscription updateFromDto = inscriptionMapper.toEntity(dto);
        i.setAnnee(updateFromDto.getAnnee());
        i.setEtudiant(updateFromDto.getEtudiant());
        i.setParcours(updateFromDto.getParcours());

        return inscriptionMapper.toDTO(inscriptionRepository.save(i));
    }

    @Override
    public void delete(Long id) {
        inscriptionRepository.deleteById(id);
    }

    @Override
    public List<InscriptionDTO> list() {
        return inscriptionRepository.findAll()
                .stream()
                .map(inscriptionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InscriptionDTO getInscription(Long id) {
        return inscriptionMapper.toDTO(
                inscriptionRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Inscription non trouvée")));
    }
}

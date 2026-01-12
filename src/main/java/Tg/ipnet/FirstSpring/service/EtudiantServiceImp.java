package Tg.ipnet.FirstSpring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Tg.ipnet.FirstSpring.dto.EtudiantDTO;
import Tg.ipnet.FirstSpring.entity.Etudiant;
import Tg.ipnet.FirstSpring.mappers.EtudiantMapper;
import Tg.ipnet.FirstSpring.repository.EtudiantRepository;

@Service
@Transactional
public class EtudiantServiceImp implements EtudiantService {

    private final EtudiantRepository etudiantRepository;
    private final EtudiantMapper etudiantMapper;

    public EtudiantServiceImp(EtudiantRepository etudiantRepository, EtudiantMapper etudiantMapper) {
        this.etudiantRepository = etudiantRepository;
        this.etudiantMapper = etudiantMapper;
    }

    @Override
    public EtudiantDTO create(EtudiantDTO dto) {
        Etudiant e = etudiantMapper.toEntity(dto);
        return etudiantMapper.toDTO(etudiantRepository.save(e));
    }

    @Override
    public EtudiantDTO update(Long id, EtudiantDTO dto) {
        Etudiant etudiant = etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etudiant non trouvé"));

        etudiant.setMatricule(dto.getMatricule());
        etudiant.setNom(dto.getNom());
        etudiant.setPrenom(dto.getPrenom());
        etudiant.setDateNaissance(dto.getDateNaissance());
        etudiant.setAdresse(dto.getAdresse());
        etudiant.setEmail(dto.getEmail());
        etudiant.setNumtel(dto.getNumtel());

        return etudiantMapper.toDTO(etudiantRepository.save(etudiant));
    }

    @Override
    public void delete(Long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public List<EtudiantDTO> list() {
        return etudiantRepository.findAll()
                .stream()
                .map(etudiantMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EtudiantDTO getEtudiant(Long id) {
        return etudiantMapper.toDTO(
                etudiantRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Etudiant non trouvé")));
    }
}

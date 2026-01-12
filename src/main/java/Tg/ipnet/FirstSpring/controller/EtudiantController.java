package Tg.ipnet.FirstSpring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import Tg.ipnet.FirstSpring.dto.EtudiantDTO;
import Tg.ipnet.FirstSpring.service.EtudiantService;

@RestController
@RequestMapping("api/v1/etudiant")
@CrossOrigin("*")
public class EtudiantController {

    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @PostMapping("/save")
    public EtudiantDTO create(@RequestBody EtudiantDTO dto) {
        return etudiantService.create(dto);
    }

    @GetMapping("/all")
    public List<EtudiantDTO> list() {
        return etudiantService.list();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        etudiantService.delete(id);
    }

    @GetMapping("/one/{id}")
    public EtudiantDTO getEtudiant(@PathVariable("id") Long id) {
        return etudiantService.getEtudiant(id);
    }

    @PutMapping("/update/{id}")
    public EtudiantDTO update(@RequestBody EtudiantDTO dto, @PathVariable Long id) {
        return etudiantService.update(id, dto);
    }
}

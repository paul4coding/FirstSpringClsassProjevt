package Tg.ipnet.FirstSpring.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import Tg.ipnet.FirstSpring.dto.InscriptionDTO;
import Tg.ipnet.FirstSpring.service.InscriptionService;

@RestController
@RequestMapping("api/v1/inscription")
@CrossOrigin("*")
public class InscriptionController {

    private final InscriptionService inscriptionService;

    public InscriptionController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @PostMapping("/save")
    public InscriptionDTO create(@RequestBody InscriptionDTO dto) {
        return inscriptionService.create(dto);
    }

    @GetMapping("/all")
    public List<InscriptionDTO> list() {
        return inscriptionService.list();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        inscriptionService.delete(id);
    }

    @GetMapping("/one/{id}")
    public InscriptionDTO getInscription(@PathVariable Long id) {
        return inscriptionService.getInscription(id);
    }

    @PutMapping("/update/{id}")
    public InscriptionDTO update(@RequestBody InscriptionDTO dto, @PathVariable Long id) {
        return inscriptionService.update(id, dto);
    }
}

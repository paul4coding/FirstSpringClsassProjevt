package Tg.ipnet.FirstSpring.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import Tg.ipnet.FirstSpring.dto.ParcoursDTO;
import Tg.ipnet.FirstSpring.service.ParcoursService;

@RestController
@RequestMapping("api/v1/parcours")
@CrossOrigin("*")
public class ParcoursController {

    private final ParcoursService parcoursService;

    public ParcoursController(ParcoursService parcoursService) {
        this.parcoursService = parcoursService;
    }

    @PostMapping("/save")
    public ParcoursDTO create(@RequestBody ParcoursDTO dto) {
        return parcoursService.create(dto);
    }

    @GetMapping("/all")
    public List<ParcoursDTO> list() {
        return parcoursService.list();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        parcoursService.delete(id);
    }

    @GetMapping("/one/{id}")
    public ParcoursDTO getParcours(@PathVariable Long id) {
        return parcoursService.getParcours(id);
    }

    @PutMapping("/update/{id}")
    public ParcoursDTO update(@RequestBody ParcoursDTO dto, @PathVariable Long id) {
        return parcoursService.update(id, dto);
    }
}

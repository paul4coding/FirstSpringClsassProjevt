package Tg.ipnet.FirstSpring.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import Tg.ipnet.FirstSpring.dto.UeDTO;
import Tg.ipnet.FirstSpring.service.UeService;

@RestController
@RequestMapping("api/v1/ue")
@CrossOrigin("*")
public class UeController {

    private final UeService ueService;

    public UeController(UeService ueService) {
        this.ueService = ueService;
    }

    @PostMapping("/save")
    public UeDTO create(@RequestBody UeDTO dto) {
        return ueService.create(dto);
    }

    @GetMapping("/all")
    public List<UeDTO> list() {
        return ueService.list();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        ueService.delete(id);
    }

    @GetMapping("/one/{id}")
    public UeDTO getUe(@PathVariable Long id) {
        return ueService.getUe(id);
    }

    @PutMapping("/update/{id}")
    public UeDTO update(@RequestBody UeDTO dto, @PathVariable Long id) {
        return ueService.update(id, dto);
    }
}

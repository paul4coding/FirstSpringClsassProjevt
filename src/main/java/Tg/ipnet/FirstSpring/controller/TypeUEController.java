package Tg.ipnet.FirstSpring.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import Tg.ipnet.FirstSpring.dto.TypeUEDTO;
import Tg.ipnet.FirstSpring.service.TypeUEService;

@RestController
@RequestMapping("api/v1/typeue")
@CrossOrigin("*")
public class TypeUEController {

    private final TypeUEService typeUEService;

    public TypeUEController(TypeUEService typeUEService) {
        this.typeUEService = typeUEService;
    }

    @PostMapping("/save")
    public TypeUEDTO create(@RequestBody TypeUEDTO dto) {
        return typeUEService.create(dto);
    }

    @GetMapping("/all")
    public List<TypeUEDTO> list() {
        return typeUEService.list();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        typeUEService.delete(id);
    }

    @GetMapping("/one/{id}")
    public TypeUEDTO getTypeUE(@PathVariable Long id) {
        return typeUEService.getTypeUE(id);
    }

    @PutMapping("/update/{id}")
    public TypeUEDTO update(@RequestBody TypeUEDTO dto, @PathVariable Long id) {
        return typeUEService.update(id, dto);
    }
}

package Tg.ipnet.FirstSpring.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import Tg.ipnet.FirstSpring.dto.ProgrammeDTO;
import Tg.ipnet.FirstSpring.service.ProgrammeService;

@RestController
@RequestMapping("api/v1/programme")
@CrossOrigin("*")
public class ProgrammeController {

    private final ProgrammeService programmeService;

    public ProgrammeController(ProgrammeService programmeService) {
        this.programmeService = programmeService;
    }

    @PostMapping("/save")
    public ProgrammeDTO create(@RequestBody ProgrammeDTO dto) {
        return programmeService.create(dto);
    }

    @GetMapping("/all")
    public List<ProgrammeDTO> list() {
        return programmeService.list();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        programmeService.delete(id);
    }

    @GetMapping("/one/{id}")
    public ProgrammeDTO getProgramme(@PathVariable Long id) {
        return programmeService.getProgramme(id);
    }

    @PutMapping("/update/{id}")
    public ProgrammeDTO update(@RequestBody ProgrammeDTO dto, @PathVariable Long id) {
        return programmeService.update(id, dto);
    }
}

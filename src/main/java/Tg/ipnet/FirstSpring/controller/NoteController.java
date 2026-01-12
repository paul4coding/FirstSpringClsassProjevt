package Tg.ipnet.FirstSpring.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import Tg.ipnet.FirstSpring.dto.NoteDTO;
import Tg.ipnet.FirstSpring.service.NoteService;

@RestController
@RequestMapping("api/v1/note")
@CrossOrigin("*")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/save")
    public NoteDTO create(@RequestBody NoteDTO dto) {
        return noteService.create(dto);
    }

    @GetMapping("/all")
    public List<NoteDTO> list() {
        return noteService.list();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        noteService.delete(id);
    }

    @GetMapping("/one/{id}")
    public NoteDTO getNote(@PathVariable Long id) {
        return noteService.getNote(id);
    }

    @PutMapping("/update/{id}")
    public NoteDTO update(@RequestBody NoteDTO dto, @PathVariable Long id) {
        return noteService.update(id, dto);
    }
}

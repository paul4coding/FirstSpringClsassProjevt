package Tg.ipnet.FirstSpring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import Tg.ipnet.FirstSpring.dto.FiliereDTO;
import Tg.ipnet.FirstSpring.service.FiliereService;

@RestController
@RequestMapping(path = "api/v1/filiere")
@CrossOrigin("*")
public class FiliereController {

	private final FiliereService filiereService;

	public FiliereController(FiliereService filiereService) {
		this.filiereService = filiereService;
	}

	@PostMapping("/save")
	public FiliereDTO create(@RequestBody FiliereDTO dto) {
		return filiereService.create(dto);
	}

	@GetMapping("/all")
	public List<FiliereDTO> list() {
		return filiereService.list();
	}

	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		filiereService.delete(id);
	}

	@GetMapping("one/{id}")
	public FiliereDTO getFiliere(@PathVariable("id") Long id) {
		return filiereService.getFiliere(id);
	}

	@PutMapping("/update/{id}")
	public FiliereDTO update(@RequestBody FiliereDTO dto, @PathVariable Long id) {
		return filiereService.update(id, dto);
	}
}

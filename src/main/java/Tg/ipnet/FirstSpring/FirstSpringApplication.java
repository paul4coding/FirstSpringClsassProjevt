package Tg.ipnet.FirstSpring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import Tg.ipnet.FirstSpring.entity.Filiere;
import Tg.ipnet.FirstSpring.repository.FiliereRepository;

@SpringBootApplication
public class FirstSpringApplication  implements CommandLineRunner{
	
	@Autowired
	private FiliereRepository filiereRepository;

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Filiere f = new Filiere();
		f.setNom("Genie Logiciell243pll ");
		f.setDescription("pour la creation des applications et logicielsavqpll ");
		Filiere f2 = filiereRepository.save(f);
		System.out.println(f2.getId()+' '+ f2.getNom());
		
		Filiere f1 = new Filiere();
		f1.setNom("WEB DESIGNN24pll ");
		f1.setDescription("pour le designn14pll  ");
		Filiere f3 = filiereRepository.save(f1);
		System.out.println(f3.getId()+' '+ f3.getNom());
		
		
		
		List<Filiere> filieres = filiereRepository.listFiliere();
		
		
		for (Filiere  filiere : filieres ) {
			System.out.println(filiere.getId()+" "+ filiere.getNom());
		}
		
		
	}

}

package Tg.ipnet.FirstSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Tg.ipnet.FirstSpring.entity.Annee;

public interface AnneeRepository extends JpaRepository<Annee, Long> {

	@Query("SELECT a FROM  Annee a order By a.dateDebut")
	public List<Annee> listAnnee();

	@Query(value = "SELECT * FROM annee  order By dateDebut", nativeQuery = true)
	public List<Annee> listAnneesql();

	public List<Annee> findAllByOrderByDateDebutAsc();

	// 'findAllOrderByAnnee' n'est pas valide car l'entité 'Annee' n'a pas de champ
	// 'annee'.
	// Si vous voulez trier par ID:
	public List<Annee> findAllByOrderByIdAsc();

}

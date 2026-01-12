package Tg.ipnet.FirstSpring.dto;

import java.time.LocalDateTime;

public class InscriptionDTO {
    private Long id;
    private LocalDateTime dateInscription;
    private String etatInscription;
    private Double montant;

    private Long anneeId;
    private Long etudiantId;
    private String etudiantNom;
    private Long parcoursId;
    private String parcoursNom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDateTime dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getEtatInscription() {
        return etatInscription;
    }

    public void setEtatInscription(String etatInscription) {
        this.etatInscription = etatInscription;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Long getAnneeId() {
        return anneeId;
    }

    public void setAnneeId(Long anneeId) {
        this.anneeId = anneeId;
    }

    public Long getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(Long etudiantId) {
        this.etudiantId = etudiantId;
    }

    public String getEtudiantNom() {
        return etudiantNom;
    }

    public void setEtudiantNom(String etudiantNom) {
        this.etudiantNom = etudiantNom;
    }

    public Long getParcoursId() {
        return parcoursId;
    }

    public void setParcoursId(Long parcoursId) {
        this.parcoursId = parcoursId;
    }

    public String getParcoursNom() {
        return parcoursNom;
    }

    public void setParcoursNom(String parcoursNom) {
        this.parcoursNom = parcoursNom;
    }
}

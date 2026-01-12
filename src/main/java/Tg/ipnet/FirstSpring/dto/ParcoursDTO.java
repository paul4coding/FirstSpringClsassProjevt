package Tg.ipnet.FirstSpring.dto;

public class ParcoursDTO {
    private Long id;
    private String nom;
    private Long nbrSemestre;
    private Long filiereId;
    private String filiereNom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getNbrSemestre() {
        return nbrSemestre;
    }

    public void setNbrSemestre(Long nbrSemestre) {
        this.nbrSemestre = nbrSemestre;
    }

    public Long getFiliereId() {
        return filiereId;
    }

    public void setFiliereId(Long filiereId) {
        this.filiereId = filiereId;
    }

    public String getFiliereNom() {
        return filiereNom;
    }

    public void setFiliereNom(String filiereNom) {
        this.filiereNom = filiereNom;
    }
}

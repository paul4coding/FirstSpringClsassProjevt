package Tg.ipnet.FirstSpring.dto;

public class ProgrammeDTO {
    private Long id;
    private String libelle;
    private String description;

    private Long parcoursId;
    private String parcoursNom;
    private Long anneeId;
    private Long ueId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Long getAnneeId() {
        return anneeId;
    }

    public void setAnneeId(Long anneeId) {
        this.anneeId = anneeId;
    }

    public Long getUeId() {
        return ueId;
    }

    public void setUeId(Long ueId) {
        this.ueId = ueId;
    }
}

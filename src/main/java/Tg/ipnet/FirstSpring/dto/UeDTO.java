package Tg.ipnet.FirstSpring.dto;

public class UeDTO {
    private Long id;
    private String codeUE;
    private String intituleUE;
    private Double credit;

    private Long typeUEId;
    private String typeUELibelle;
    private Long parcoursId;
    private String parcoursNom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeUE() {
        return codeUE;
    }

    public void setCodeUE(String codeUE) {
        this.codeUE = codeUE;
    }

    public String getIntituleUE() {
        return intituleUE;
    }

    public void setIntituleUE(String intituleUE) {
        this.intituleUE = intituleUE;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Long getTypeUEId() {
        return typeUEId;
    }

    public void setTypeUEId(Long typeUEId) {
        this.typeUEId = typeUEId;
    }

    public String getTypeUELibelle() {
        return typeUELibelle;
    }

    public void setTypeUELibelle(String typeUELibelle) {
        this.typeUELibelle = typeUELibelle;
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

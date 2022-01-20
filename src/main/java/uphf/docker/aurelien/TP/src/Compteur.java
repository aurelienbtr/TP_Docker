package uphf.docker.aurelien.TP.src;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "compteur")
public class Compteur {

    @Column
    public Integer valeur;

    public Integer id;

    public Compteur(int id, int valeur) {
        this.id=id;
        this.valeur=valeur;
    }

    public Integer getValeur() {
        return valeur;
    }

    public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }

    public Compteur() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    public Integer getId() {
        return id;
    }
}

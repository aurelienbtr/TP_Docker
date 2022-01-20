package uphf.docker.aurelien.TP.src;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class CompteurServices {

        @Autowired
        private CompteurRepository compteurRepository;

        public Optional<Compteur> getCompteur(final Integer id) {
            return compteurRepository.findById(id);
        }

        public Iterable<Compteur> getCompteurs() {
            return compteurRepository.findAll();
        }



        public Compteur saveCompteur(Compteur compteur) {
            Compteur savedCompteur = compteurRepository.save(compteur);
            return savedCompteur;
        }


    public ResponseEntity<?> createCompteurs() {
        Compteur cpt = new Compteur(1,2);
        compteurRepository.save(cpt);

        return ResponseEntity.ok("cpt cree");
    }


   /** public ResponseEntity<?> createCompteursREST(createCompteur createCompteur) {

        return ResponseEntity.status(HttpStatus.CREATED).body(compteurRepository.save(new Compteur(
                createCompteur.getId(),
                createCompteur.getValeur()
                )
        ));
    }
**/
    public Compteur addCompteur(int id, int valeur) {

        Compteur cpt = new Compteur(id, valeur);
        compteurRepository.save(cpt);

        return cpt;
    }

    public void deleteCompteur(int id) {

        Optional<Compteur> cpt = compteurRepository.findById(id);

        if (cpt.isPresent()) {
            compteurRepository.delete(cpt.get());
        }
    }

}


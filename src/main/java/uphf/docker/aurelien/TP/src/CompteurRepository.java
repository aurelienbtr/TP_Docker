package uphf.docker.aurelien.TP.src;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompteurRepository extends CrudRepository<Compteur, Integer>{
}
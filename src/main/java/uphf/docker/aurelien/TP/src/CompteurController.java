package uphf.docker.aurelien.TP.src;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CompteurController {

    @Autowired
    private CompteurServices compteurServices;

    @Autowired
    private CompteurRepository compteurRepository;

    @GetMapping("/compteur")
    public Iterable<Compteur> getCompteurs() {
        return compteurServices.getCompteurs();
    }

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Compteur> listCompteur = compteurServices.getCompteurs();
        model.addAttribute("compteurs", listCompteur);
        return "home";
    }

   /** @PostMapping("/saveCompteur")
    public ModelAndView saveCompteur(@ModelAttribute Compteur compteur) {
        compteurServices.saveCompteur(compteur);
        return new ModelAndView("redirect:/");
    }**/
/**
    @PostMapping("REST/saveCompteur")
    public Compteur createCompteurREST(@Validated @RequestBody createCompteur cpt){
        return compteurRepository.save(
                new Compteur
                        (
                               cpt.getValeur(),
                               cpt.getId()
                        )
        );
    }
**/
    @GetMapping("/addCompteur")
		public String formCompteur() {
        return "addCompteur"; // page html
    }

    @PostMapping("/addCompteur")
    public String createPerson(@RequestParam(name = "id", required = false, defaultValue = "*") int id,
                               @RequestParam(name = "valeur", required = false, defaultValue = "*") int valeur){

        compteurServices.addCompteur(id, valeur);

        return "redirect:/";
    }

    @PostMapping("/remove")
    public String deleteCompteur(@RequestParam(name = "id", required = false, defaultValue = "*") int id) {

        compteurServices.deleteCompteur(id);

        return "redirect:";
    }
}
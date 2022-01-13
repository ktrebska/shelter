package pl.edu.java.wszib.shelter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.java.wszib.shelter.database.Database;
import pl.edu.java.wszib.shelter.service.IAdoptionService;
import pl.edu.java.wszib.shelter.service.impl.AdoptionService;
import pl.edu.java.wszib.shelter.session.SessionObject;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/requests")
public class AdoptionController {

    @Autowired
    IAdoptionService adoptionService;

    @Resource
    SessionObject sessionObject;
    private Database database;

    @RequestMapping(value = "/add/{dogId}")
    public String requestDogAdoption(@PathVariable Integer dogId) {
        this.adoptionService.requestDogAdoption(dogId);
        return "redirect:/main";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String requests(Model model) {
        model.addAttribute("requests", this.sessionObject.getRequestList());
        model.addAttribute("logged", this.sessionObject.isLogged());
        return "requests";
    }
}

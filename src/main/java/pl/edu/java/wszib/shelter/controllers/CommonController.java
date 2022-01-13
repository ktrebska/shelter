package pl.edu.java.wszib.shelter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.java.wszib.shelter.model.Dog;
import pl.edu.java.wszib.shelter.database.Database;
import pl.edu.java.wszib.shelter.service.IDogService;
import pl.edu.java.wszib.shelter.session.SessionObject;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CommonController {

    @Autowired
    IDogService dogService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "redirect:/main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("dogs", this.dogService.getDogs());
        model.addAttribute("logged", this.sessionObject.isLogged());
        return "main";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        model.addAttribute("logged", this.sessionObject.isLogged());
        return "contact";
    }
}

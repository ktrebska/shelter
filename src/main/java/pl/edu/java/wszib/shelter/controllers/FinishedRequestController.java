package pl.edu.java.wszib.shelter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.java.wszib.shelter.service.IFinishedRequestService;
import pl.edu.java.wszib.shelter.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class FinishedRequestController {
    @Autowired
    IFinishedRequestService finishedRequestService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/finishedrequest", method = RequestMethod.GET)
    public String finishedOrder() {
        this.finishedRequestService.confirmRequest();
        return "redirect:/main";
    }

    @RequestMapping(value = "/finishedrequests", method = RequestMethod.GET)
    public String orders(Model model) {
        model.addAttribute("finishedrequests", this.finishedRequestService.getFinishedRequestsForCurrentUser());
        model.addAttribute("logged", this.sessionObject.isLogged());
        return "finished";
    }
}

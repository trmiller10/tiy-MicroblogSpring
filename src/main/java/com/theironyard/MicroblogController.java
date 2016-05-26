package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpSession;

/**
 * Created by Taylor on 5/21/16.
 */
@Controller
public class MicroblogController{
    //@Autowired
    //MessageRepository messages;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session){
        //User user = (User)session.getAttribute("User");

        //if(user == null){
        //    return "redirect:/login";
        //}

        model.addAttribute("userName", session.getAttribute("userName"));
        return "home";
    }
/*
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    */
    @RequestMapping(path="/login", method = RequestMethod.POST)
    public String loginUser(HttpSession session, String userName/*, String password*/){
        session.setAttribute("userName", userName);
        //session.setAttribute("password", password);
        return "redirect:/";
    }

}
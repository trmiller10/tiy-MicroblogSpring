package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Taylor on 5/21/16.
 */
@Controller
public class MicroblogController{
    @Autowired
    MessageRepository messageRepository;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        //User user = (User)session.getAttribute("User");

        //if(user == null){
        //    return "redirect:/login";
        //}
        Iterable<Message> messages = messageRepository.findAll();

        model.addAttribute("userName", session.getAttribute("userName"));
        model.addAttribute("messages", messages);
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

    @RequestMapping(path="/add-message", method=RequestMethod.POST)
    public String addMessage(String message) {
        //List<Message> messageList =
        Message newMessage = new Message(message);
        messageRepository.save(newMessage);
        return "redirect:/";
    }
    @RequestMapping(path="/edit-message", method = RequestMethod.POST)
    public String editMessage(int editId, String editMessage){
        Message oldMessage = messageRepository.findOne(editId);
        oldMessage.setText(editMessage);
        messageRepository.save(oldMessage);

        return "redirect:/";
    }
    @RequestMapping(path="delete-message", method=RequestMethod.POST)
    public String deleteMessage(int deleteId){
        messageRepository.delete(deleteId);
        return "redirect:/";
    }
}
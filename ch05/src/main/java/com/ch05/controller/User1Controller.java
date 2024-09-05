package com.ch05.controller;

import com.ch05.dto.User1DTO;
import com.ch05.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User1Controller {

<<<<<<< HEAD
    private final User1Service user1Service;
=======
    private User1Service user1Service;
>>>>>>> 309b2fb166e05b453e73b64c702d5fe446f7bdc0

    @Autowired
    public User1Controller(User1Service user1Service) {
        this.user1Service = user1Service;
    }


    @GetMapping("/user1/list")
<<<<<<< HEAD
    public String list(Model model){
        List<User1DTO> users = user1Service.selectUser1s();

        model.addAttribute("users", users);

=======
    public String list(Model model) {

        List<User1DTO> users = user1Service.selectUser1s();
        model.addAttribute("users", users);
>>>>>>> 309b2fb166e05b453e73b64c702d5fe446f7bdc0
        return "/user1/list";
    }

    @GetMapping("/user1/register")
<<<<<<< HEAD
    public String register(){
=======
    public String register() {

>>>>>>> 309b2fb166e05b453e73b64c702d5fe446f7bdc0
        return "/user1/register";
    }

    @PostMapping("/user1/register")
<<<<<<< HEAD
    public String register(User1DTO user1DTO){
=======
    public String register(User1DTO user1DTO) {

>>>>>>> 309b2fb166e05b453e73b64c702d5fe446f7bdc0
        user1Service.insertUser1(user1DTO);
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/modify")
<<<<<<< HEAD
    public String modify(@RequestParam("uid") String uid, Model model){

        User1DTO user1DTO = user1Service.selectUser1(uid);
        model.addAttribute(user1DTO);
=======
    public String modify(@RequestParam("uid") String uid, Model model) {

        User1DTO uiser1Dto = user1Service.selectUser1(uid);
        model.addAttribute(uiser1Dto);
>>>>>>> 309b2fb166e05b453e73b64c702d5fe446f7bdc0

        return "/user1/modify";
    }

    @PostMapping("/user1/modify")
<<<<<<< HEAD
    public String modify(User1DTO user1DTO){

        user1Service.updateUser1(user1DTO);
=======
    public String modify(User1DTO user1DTO) {

       user1Service.updateUser1(user1DTO);
>>>>>>> 309b2fb166e05b453e73b64c702d5fe446f7bdc0
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/delete")
<<<<<<< HEAD
    public String delete(@RequestParam("uid") String uid){

        user1Service.deleteUser1(uid);

        return "redirect:/user1/list";
    }

}
=======
    public String delete(@RequestParam("uid") String uid) {
        user1Service.deleteUser1(uid);

        return "/user1/list";
    }

}
>>>>>>> 309b2fb166e05b453e73b64c702d5fe446f7bdc0

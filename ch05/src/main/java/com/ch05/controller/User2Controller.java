package com.ch05.controller;

import com.ch05.dto.User2DTO;
import com.ch05.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User2Controller {

    private User2Service user2Service;

    @Autowired
    public void setUser2Service(User2Service user2Service) {
        this.user2Service = user2Service;
    }

    @GetMapping("/user2/register")
    public String register() {
        return "/user2/register";
    }

    @PostMapping("/user2/register")
    public String register(User2DTO user2DTO) {
        user2Service.insertUser2(user2DTO);

        return "redirect:/user2/list";
    }

    @GetMapping("/user2/list")
    public String list(Model model) {
        List<User2DTO> users = user2Service.selectUser2s();
        model.addAttribute("users", users);

        return "/user2/list";
    }

    @GetMapping("/user2/modify")
    public String modify() {
        return "/user2/modify";
    }

    @PostMapping("/user2/modify")
    public String modify(@RequestParam("uid") String uid, Model model) {
        User2DTO user2DTO = user2Service.selectUser2(uid);
        model.addAttribute(user2DTO);

        return "redirect:/user2/list";
    }

    @GetMapping("/user2/delete")
    public String delete(@RequestParam("uid") String uid) {
        return "direct:/user2/list";
    }

}

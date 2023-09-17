package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.services.UserService;

import java.util.List;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String allUser(Model model) {
        List<User> userList = userService.listAllUser();
        model.addAttribute("users", userList);
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUserForm(Model model){
        model.addAttribute("user", new User());
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public String addUser(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/";
    }

    @RequestMapping( value = "/update/{id}", method = RequestMethod.GET)
    public String updateUserShowForm(@PathVariable("id") Long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "update";

    }@RequestMapping( value = "/update", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    public String updateUser(@ModelAttribute("user") User user) {
        System.out.println(user);
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping( "/remove/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userService.remove(id);
        return "redirect:/";
    }
}

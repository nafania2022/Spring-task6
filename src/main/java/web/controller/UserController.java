package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import web.models.User;
import web.repository.UserRepository;
import web.service.UserService;
import web.service.UserServiceImp;

import java.util.List;

@Controller
public class UserController {

    private UserServiceImp userService;
    @Autowired
    public UserController(UserServiceImp userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String allUser(Model model) {
        List<User> userList = userService.listAllUser();
        model.addAttribute("users", userList);
        return "index";
    }
//
//    @RequestMapping(value = "/add", method = RequestMethod.GET)
//    public String addUserForm(Model model){
//        model.addAttribute("user", new User());
//        return "add";
//    }
//
//    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
//    public String addUser(@ModelAttribute("user") User user){
//        userRepository.save(user);
//        return "redirect:/";
//    }
//
//    @RequestMapping( value = "/update/{id}", method = RequestMethod.GET)
//    public String updateUserShowForm(@PathVariable("id") Long id, Model model) {
//        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id: " + id));
//        model.addAttribute("user", user);
//        return "update";
//
//    }@RequestMapping( value = "/update", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
//    public String updateUser(@ModelAttribute("user") User user) {
//        System.out.println(user);
//        userRepository.save(user);
//        return "redirect:/";
//    }
//
//    @GetMapping( "/remove/{id}")
//    public String removeUser(@PathVariable("id") Long id) {
//        userRepository.deleteById(id);
//        return "redirect:/";
//    }
}

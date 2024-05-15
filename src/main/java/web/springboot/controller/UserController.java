package web.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.springboot.model.User;
import web.springboot.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/get")
    public String findById(@RequestParam(value = "id", required = false) Long id, Model model) {
        if (id == null) {
            return "redirect:/users";
        }
        model.addAttribute("user", userService.findById(id));
        return "user";
    }

    @GetMapping("new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam(value = "id", required = false) Long id, Model model) {
        if (id == null) {
            return "redirect:/users";
        }
        model.addAttribute("user", userService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam(value = "id", required = false) Long id, Model model) {
        if (id == null) {
            return "redirect:/users";
        }
        model.addAttribute("user", userService.findById(id));
        userService.deleteUser(id);
        return "redirect:/users";
    }
}

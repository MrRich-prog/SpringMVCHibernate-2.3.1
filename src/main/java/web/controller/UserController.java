package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute User user, ModelMap model) {
        userService.saveUser(user);
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "Table";
    }

    @GetMapping(value = "/AddUserPage")
    public String index(ModelMap model) {
        model.addAttribute("user", new User());
        return "AddUser";
    }

    @GetMapping(value = "/UpdateUserPage")
    public String update(ModelMap model) {
        model.addAttribute("user", new User());
        return "UpdateUser";
    }

    @PostMapping(value = "/removeUserById")
    public String removeUserById(@RequestParam Integer id, ModelMap model) {
        userService.removeUserById(id);
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "Table";
    }

    @GetMapping(value = "/getAllUsers")
    public String getAllUsers(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "Table";
    }

    @PostMapping(value = "/cleanUserTable")
    public String cleanUserTable(ModelMap model) {
        userService.cleanUsersTable();
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "Table";
    }

    @GetMapping(value = "/getUserById")
    public String getUserById(@RequestParam Integer id, ModelMap model) {
        User user = userService.getUserById(id);
        model.addAttribute("userFind", user != null);
        model.addAttribute("user", user);
        return "UpdateUser";
    }

    @PostMapping(value = "/updateUser")
    public String updateUser(@ModelAttribute User user, ModelMap model) {
        userService.updateUser(user);
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "Table";
    }

}
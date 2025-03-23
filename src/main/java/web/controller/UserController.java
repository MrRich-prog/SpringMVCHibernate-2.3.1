package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/createUsersTable")
    public String createUsersTable(ModelMap model) {
        userService.createUsersTable();
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "Table";
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@RequestParam String name,@RequestParam Integer age, ModelMap model) {
        userService.saveUser(name, age);
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "Table";
    }

    @PostMapping(value = "/dropUsersTable")
    public String dropUsersTable(ModelMap model) {
        List<String> messages = new ArrayList<>();
        userService.dropUsersTable();
        messages.add("User table dropped!");
        model.addAttribute("messages", messages);
        return "TableDrop";
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

}
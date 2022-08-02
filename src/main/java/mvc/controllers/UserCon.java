package mvc.controllers;

import mvc.dao.UserDAO;
import mvc.models.User;
import mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserCon {
    private UserService service;

    @Autowired
    public void setService(@Qualifier("UserServiceImpl") UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    @ResponseBody
    public String users(Model model) {
        List<User> users = service.getAllUsers();
        //model.addAttribute("users", users);
        String response = "Текущие пользователи:\n";
        for(User u: users){
            response += u + "\n";
        }

        return response;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getUser(@PathVariable("id") long id) {
        return "" + service.getUserById(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public String addUser(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "email") String email
            ) {
        return "" + service.addUser(new User(username, password, email));
    }

    @PutMapping("/update")
    @ResponseBody
    public String updateUser(
            @RequestParam(value = "id") long id,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "password", required = false) String password,
            @RequestParam(value = "email", required = false) String email
    ) {
        return "" + service.updateUser(new User(id, username, password, email));
    }

    @DeleteMapping("/remove/{id}")
    @ResponseBody
    public String removeUser(@PathVariable("id") long id) {
        service.removeUser(service.getUserById(id));
        return "deleted";
    }

}

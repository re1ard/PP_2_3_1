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
@RequestMapping("/users")
public class UserCon {
    private UserService service;

    @Autowired
    public void setService(@Qualifier("UserServiceImpl") UserService service) {
        this.service = service;
    }

    @GetMapping("")
    @ResponseBody
    public String users(Model model) {
        List<User> users = service.getAllUsers();
        //model.addAttribute("users", users);
        String response = "";
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
    public String addUser(@RequestBody User user) {
        service.addUser(user);
        return "" + user;
    }

    @PutMapping("/update")
    @ResponseBody
    public String updateUser(@RequestBody User user) {
        service.updateUser(user);
        return "" + user;
    }

    @DeleteMapping("/remove/{id}")
    @ResponseBody
    public String removeUser(@PathVariable("id") long id) {
        service.removeUser(service.getUserById(id));
        return "deleted";
    }

}

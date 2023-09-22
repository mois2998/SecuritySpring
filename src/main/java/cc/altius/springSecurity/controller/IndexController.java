/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc.altius.springSecurity.controller;

import cc.altius.springSecurity.service.EmployeeService;
import cc.altius.springSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author akil
 */
@Controller
public class IndexController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String showRoot() {
        System.out.println("inside root");
        return "redirect:employeeList.htm";
    }

    @GetMapping("/employeeList.htm")
    public String showEmployeeList(ModelMap model) {
        model.addAttribute("employeeList", this.employeeService.getEmployeeList());
        model.addAttribute("user", this.userService.getUserByUsername("akil.m@altius.cc"));
        return "employeeList";
    }

    @GetMapping("/login.htm")
    public String showLoginPage() {
        System.out.println("inside login page");
        return "login";
    }
    
    @RequestMapping("/accessDenied.htm")
    @ResponseBody
    public String showErrorPage() {
        return "You tried to access a restricted page";
    }
}

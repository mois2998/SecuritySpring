///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package cc.altius.springSecurity.controller;
//
//import org.springframework.ui.ModelMap;
//import cc.altius.springSecurity.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PostAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import cc.altius.springSecurity.model.Employee;
//import cc.altius.springSecurity.service.UserService;
//import org.springframework.security.access.prepost.PreAuthorize;
//
///**
// *
// * @author altius
// */
//@Controller
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeService employeeService;
//    @Autowired
//    private UserService userService;
//     @RequestMapping("/")
//    public String showRoot() {
//        System.out.println("inside root");
//        return "redirect:employeeList.htm";
//    }
//
//    @RequestMapping("/employeeList.htm")
//    public String showEmployeeList(ModelMap model) {
//      model.addAttribute("employeeList", this.employeeService.getEmployeeList());
//        model.addAttribute("user", this.userService.getUserByUsername("akil.m@altius.cc"));
//
//        return "admin/employeeList";
//    }
//
//    @GetMapping("/editEmployee.htm")
//    public String showEmployeeEdit(@RequestParam(value = "employeeId", required = true) int id, ModelMap model) {
//        model.put("employeeObject", this.employeeService.getEmployeeById(id));
//        return "admin/editEmployee";
//    }
//
//    @PostMapping("/editEmployee.htm")
//    public String editUser(@ModelAttribute("employeeObject") Employee e) {
//
//        this.employeeService.updateEmployee(e);
//        return "redirect:employeeList.htm";
//    }
//
//    @GetMapping("/addEmployee.htm")
//    public String showEmployeeAdd(ModelMap map) {
//        map.addAttribute("employeeObject", new Employee());
//        return "admin/addEmployee";
//    }
//
//    @PostMapping("/addEmployee.htm")
//    public String addEmployee(@ModelAttribute("employeeObject") Employee e) {
//        this.employeeService.addEmployee(e);
//        return "redirect:employeeList.htm";
//    }
//
//}

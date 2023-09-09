package com.tarea.tarea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String producto(Model model) {
        model.addAttribute("titulo", "Courses List");
        model.addAttribute("tituloButtonAdd", "Add Course");
        model.addAttribute("tituloButtonUpdate", "Update");
        model.addAttribute("tituloButtonDelete", "Delete");
        model.addAttribute("thName", "Course Name");
        model.addAttribute("thInstructor", "Course Instructor");
        model.addAttribute("thEmail", "Course Email");
        model.addAttribute("thActions", "Actions");



        List<String[]> cursos = Listas();


        model.addAttribute("cursos", cursos);


        return "index"; // Devuelve el nombre de la vista HTML que se mostrará
    }

    private List<String[]> Listas() {
        List<String[]> cursos = new ArrayList<>();
        String [] curso1 = {"test1","t","asdba@gmail.com"};
        String [] curso2 = {"test1","t2","asd@gmail.com"};
        String [] curso3 = {"test1","t3","gfg@g.com"};
        String [] curso4 = {"test1","someone","gfg@dsa.com"};
        String [] curso5 = {"test1","t5","jsbasics@gfg.com"};


        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);
        cursos.add(curso4);
        cursos.add(curso5);


        return cursos;
    }






}

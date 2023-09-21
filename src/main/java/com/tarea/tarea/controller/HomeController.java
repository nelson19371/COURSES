package com.tarea.tarea.controller;

import com.tarea.tarea.Repository.CursoRepository;
import com.tarea.tarea.model.Cursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CursoRepository cursoRepository;

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
        model.addAttribute("thImages", "Images");

        List<String[]> cursos = Listas();

        // Agrega la ruta de la imagen al modelo
        String rutaImagen = "/images/imagen.png"; // Ruta relativa
        model.addAttribute("rutaImagen", rutaImagen);

        model.addAttribute("cursos", cursos);

        return "index"; // Devuelve el nombre de la vista HTML que se mostrará
    }

    private List<String[]> Listas() {
        List<String[]> cursos = new ArrayList<>();

        // Obtener los cursos de la base de datos
        List<Cursos> cursosDesdeBD = getCourses();

        // Recorrer la lista de cursos desde la base de datos y convertirlos en el formato deseado
        for (Cursos curso : cursosDesdeBD) {
            String[] cursoData = {curso.getName(), curso.getInstructor(), curso.getEmail()};
            cursos.add(cursoData);
        }

        return cursos;
    }

    @GetMapping("/courses")
    public List<Cursos> getCourses(){
        return cursoRepository.findAll();
    }
    @ResponseBody
    @PostMapping(value="/saveCourses")
    public String saveCourses(@RequestBody Cursos cursos){

        cursoRepository.save(cursos);
        return "Course Saved";

    }
    @ResponseBody
    @DeleteMapping(value="/delete/{id}")
    public String deleteCourse(@PathVariable int id){
        Cursos deleteCursos = cursoRepository.findById(id).get();
        cursoRepository.delete(deleteCursos);
        return "Deleted Course";
    }
}


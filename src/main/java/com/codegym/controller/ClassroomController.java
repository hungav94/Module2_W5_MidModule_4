package com.codegym.controller;

import com.codegym.model.Classroom;
import com.codegym.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @GetMapping("/classroom")
    public ModelAndView showListClassroom(@PageableDefault(size = 10) Pageable pageable) {
        Page<Classroom> classrooms = classroomService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("classroom/list");
        modelAndView.addObject("classrooms", classrooms);
        return modelAndView;
    }

    @GetMapping("/create-classroom")
    public ModelAndView showCreateClassroom() {
        ModelAndView modelAndView = new ModelAndView("classroom/create");
        modelAndView.addObject("classroom", new Classroom());
        return modelAndView;
    }

    @PostMapping("/create-classroom")
    public ModelAndView saveClassroom(@ModelAttribute("classroom") Classroom classroom) {
        classroomService.save(classroom);
        ModelAndView modelAndView = new ModelAndView("classroom/create");
        modelAndView.addObject("classroom", new Classroom());
        modelAndView.addObject("message", "Create classroom successfully");
        return modelAndView;
    }

    @GetMapping("/edit-classroom/{id}")
    public ModelAndView showEditClassroom(@PathVariable Long id) {
        Classroom classroom = classroomService.findAllById(id);
        ModelAndView modelAndView = null;
        if (classroom != null) {
            modelAndView = new ModelAndView("classroom/edit");
            modelAndView.addObject("classroom", classroom);
        } else {
            modelAndView = new ModelAndView("error-404");
        }
        return modelAndView;
    }

    @PostMapping("/edit-classroom")
    public ModelAndView editClassroom(@ModelAttribute("classroom") Classroom classroom) {
        classroomService.save(classroom);
        ModelAndView modelAndView = new ModelAndView("classroom/edit");
        modelAndView.addObject("classroom", classroom);
        modelAndView.addObject("message", "Edit classroom successfully");
        return modelAndView;
    }

    @GetMapping("/delete-classroom/{id}")
    public ModelAndView showDeleteClassroom(@PathVariable Long id){
        classroomService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/classroom");
        return modelAndView;
    }
}

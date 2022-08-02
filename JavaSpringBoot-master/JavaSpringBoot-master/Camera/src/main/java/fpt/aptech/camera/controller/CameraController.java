package fpt.aptech.camera.controller;

import fpt.aptech.camera.model.Camera;
import fpt.aptech.camera.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CameraController {
    @Autowired
    CameraService cameraService;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("from") String from , @Param("to") String to){
        model.addAttribute("listCamera",cameraService.showAll());
        if(from != null && to != null){
            int f = Integer.parseInt(from);
            int t = Integer.parseInt(to);
            model.addAttribute("listCamera",cameraService.showAll(f,t));
        }
        return "index";
    }
    @GetMapping("/new")
    public String saveProduct(Model model) {
        model.addAttribute("camera", new Camera());
        return "new";
    }
    @RequestMapping(value="/save", method= RequestMethod.POST)
    public String save(Model model, @ModelAttribute("product") Camera camera){
        try{
            cameraService.SaveOrUpdate(camera);
        }catch (Exception e) {
            e.fillInStackTrace();
        }
        return "redirect:/";
    }
    //update
    @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
    public String update(Model model, @PathVariable("id") String id) {
        model.addAttribute("camera",cameraService.getCameraById(id));
        return "new";
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String delete(@PathVariable("id") String id) {
        cameraService.delete(id);
        return "redirect:/";
    }
}

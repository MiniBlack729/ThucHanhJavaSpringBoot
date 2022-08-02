package fpt.aptech.day2camera.controller;

import fpt.aptech.day2camera.model.Camera;
import fpt.aptech.day2camera.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CameraController {
    @Autowired
    CameraService cameraService;

    //show all data theo dang chuoi json key:value
//    @GetMapping("/listJson")
//    public ResponseEntity<List> viewHomePage(Model model, @Param("min") String from, @Param("max") String to){
//        List<Camera> cameraList = cameraService.showAll();
//        model.addAttribute("list", cameraList);//luu data vao bien list
//        return ResponseEntity.ok(cameraList);
//    }

    //show all
    @GetMapping("/")
    public String viewHomePage(Model model, @Param("min") String from, @Param("max") String to){
        List<Camera> cameraList = cameraService.showAll();
        model.addAttribute("list", cameraList);//luu data vao bien list
        return "index";
    }

    //Create and update
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    //dung @Valid va BindingResult de check validation property trong model Camera
    public String saveCamera(@RequestParam("action") String action, @ModelAttribute("camera") @Valid Camera camera, BindingResult result){//@ModelAttribute("camera") là lấy data get từ obj camera bên html qua
        //bao loi trang create
        if (result.hasErrors() && action.equals("Create")) {//tra ve hien thi thong bao loi neu create ko thanh cong
            return "/create";
        }
        //bao loi trang update
        if (result.hasErrors() && action.equals("Update")) {//tra ve hien thi thong bao loi neu create ko thanh cong
            return "/update";
        }

        cameraService.SaveOrUpdate(camera);
        return "redirect:/";
    }

    //Create
    @GetMapping("/create")
    public String showNewEmployee(Model model){
        Camera camera = new Camera();
        model.addAttribute("camera", camera);
        return "create";
    }

    //update
    @GetMapping("/update/{id}") //route ko {id} thì dùng @RequestParam ===== route có {id} thì dùng @PathVariable
    public String updateCamera(Model model, @PathVariable("id") String id){
        //display old data
        model.addAttribute("camera",cameraService.getCameraById(id));
        return "update";
    }

    //delete employee
    @RequestMapping("delete/{id}")//route có {id} thì dùng @PathVariable
    public String deleteCamera(@PathVariable("id") String id){
        cameraService.deleteByID(id);
        return "redirect:/";
    }

    //search price
    @GetMapping("/searchPrice")
    public String searchPricePage(Model model, @Param("from") String from, @Param("to") String to){//dùng string để check null
    //dùng @Param ko yêu cầu truyền tham số đầu vào giống @RequestParam, getParameter từ field input name=from, name=to
        //pattern for search price: require 2 field not null and min must be < max
        if (from != null && to != null && Integer.parseInt(from) > Integer.parseInt(to)) { //if 2 field not null and from > to
            model.addAttribute("result", "max price must be greater than min price");
        }
        model.addAttribute("list", cameraService.showByPrice(Integer.parseInt(from),Integer.parseInt(to)));
        //return "searchPrice";//search và hiển thị result trong trang riêng
        return "index";//search và hiển thị result ở trang index
    }

    //search name
    @GetMapping("/searchName")
    public String searchNamePage(Model model, @Param("cameraName") String cameraName){//dùng string để check null
        //dùng @Param ko yêu cầu truyền tham số đầu vào giống @RequestParam, getParameter từ field input name=name
        if (cameraName != null && !cameraName.isEmpty()){//nếu có nhập keyword
            model.addAttribute("list", cameraService.showByName("%"+cameraName+"%"));
            return "index";
        } else { //nếu ko nhập keyword trả về show all
            model.addAttribute("list", cameraService.showAll());
        }
        return "searchName";//search và hiển thị result trong trang riêng
        //return "index";//search và hiển thị result ở trang index
    }
}

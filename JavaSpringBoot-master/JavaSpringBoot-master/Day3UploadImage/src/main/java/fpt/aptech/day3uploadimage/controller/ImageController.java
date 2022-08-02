package fpt.aptech.day3uploadimage.controller;

import fpt.aptech.day3uploadimage.model.Images;
import fpt.aptech.day3uploadimage.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class ImageController {
    @Autowired
    ImageService imageService;

    //show all
    @GetMapping ("/")
    public String viewAll(Model model){
        List<Images> imagesList = imageService.showAll();
        model.addAttribute("list", imagesList);
        return "index";
    }

    //Create and update
    @PostMapping("/save") //có thể dùng postmapping thay cho RequestMapping cho method post
    public String saveImage(@ModelAttribute("magic") Images image, @RequestParam("fileImage") MultipartFile multipartFile) throws IOException {
        //get fileImage
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        if (fileName == null || fileName.equals("")) {//if no upload new image
            fileName = imageService.getImageById(image.getId()).getImage();
        }
        image.setImage(fileName);
        imageService.InsertOrUpdate(image);

        //upload new image
        String uploadDir = "images/" + image.getId();//tạo đường dẫn
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {//nếu chưa có thư mục thì create
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
        return "redirect:/";
    }

    //Create
    @GetMapping("/create")
    public String showNewMagic(Model model){
        Images image = new Images();
        model.addAttribute("magic", image);
        return "create";
    }

    //Update
    @GetMapping("/update/{id}")
    public String updateImage(Model model, @PathVariable("id") int id){
        model.addAttribute("magic", imageService.getImageById(id));
        return "update";
    }

    //delete by Id
    @Transactional //delete folder after delete record from db
    @GetMapping("/delete/{id}")
    public String deleteImage(@PathVariable("id") int id){
        imageService.deleteById(id);
        FileSystemUtils.deleteRecursively(new File("N://Programs//JavaSpring//Day3UploadImage/images/" + id));
        return "redirect:/";
    }
}

package fpt.aptech.day3uploadimage.displayImage;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

//annotation upload
@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path uploadDir = Paths.get("images");
        String uploadPath = uploadDir.toFile().getAbsolutePath();

        registry.addResourceHandler("/images/**").addResourceLocations("file:/"+ uploadPath + "/");
//        xong vao model them @Transient va tao 1 ham getImagePath() de lay path display image
    }
}

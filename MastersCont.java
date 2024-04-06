package com.jewelrystore.controller;

import com.jewelrystore.controller.main.Attributes;
import com.jewelrystore.model.Masters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping("/masters")
public class MastersCont extends Attributes {

    @GetMapping
    public String masters(Model model) {
        addAttributes(model);
        model.addAttribute("masters", mastersRepo.findAll());
        return "masters";
    }

    @PostMapping("/add")
    public String masterAdd(Model model, @RequestParam String fio, @RequestParam int experience, @RequestParam String description, @RequestParam MultipartFile file) {
        Masters master = new Masters(fio, experience, description);

        if (file != null && !Objects.requireNonNull(file.getOriginalFilename()).isEmpty()) {
            String uuidFile = UUID.randomUUID().toString();
            boolean createDir = true;
            String res = "";
            try {
                File uploadDir = new File(uploadImg);
                if (!uploadDir.exists()) createDir = uploadDir.mkdir();
                if (createDir) {
                    res = uuidFile + "_" + file.getOriginalFilename();
                    file.transferTo(new File(uploadImg + "/" + res));
                }
            } catch (IOException e) {
                model.addAttribute("message", "Не удалось загрузить изображение!");
                addAttributes(model);
                model.addAttribute("masters", mastersRepo.findAll());
                return "masters";
            }

            master.setFile(res);
        }
        mastersRepo.save(master);
        return "redirect:/masters";
    }

    @GetMapping("/{id}/delete")
    public String masterDelete(@PathVariable Long id) {
        mastersRepo.deleteById(id);
        return "redirect:/masters";
    }
}

package com.jewelrystore.controller;

import com.jewelrystore.controller.main.Attributes;
import com.jewelrystore.model.StatProduct;
import com.jewelrystore.model.Product;
import com.jewelrystore.model.enums.Category;
import com.jewelrystore.model.enums.Materials;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductCont extends Attributes {
    @GetMapping("/{id}")
    public String product(Model model, @PathVariable Long id) {
        addAttributesProduct(model, id);
        return "product";
    }

    @GetMapping("/add")
    public String productAdd(Model model) {
        addAttributesProductAdd(model);
        return "product_add";
    }

    @PostMapping("/add")
    public String productAddNew(Model model, @RequestParam String name, @RequestParam double price, @RequestParam Materials material, @RequestParam Category category, @RequestParam int warranty, @RequestParam int quantity, @RequestParam MultipartFile file) {
        Product product = new Product(name, price, category, warranty, quantity, material);

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
                model.addAttribute("message", "Не удалось загрузить изображение");
                addAttributesProductAdd(model);
                return "product_add";
            }

            product.setFile(res);
        }
        StatProduct statProduct = new StatProduct();
        product.setStatProduct(statProduct);
        statProduct.setProduct(product);
        productRepo.save(product);
        statProductRepo.save(statProduct);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String productEdit(Model model, @PathVariable Long id) {
        addAttributesProductEdit(model, id);
        return "product_edit";
    }

    @PostMapping("/edit/{id}")
    public String productEditOld(Model model, @RequestParam String name, @RequestParam double price, @RequestParam Materials material, @RequestParam Category category, @RequestParam int warranty, @RequestParam int quantity, @RequestParam MultipartFile file, @PathVariable Long id) {
        Product product = productRepo.getReferenceById(id);
        product.update(name, price, category, warranty, quantity, material);

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
                model.addAttribute("message", "Не удалось загрузить изображение");
                addAttributesProductEdit(model, id);
                return "product_edit";
            }
            product.setFile(res);
        }

        productRepo.save(product);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String productDelete(@PathVariable Long id) {
        productRepo.deleteById(id);
        return "redirect:/";
    }
}

package com.jewelrystore.controller;

import com.jewelrystore.controller.main.Attributes;
import com.jewelrystore.model.enums.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexCont extends Attributes {
    @GetMapping("/about")
    public String about(Model model) {
        addAttributes(model);
        return "about";
    }

    @GetMapping("/")
    public String index1(Model model) {
        addAttributesIndex(model);
        return "products";
    }

    @PostMapping("/search")
    public String indexSearch1(Model model, @RequestParam Category category) {
        addAttributesIndex(model, category);
        return "products";
    }
    @GetMapping("/search/{category}")
    public String indexSearch2(Model model, @PathVariable Category category) {
        addAttributesIndex(model, category);
        return "products";
    }
}

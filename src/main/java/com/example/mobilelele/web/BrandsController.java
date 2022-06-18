package com.example.mobilelele.web;

import com.example.mobilelele.DTO.ShowBrandDTO;
import com.example.mobilelele.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BrandsController {


    private final BrandService brandService;

    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brands/all")
    public String allBrands(Model model) {
        model.addAttribute("brands", this.brandService.getAllBrands());
        return "brands";
    }

}

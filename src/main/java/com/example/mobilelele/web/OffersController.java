package com.example.mobilelele.web;

import com.example.mobilelele.DTO.AddOfferDTO;
import com.example.mobilelele.enums.EngineEnum;
import com.example.mobilelele.enums.TransmissionEnum;
import com.example.mobilelele.services.BrandService;
import com.example.mobilelele.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class OffersController {

    private final OfferService offerService;

    private final BrandService brandService;

    @Autowired
    public OffersController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @ModelAttribute("offerModel")
    private AddOfferDTO offerModel() {
        return new AddOfferDTO();
    }

    @GetMapping("/offers/all")
    private String offers() {
        return "offers";
    }

    @GetMapping("/offers/add")
    private String offerGet(Model model) {
        model.addAttribute("brands", this.brandService.getAllBrands());
        model.addAttribute("engines", EngineEnum.values());
        model.addAttribute("transmissions", TransmissionEnum.values());

        return "offer-add";
    }

    @PostMapping("/offers/add")
    private String offerAdd(@Valid @ModelAttribute AddOfferDTO offerModel,BindingResult bindingResult,RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("offerModel",offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel",bindingResult);
            return "redirect:/offers/add";
        }

        this.offerService.registerOffer(offerModel);
        return "redirect:/offers/all";
    }
}

package com.example.mobilelele.services;

import com.example.mobilelele.DTO.ShowBrandDTO;
import com.example.mobilelele.DTO.ShowModelDTO;
import com.example.mobilelele.models.Brand;
import com.example.mobilelele.models.Model;
import com.example.mobilelele.repositories.BrandRepository;
import com.example.mobilelele.repositories.ModelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper modelmapper;


    @Autowired
    public BrandService(BrandRepository brandRepository, ModelRepository modelRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.modelmapper = modelMapper;
    }

    public List<ShowBrandDTO> getAllBrands() {

//        List<ShowBrandDTO> result = new ArrayList<>();
//
//        List<Model> all = this.modelRepository.findAll();
//
//        List<Brand> brands = this.brandRepository.findAll();
//
//        for (Brand brand : brands) {
//            ShowBrandDTO showBrandDTO = new ShowBrandDTO();
//
//            showBrandDTO.setName(brand.getName());
//
//            List<Model> collect = brand.getModels();
//
//            for (Model model : collect) {
//                ShowModelDTO map = this.modelmapper.map(model, ShowModelDTO.class);
//                showBrandDTO.getModels().add(map);
//            }
//
////                    .stream(m -> this.modelmapper.map(m , ShowModelDTO.class))
////                    .map(m-> showBrandDTO.getModels().add(m))
//            result.add(showBrandDTO);
//        }
//        return result;


        List<Brand> all = this.brandRepository.findAll();

        ShowBrandDTO[] map = this.modelmapper.map(all, ShowBrandDTO[].class);

        return Arrays.stream(map).toList();
    }

}

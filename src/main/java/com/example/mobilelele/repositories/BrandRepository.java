package com.example.mobilelele.repositories;

import com.example.mobilelele.DTO.ShowBrandDTO;
import com.example.mobilelele.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {

}

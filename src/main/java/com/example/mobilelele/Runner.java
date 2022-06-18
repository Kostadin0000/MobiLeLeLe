package com.example.mobilelele;

import com.example.mobilelele.enums.CategoryEnum;
import com.example.mobilelele.enums.RoleEnum;
import com.example.mobilelele.models.Brand;
import com.example.mobilelele.models.Model;
import com.example.mobilelele.models.User;
import com.example.mobilelele.models.UserRole;
import com.example.mobilelele.repositories.BrandRepository;
import com.example.mobilelele.repositories.ModelRepository;
import com.example.mobilelele.repositories.UserRepository;
import com.example.mobilelele.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {


    private final PasswordEncoder passwordEncoder;

    private final UserRoleRepository userRoleRepository;

    private final UserRepository userRepository;

    private final BrandRepository brandRepository;

    private final ModelRepository modelRepository;

    @Autowired
    public Runner(PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository, UserRepository userRepository, BrandRepository brandRepository, ModelRepository modelRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//
//        User user = new User();
//        User admin = new User();
//        User mod = new User();
//
//        UserRole userRole = new UserRole();
//        UserRole adminRole = new UserRole();
//        UserRole modRole = new UserRole();
//
//        userRole.setName(RoleEnum.USER);
//        adminRole.setName(RoleEnum.ADMIN);
//        modRole.setName(RoleEnum.MODERATOR);
//
//        this.userRoleRepository.saveAll(List.of(userRole, adminRole, modRole));
//
//        createUser("Georgi", "Georgiev", "12345", "george@gmail.com", List.of(userRole));
//        createUser("Pesho", "Georgiev", "123456", "peshko@gmail.com", List.of(userRole, adminRole));
//
//        Brand ferrari = createBrand("Ferrari");
//        Brand porsche = createBrand("Porsche");
//
//        createModels(CategoryEnum.CAR, null,
//                "https://ag-spots-2021.o.auroraobjects.eu/2021/05/28/ferrari-488-pista-c384128052021185912_1.jpg",
//                "488 Pista", ferrari, 2018);
//
//        createModels(CategoryEnum.CAR, null,
//                "https://newsroom.porsche.com/.imaging/mte/porsche-templating-theme/image_1080x624/dam/pnr/2022/Products/911-Classic/_F1A0988_le_02a.jpeg/jcr:content/_F1A0988_le_02a.jpeg",
//                "911", porsche, 2016);
//
//        createModels(CategoryEnum.CAR, null,
//                "https://2p2bboli8d61fqhjiqzb8p1a-wpengine.netdna-ssl.com/wp-content/uploads/2022/02/2015-Ferrari-LaFerrari-_0-1140x570.jpg",
//                "LaFerrari", ferrari, 2019);


    }

    private void createModels(CategoryEnum car, Integer endYear, String imageUrl, String modelName, Brand brand, int startYear) {

        Model model = new Model();
        model.setBrand(brand);
        model.setCategory(car);
        model.setEndYear(endYear);
        model.setImageUrl(imageUrl);
        model.setStartYear(startYear);
        model.setName(modelName);
        this.modelRepository.save(model);
    }

    public Brand createBrand(String brandName) {
        Brand brand = new Brand();
        brand.setName(brandName);
        this.brandRepository.save(brand);
        return brand;
    }

    public void createUser(String firstName, String lastName, String password, String email, List<UserRole> roles) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        user.setActive(true);
        user.setRoles(roles);
        this.userRepository.save(user);
    }
}






package com.example.mobilelele.services;

import com.example.mobilelele.DTO.AddOfferDTO;
import com.example.mobilelele.DTO.OfferSummaryDTO;
import com.example.mobilelele.models.Offer;
import com.example.mobilelele.repositories.ModelRepository;
import com.example.mobilelele.repositories.OfferRepository;
import com.example.mobilelele.repositories.UserRepository;
import com.example.mobilelele.session.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    private final UserRepository userRepository;

    private final CurrentUser currentUser;

    private final ModelRepository modelRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository, ModelMapper modelMapper, UserRepository userRepository, CurrentUser currentUser, ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelRepository = modelRepository;
    }

    public List<OfferSummaryDTO> getAllOffers() {

        List<Offer> all = this.offerRepository.findAll();

        OfferSummaryDTO[] map = this.modelMapper.map(all, OfferSummaryDTO[].class);

        return Arrays.asList(map);
    }


    public void registerOffer(AddOfferDTO addOfferDTO) {
        Offer offer = makeEntity(addOfferDTO);
        this.offerRepository.save(offer);

    }

    private Offer makeEntity(AddOfferDTO dto) {
        Offer offer = this.modelMapper.map(dto, Offer.class);

        offer.setId(null);
        offer.setModel(this.modelRepository.findById(dto.getModelId()).get());
        offer.setSeller(this.userRepository.findByEmail(currentUser.getEmail()).get());
        return offer;

    }
}

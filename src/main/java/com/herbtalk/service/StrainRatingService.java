package com.herbtalk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herbtalk.model.StrainRating;
import com.herbtalk.repository.StrainRatingRepository;
import com.herbtalk.repository.StrainRepository;
import com.herbtalk.repository.StrainUseRepository;
import com.herbtalk.repository.UserRepository;

/**
 * 
 * This class implements the interface IStrainRatingService.
 * 
 * @author zoheb.nawaz
 *
 */
@Service
public class StrainRatingService implements IStrainRatingService {

    @Autowired
    StrainRatingRepository strainRatingRepo;

    @Autowired
    StrainRepository strainRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StrainUseRepository strainUseRepository;

    @Override
    public Double getAvgStrainRating(Integer strainId) {
        return strainRatingRepo.getAvgStrainRating(strainId);
    }

    @Override
    public StrainRating addStrainRating(Integer strainId, Integer userId, Integer strainUseId, Integer rating) {
        strainRatingRepo.addStrainRating(strainId, userId, strainUseId, rating);
        return null;
    }

    @Override
    public Integer getRatingOfUse(Integer strainUseId) {
        return strainRatingRepo.getRatingOfUse(strainUseId);
    }
}
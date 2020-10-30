package com.herbtalk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herbtalk.repository.StrainLikeRepository;

/**
 * 
 * This class implements the interface IStrainLikeService.
 * 
 * @author zoheb.nawaz
 *
 */
@Service
public class StrainLikeService implements IStrainLikeService {

    @Autowired
    StrainLikeRepository strainLikeRepo;

    @Override
    public Integer getStrainLikeCount(Integer strainId) {
        return strainLikeRepo.getStrainLikeCount(strainId);
    }

    @Override
    public void likeStrain(Integer strainId, Integer userId) {
        strainLikeRepo.likeStrain(strainId, userId);
    }

    @Override
    public void unlikeStrain(Integer strainId, Integer userId) {
        strainLikeRepo.unlikeStrain(strainId, userId);
    }
}
package com.example.demo.district;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;
    public List<District> listAllDistrict() {
        return  districtRepository.findAll();
    }

    public District saveDistrict(District district){
        districtRepository.save(district);
        return district;
    }

    public  District getDistrict(Integer id){
        return  districtRepository.findById(id).get();

    }
    public void deleteDistrict(Integer id){
        districtRepository.deleteById(id);
    }
}

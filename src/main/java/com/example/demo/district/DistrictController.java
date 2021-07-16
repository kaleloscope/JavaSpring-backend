package com.example.demo.district;

import com.example.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = {"Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization"}, methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    DistrictService districtService;
    private District district;
    private Integer id;

    @GetMapping()
    public List<District> list(){
        return districtService.listAllDistrict();

    }

    @PostMapping()
    public District createDistrict(@RequestBody District district) {
        return districtService.saveDistrict(district);
    }

    @GetMapping("{id}")
    public ResponseEntity<District> get(@PathVariable Integer id){
        try {
            District district = districtService.getDistrict(id);
            return new ResponseEntity<District>(district, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<District>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update (@RequestBody District district, @PathVariable Integer id){
        this.district = district;
        this.id = id;
        try {
            District existDistrict = districtService.getDistrict(id);
            district.setId(id);
            districtService.saveDistrict(district);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        districtService.deleteDistrict(id);
    }

}

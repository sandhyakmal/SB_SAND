package edu.sandhy.sbjdbcexample.controller;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 11/22/2022 1:52 PM
Last Modified on 11/22/2022 1:52 PM
Version 1.0
*/

import edu.sandhy.sbjdbcexample.model.DimOrganization;
import edu.sandhy.sbjdbcexample.repository.DimOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cobaapi/v1")
public class DimOrganizationController {

    @Autowired
    DimOrganizationRepository dimOrganizationRepository;

    @GetMapping("dimorganizations/{id}")
    public ResponseEntity<DimOrganization> getDimOrganizationById(@PathVariable("id") long id){
        DimOrganization dimOrganization = dimOrganizationRepository.findByID(id);

        if (dimOrganization !=null){
            return new ResponseEntity<>(dimOrganization, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/dimorganizations")
    public ResponseEntity<String> createDimOrganization(@RequestBody DimOrganization dimOrganization){
        try{
            dimOrganizationRepository.save(new DimOrganization(dimOrganization.getParentorganizationkey(),
                    dimOrganization.getPercentageofownership(),
                    dimOrganization.getOrganizationname(),
                    dimOrganization.getCurrencykey()));
                return new ResponseEntity<>("Data Berhasil Ditambahkan.",HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/dimorganizations/{id}")
    public ResponseEntity<String> updateDimOrganization(@PathVariable("id") long id, @RequestBody DimOrganization dimOrganization){
        DimOrganization _dimOrganization = dimOrganizationRepository.findByID(id);

        if (_dimOrganization !=null){
            _dimOrganization.setOrganizationkey(id);
            _dimOrganization.setParentorganizationkey(dimOrganization.getParentorganizationkey());
            _dimOrganization.setPercentageofownership(dimOrganization.getPercentageofownership());
            _dimOrganization.setOrganizationname(dimOrganization.getOrganizationname());
            _dimOrganization.setCurrencykey(dimOrganization.getCurrencykey());

            dimOrganizationRepository.update(_dimOrganization);
            return new ResponseEntity<>("Data Berhasil diubah.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Data tidak Ditemukan!! id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/dimorganizations/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id) {
        try {
            int result = dimOrganizationRepository.deleteByID(id);
            if (result == 0) {
                return new ResponseEntity<>("Data dengan id " + id +" Tidak Ditemukan !!", HttpStatus.OK);
            }
            return new ResponseEntity<>("Data dengan id "+id+" Berhasil di hapus", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Tidak dapat menghapus data .", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/dimorganizations/deleteall")
    public ResponseEntity<String> deleteAll() {
        try {
            int numRows = dimOrganizationRepository.deleteAll();
            return new ResponseEntity<>("Berhasil Menghapus  " + numRows + " Data .", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Tidak dapat menghapus data.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/dimorganizations/datas/{name}")
    public ResponseEntity<List<DimOrganization>> findByOrganizationName(@PathVariable("name") String name) {
        try {
            List<DimOrganization> lsDimOrganization = dimOrganizationRepository.findByOrganizationName(name);

            if (lsDimOrganization.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lsDimOrganization, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.bcafinance.sandhy.sbjdbcexample.repository;

import com.bcafinance.sandhy.sbjdbcexample.model.DimOrganization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 11/22/2022 1:19 PM
Last Modified on 11/22/2022 1:19 PM
Version 1.0
*/
@Repository
public class JDBCDimOrganizationRepository implements DimOrganizationRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(DimOrganization doz) {
        return jdbcTemplate.update("INSERT INTO DimOrganization(ParentOrganizationKey, PercentageOfOwnership, OrganizationName, CurrencyKey) VALUES (?,?,?,?)",
                new Object[]{
                        doz.getParentorganizationkey(),
                        doz.getPercentageofownership(),
                        doz.getOrganizationname(),
                        doz.getCurrencykey()
                });
    }

    @Override
    public int update(DimOrganization doz) {
        return jdbcTemplate.update("UPDATE DimOrganization SET ParentOrganizationKey=?, PercentageOfOwnership=?, OrganizationName=?, CurrencyKey=? WHERE OrganizationKey=?",
                new Object[]{
                        doz.getParentorganizationkey(),
                        doz.getPercentageofownership(),
                        doz.getOrganizationname(),
                        doz.getCurrencykey(),
                        doz.getOrganizationkey()
                });
    }

    @Override
    public DimOrganization findById(long id) {
        try {
            DimOrganization dimOrganization = jdbcTemplate.queryForObject("SELECT * FROM DimOrganization WHERE OrganizationKey=?",
                    BeanPropertyRowMapper.newInstance(DimOrganization.class), id);

            return dimOrganization;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int deleteById(long id) {
        return jdbcTemplate.update("DELETE FROM DimOrganization WHERE OrganizationKey=?", id);
    }

    @Override
    public List<DimOrganization> findAll() {
        return jdbcTemplate.query("SELECT * from DimOrganization",
                BeanPropertyRowMapper.newInstance(DimOrganization.class));
    }

    @Override
    public List<DimOrganization> findByOrganizationName (String name){
        return jdbcTemplate.query("SELECT * from DimOrganization WHERE OrganizationName=?",
                BeanPropertyRowMapper.newInstance(DimOrganization.class), name);
    }

    @Override
    public int deleteAll() {
        return 0;
    }

    @Override
    public DimOrganization findByID(long id) {
        try {
            DimOrganization dimOrganization = jdbcTemplate.queryForObject("SELECT * FROM DimOrganization WHERE OrganizationKey=?",
                    BeanPropertyRowMapper.newInstance(DimOrganization.class), id);

            return dimOrganization;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int deleteByID(long id) {
        return jdbcTemplate.update("DELETE FROM DimOrganization WHERE OrganizationKey=?", id);
    }


}


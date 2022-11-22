package edu.sandhy.sbjdbcexample.repository;

import edu.sandhy.sbjdbcexample.model.DimOrganization;

import java.util.List;

public interface DimOrganizationRepository {

    int save(DimOrganization doz);
    int update(DimOrganization doz);
    DimOrganization findById(long id);

    int deleteById(long id);
    List<DimOrganization> findAll();

    List<DimOrganization> findByOrganizationName(String name);
    int deleteAll();

    DimOrganization findByID(long id);

    int deleteByID(long id);
}

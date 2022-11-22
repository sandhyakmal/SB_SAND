package com.bcafinance.sandhy.sbjdbcexample.model;
/*
@Author Andara a.k.a. Sandhy
Junior Programmer
Created with IntelliJ IDEA Version 2022.2.3 (Community Edition)
Created on 11/22/2022 12:00 PM
Last Modified on 11/22/2022 12:00 PM
Version 1.0
*/

public class DimOrganization {
    private long organizationkey;

    private long parentorganizationkey;

    private double percentageofownership;

    private String organizationname;

    private int currencykey;

    public DimOrganization(){}

    public DimOrganization(long organizationkey, long parentorganizationkey, double percentageofownership, String organizationname, int currencykey){
        this.organizationkey = organizationkey;
        this.parentorganizationkey = parentorganizationkey;
        this.percentageofownership = percentageofownership;
        this.organizationname = organizationname;
        this.currencykey = currencykey;
    }

    public DimOrganization(long parentorganizationkey, double percentageofownership, String organizationname, int currencykey){
        this.parentorganizationkey = parentorganizationkey;
        this.percentageofownership = percentageofownership;
        this.organizationname = organizationname;
        this.currencykey = currencykey;
    }

    public long getOrganizationkey(){
        return organizationkey;
    }

    public void setOrganizationkey(long organizationkey){
        this.organizationkey = organizationkey;
    }

    public long getParentorganizationkey(){
        return parentorganizationkey;
    }

    public void setParentorganizationkey(long parentorganizationkey) {
        this.parentorganizationkey = parentorganizationkey;
    }

    public double getPercentageofownership(){
        return percentageofownership;
    }

    public void setPercentageofownership(double percentageofownership) {
        this.percentageofownership = percentageofownership;
    }

    public String getOrganizationname(){
        return organizationname;
    }

    public void setOrganizationname(String organizationname){
        this.organizationname = organizationname;
    }

    public int getCurrencykey(){
        return currencykey;
    }

    public void setCurrencykey(int currencykey) {
        this.currencykey = currencykey;
    }
}

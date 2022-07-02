package com.Nations.model;

import java.math.BigDecimal;

public class CountriesHighestGDP {
    private long countryId;
    private String name;
    private String countryCode3;
    private int year;
    private long population;
    private BigDecimal gdp = BigDecimal.ZERO;

    public CountriesHighestGDP(long countryId, String name, String countryCode3, int year, long population, BigDecimal gdp) {
        this.countryId = countryId;
        this.name = name;
        this.countryCode3 = countryCode3;
        this.year = year;
        this.population = population;
        this.gdp = gdp;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode3() {
        return countryCode3;
    }

    public void setCountryCode3(String countryCode3) {
        this.countryCode3 = countryCode3;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public BigDecimal getGdp() {
        return gdp;
    }

    public void setGdp(BigDecimal gdp) {
        this.gdp = gdp;
    }
}

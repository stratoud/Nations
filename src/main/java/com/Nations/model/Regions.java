package com.Nations.model;

public class Regions {
    private long regionId;
    private String name;
    private long continentId;


    public long getRegionId() {
        return regionId;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getContinentId() {
        return continentId;
    }

    public void setContinentId(long continentId) {
        this.continentId = continentId;
    }

}

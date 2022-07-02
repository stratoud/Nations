package com.Nations.model;

public class CountryLanguages {
    private long countryId;
    private long languageId;
    private long official;

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(long languageId) {
        this.languageId = languageId;
    }

    public long getOfficial() {
        return official;
    }

    public void setOfficial(long official) {
        this.official = official;
    }

}

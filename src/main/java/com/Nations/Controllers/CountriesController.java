package com.Nations.Controllers;

import com.Nations.daos.CountriesMapper;
import com.Nations.model.Countries;
import com.Nations.model.CountriesHighestGDP;
import com.Nations.model.CountryStatistics;
import com.Nations.model.CountryStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class CountriesController {

    @Autowired
    private CountriesMapper countriesMapper;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/allCountries")
    public List<Countries> getCountries() {
        return countriesMapper.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/getCountriesStatistics/{id}")
    public List<CountryStatistics> getCountriesStatistics(@PathVariable long id) {
        return countriesMapper.findCountriesStatistics(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/getCountriesByGDP")
    public List<CountriesHighestGDP> getCountriesByGDP() {

        List<CountriesHighestGDP> highestGDPCountries = new ArrayList<CountriesHighestGDP>();
        List<CountryStats> countryStats = countriesMapper.findAllCountryStats();

        HashMap<Long, CountryStats> gdpMap = new HashMap();
        for (CountryStats countryStat : countryStats) {
            long countryId = countryStat.getCountryId();
            if (gdpMap.containsKey(countryId) && gdpMap.get(countryId).getGdp().compareTo(countryStat.getGdp()) < 0) {
                gdpMap.put(countryId, countryStat);
            }
            if (!gdpMap.containsKey(countryId)) {
                gdpMap.put(countryId, countryStat);
            }
        }

        List<Countries> countries = countriesMapper.findAll();
        for (Countries country : countries) {
            long countryId = country.getCountryId();
            BigDecimal gdp = null;
            long population = 0;
            int year = 0;
            if (gdpMap.containsKey(countryId)){
                gdp = gdpMap.get(countryId).getGdp();
                population = gdpMap.get(countryId).getPopulation();
                year = gdpMap.get(countryId).getYear();
            }

            CountriesHighestGDP highestGDPCountry = new CountriesHighestGDP(
                    countryId,
                    country.getName(),
                    country.getCountryCode3(),
                    year,
                    population,
                    gdp);
            highestGDPCountries.add(highestGDPCountry);
        }

        return highestGDPCountries;
    }
}

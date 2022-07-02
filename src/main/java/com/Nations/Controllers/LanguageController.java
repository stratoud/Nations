package com.Nations.Controllers;

import com.Nations.daos.CountriesMapper;
import com.Nations.daos.LanguagesMapper;
import com.Nations.model.Countries;
import com.Nations.model.CountryLanguages;
import com.Nations.model.Languages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LanguageController {

    @Autowired
    private LanguagesMapper languagesMapper;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/findLanguageByCountryId/{id}")
    public List<Languages> getLaguageByCountryId(@PathVariable long id){
        return languagesMapper.findLanguagesById(id);
    }
}
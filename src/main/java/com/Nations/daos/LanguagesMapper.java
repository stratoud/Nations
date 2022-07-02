package com.Nations.daos;

import com.Nations.model.Countries;
import com.Nations.model.CountryLanguages;
import com.Nations.model.Languages;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
@MapperScan("com.Nations.model")
public interface LanguagesMapper {

    @Select("SELECT l.* FROM country_languages AS cl " +
            "INNER JOIN languages as l " +
            "ON (l.language_id=cl.language_id) " +
            "where cl.country_id = #{id}")
    public List<Languages> findLanguagesById(@Param("id") long id);

    @Select("select * from country_languages where country_id = #{country}")
    public List<CountryLanguages> findCountryLanguagesByCountryId(@Param("country") long countryId);

}

package com.Nations.daos;

import com.Nations.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
@MapperScan("com.Nations.model")
public interface CountriesMapper {

    @Select("select * from countries order by name")
    public List<Countries> findAll();

    @Select("select * from country_stats")
    public List<CountryStats> findAllCountryStats();

    @Select("select co.name as countryName, ct.name as continentName, rg.name as regionName," +
            " cs.year as year, cs.population as population, cs.gdp as gdp" +
            " FROM countries AS co" +
            " INNER JOIN country_stats as cs" +
            " ON (cs.country_id = co.country_id)" +
            " INNER JOIN regions as rg" +
            " ON (rg.region_id = co.region_id)" +
            " INNER JOIN continents as ct" +
            " ON (rg.continent_id = ct.continent_id)" +
            " where cs.country_id = #{id}")
    public List<CountryStatistics> findCountriesStatistics(@Param("id") long id);

}

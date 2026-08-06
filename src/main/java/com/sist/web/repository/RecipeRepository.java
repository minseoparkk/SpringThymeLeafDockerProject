package com.sist.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.Recipe;
import java.util.*;
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    public List<Recipe> findByTitleContains(String title);
    public List<Recipe> findByChefContains(String chef);
    /*
     *   findBy컬럼명연산자 
     *         ---- -----
     *   findByName(String name) 
     *   => WHERE name=? ========> equals 
     *   findByTitleStartsWith(String title) 
     *   => WHERE title LIKE 'title%'
     *   findByTitleEndsWith(String title) 
     *   => WHERE title LIKE '%title'
     *   findByTitleContains(String title)   
     *   => WHERE title LIKE '%title%'
     *   findByOrderByTitleDesc()
     *   
     *   findAll(Pageable , Sort) 
     *   count()
     *   save() / delete()
     */
}
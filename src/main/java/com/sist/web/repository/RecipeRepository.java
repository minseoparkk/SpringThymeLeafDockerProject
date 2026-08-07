package com.sist.web.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.Recipe;
import java.util.*;
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    public Page<Recipe> findByTitleContains(String title,Pageable pg);
    /*
     *   SELECT * 
     *   FROM recipe
     *   WHERE title LIKE '%데이터%'
     *   OFFSET ? ROWS FETCH NEXT ? ROWS ONLY
     */
    public Page<Recipe> findByChefContains(String chef,Pageable pg);
    public long countByTitleContains(String title);
    /*
     *   SELECT COUNT(*) 
     *   FROM recipe
     *   WHERE title LIKE '%데이터%'
     */
    public long countByChefContains(String chef);
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
    @Query(
    		value="""
    		SELECT *
    		FROM recipe
    		WHERE no IN(SELECT no FROM recipe
    		            INTERSECT
    		            SELECT no FROM recipedetail)
    		ORDER BY no DESC
    		OFFSET :start ROWS FETCH NEXT 12 ROWS ONLY
    	    """,nativeQuery = true
    	  )
    public List<Recipe> recipeListData(@Param("start") int start);
    
    @Query(
    		value="""
    		SELECT COUNT(*)
    		FROM recipe
    		WHERE no IN(SELECT no FROM recipe
    		            INTERSECT
    		            SELECT no FROM recipedetail)
    	    """,nativeQuery = true
    	  )
    public int recipeCount();
}
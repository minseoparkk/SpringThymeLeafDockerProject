package com.sist.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.*;
import java.util.*;
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer>{
	public List<Recipe> findbyTitleContains(String title);
	public List<Recipe> findbyChefContains(String chef);
		
}

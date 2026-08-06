package com.sist.web.service;
import java.util.*;
import com.sist.web.entity.*;
public interface RecipeService {
	public List<Recipe> findbyTitleContains(String title);
	public List<Recipe> findbyChefContains(String chef);
	public List<Recipe> findbyTitleContains(String title);
	public List<Recipe> findbyChefContains(String chef);
}

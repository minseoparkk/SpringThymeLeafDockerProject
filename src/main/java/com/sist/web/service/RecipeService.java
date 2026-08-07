package com.sist.web.service;
import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sist.web.entity.*;
public interface RecipeService {
	public List<Recipe> findByTitleContains(String title,int page);
    public List<Recipe> findByChefContains(String chef,int page);
    public List<Recipe> recipeListData(int page);
    public int[] getPageData(int page,int rowsize);
    public List<Chef> chefListData(int page);
    public int[] getPageDataFind(int mode,int page,int rowsize,String fd);
    public int recipeCount();
    public RecipeDetail findByNo(int no);
}
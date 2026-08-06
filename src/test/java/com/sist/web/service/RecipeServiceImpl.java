package com.sist.web.service;

import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService{
	private final RecipeRepository rDao;

	@Override
	public List<Recipe> findbyTitleContains(String title) {
		// TODO Auto-generated method stub
		return rDao.findbyTitleContains(title);
	}

	@Override
	public List<Recipe> findbyChefContains(String chef) {
		// TODO Auto-generated method stub
		return rDao.findbyChefContains(chef);
	}
}

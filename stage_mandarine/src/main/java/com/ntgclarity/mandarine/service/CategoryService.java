/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.service;

import com.ntgclarity.mandarine.constants.CodesAndKeys;
import com.ntgclarity.mandarine.dto.StatusResponse;
import com.ntgclarity.mandarine.entity.Category;
import com.ntgclarity.mandarine.entity.Component;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.repository.CategoryRepository;
import com.ntgclarity.mandarine.service.base.BaseRepository;
import com.ntgclarity.mandarine.service.base.BaseService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sheko
 */
@Service
public class CategoryService extends BaseService<Category> {

	@Autowired
	CategoryRepository categoryRepository;

	public void addCategory(Category category) {

		categoryRepository.save(category);
	}

	public void updateCategory(Category category) {
		if (category.getName().trim().isEmpty() || category.getType().trim().isEmpty())
			throw new ApplicationException("400", "category name and type are required");
		categoryRepository.save(category);
	}

	public void deleteCategory(Category category) {
		Category cat = categoryRepository.findOne(category.getId());
		
		if (cat == null||cat.getComponentCollection().size()>0) {
			throw new ApplicationException(new StatusResponse(CodesAndKeys.CAN_NOT_DELETE_ENTITY_CODE,
					CodesAndKeys.CAN_NOT_DELETE_ENTITY_KEY, "No Category Available to delete"));
		}
		cat.setDeleted(1);
		categoryRepository.save(cat);
	}

	public List<Category> getAllCategoriesName() {
		List<Category> categories = new ArrayList<>();
		categoryRepository.findAll().forEach((t) -> {
//			t.getComponentCollection().forEach((a) -> {
//				a.setCategoryId(null);
//			});
			t.setComponentCollection(null);
			categories.add(t);
		});
		return categories;
	}
	
	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<>();
		categoryRepository.findAll().forEach((t) -> {
			t.getComponentCollection().forEach((a) -> {
				a.setCategoryId(null);
			});
			categories.add(t);
		});
		return categories;
	}

	public Category getOneCategory(Long id) {
		if (id < 0)
			throw new ApplicationException("400", "Invalid Id");
		Category category = categoryRepository.findOne(id);
		if (category == null)
			throw new ApplicationException("400", "Invalid Id");
		return category;

	}

	public int totalCount() {
		return  (int)categoryRepository.count();
	}

	@Override
	public BaseRepository<Category> getRepositoryInstance() {

		return categoryRepository;
	}

	public List<Component> getAllComponents(Long id) {

		Category category = categoryRepository.findOne(id);
		return (List<Component>) category.getComponentCollection();

	}

}

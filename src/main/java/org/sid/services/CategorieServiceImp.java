package org.sid.services;

import java.util.List;

import org.sid.dao.CategoryRepo;
import org.sid.entities.Category;
import org.sid.entities.Ouvrage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategorieServiceImp implements CategorieService{
	@Autowired
	private CategoryRepo categorieRepository;
	public Category saveCategories(Category c) {
		return categorieRepository.save(c);
	}

	public List<Category> getAllCategories() {
		return categorieRepository.findAll();
	}

	public Category editCategorie(int id,Ouvrage o) {
		Category c = categorieRepository.getOne(id);
		c.getOuvrages().add(o);
		return categorieRepository.save(c);
	}

}

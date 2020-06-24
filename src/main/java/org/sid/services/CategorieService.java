package org.sid.services;

import java.util.List;

import org.sid.entities.Category;
import org.sid.entities.Ouvrage;

public interface CategorieService {
	
	public Category saveCategories(Category c);

	public List<Category> getAllCategories();

	public Category editCategorie(int id, Ouvrage o);
}

package com.reto.skate.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.skate.model.Category;
import com.reto.skate.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> obtenerCategoryCompleta(){
        return categoryRepository.obtenerCategoryCompleta();

    }

    public Optional<Category> obtenerCategoryId(Integer id){
        return categoryRepository.obtenerCategoryId(id);
    }

    public Category salvarCategory(Category category){
        if(category.getId()==null){
            return categoryRepository.salvarCategory(category);
        }
        else{
            Optional <Category> categoryAuxiliar = categoryRepository.obtenerCategoryId(category.getId());
            if(categoryAuxiliar.isEmpty()){
                return categoryRepository.salvarCategory(category);
            }
            else{
                return category;
            }
        }

    }

    public Category updateCategory(Category category){
        if(category.getId()!=null){
            Optional<Category>categoryAuxiliar = categoryRepository.obtenerCategoryId(category.getId());
            if(!categoryAuxiliar.isEmpty()){
                if(category.getDescription()!=null){
                    categoryAuxiliar.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    categoryAuxiliar.get().setName(category.getName());
                }
                return categoryRepository.salvarCategory(categoryAuxiliar.get());
            }
        }
        return category;
    }

    public boolean deleteCategory(Integer id){
        boolean flag=false;
        Optional<Category> categoryAuxiliar = categoryRepository.obtenerCategoryId(id);
        if(categoryAuxiliar.isPresent()){
            categoryRepository.delete(categoryAuxiliar.get());
            flag=true;
        }
        return flag;
    }        
}

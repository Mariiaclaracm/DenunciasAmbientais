package com.denunciasambientais.service;

import com.denunciasambientais.dto.CategoryDTO;
import com.denunciasambientais.entity.Category;
import com.denunciasambientais.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category create(CategoryDTO dto) {
        if (categoryRepository.findByNome(dto.nome()).isPresent()) {
            throw new IllegalArgumentException("Categoria já existe.");
        }
        return categoryRepository.save(
                Category.builder()
                        .nome(dto.nome())
                        .build()
        );
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void delete(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new EntityNotFoundException("Categoria não encontrada");
        }
        categoryRepository.deleteById(id);
    }
}

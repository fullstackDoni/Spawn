package kz.finalbitlab.spawn.service;

import kz.finalbitlab.spawn.model.Category;
import kz.finalbitlab.spawn.model.Game;
import kz.finalbitlab.spawn.repository.CategoryRepository;
import kz.finalbitlab.spawn.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getCategory(){
        return categoryRepository.findAll();
    }
}

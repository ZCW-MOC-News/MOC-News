package com.zcwnewsapp.MOCNews.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Controller
@RequestMapping(path="/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @PostMapping(path="/add")
    public @ResponseBody String addCategory(@RequestParam String category) {
        Category c = new Category();
        c.setCategory(category);
        entityManager.persist(c);
        categoryRepository.save(c);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Category> getAllCategories() {
        //     This returns a JSON or XML with the users
        return categoryRepository.findAll();
    }

    @GetMapping(path="/find")
    public @ResponseBody Optional<Category> getCategory(@RequestParam Long id) {
        //     This returns a JSON or XML with the users
        return categoryRepository.findById(id);
    }
}

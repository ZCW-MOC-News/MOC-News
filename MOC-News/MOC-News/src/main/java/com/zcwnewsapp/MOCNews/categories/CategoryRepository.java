package com.zcwnewsapp.MOCNews.categories;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository  extends CrudRepository<Category, Long> {
    Iterable<Category> findByCategory(String category);
}

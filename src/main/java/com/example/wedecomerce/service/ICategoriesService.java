package com.example.wedecomerce.service;

import com.example.wedecomerce.dto.home_page.CategoriesHomeDTO;

import java.util.List;

public interface ICategoriesService {
    List<CategoriesHomeDTO> getAll();
}

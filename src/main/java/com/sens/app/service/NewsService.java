package com.sens.app.service;

import com.sens.app.model.News;
import com.sens.app.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.List;

@Controller
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public News saveNews(News news) {
        return newsRepository.save(news);
    }

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }
}

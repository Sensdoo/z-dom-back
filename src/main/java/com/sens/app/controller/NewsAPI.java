package com.sens.app.controller;

import com.sens.app.message.response.ResponseMessage;
import com.sens.app.model.News;
import com.sens.app.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "*", maxAge = 3600)
public class NewsAPI {

    @Autowired
    private NewsService newsService;

    @PostMapping("/add")
    public ResponseEntity<?> addNews(@Valid @RequestBody News news) {
        News addedNews = newsService.saveNews(news);
        return ResponseEntity.ok(addedNews);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editNews(@Valid @RequestBody News news) {
        News editedNews = newsService.saveNews(news);
        return ResponseEntity.ok(editedNews);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNews(@PathVariable("id") Long id) {
        newsService.deleteNews(id);
        return ResponseEntity.ok(new ResponseMessage("Новость успешно удалена!"));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<News>> getAllNews() {
        return ResponseEntity.ok(newsService.getAllNews());
    }
}

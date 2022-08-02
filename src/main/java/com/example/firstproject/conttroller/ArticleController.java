package com.example.firstproject.conttroller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/article/new")
    public String newarticleform(){

        return "article/new";
    }

    @GetMapping("/article/login")
    public String loginarticleform(){
        return "article/login";
    }
    @PostMapping("/article/create")
    public String createArticle(ArticleForm form){

        System.out.println(form.toString());

        //1. Dto를 Entity로 변환
        Article article = form.toEntity();
        System.out.println(article.toString());

        //2. Repository에 Entity를 DB에 저장
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());

        return "";
    }
}

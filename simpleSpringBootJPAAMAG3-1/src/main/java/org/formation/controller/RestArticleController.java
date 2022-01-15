package org.formation.controller;

import java.util.ArrayList;
import java.util.List;


import org.formation.entity.Article;
import org.formation.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@CrossOrigin(origins = "http://localhost:4200", maxAge = 7000)
@RestController
@RequestMapping("articles")
public class RestArticleController {
	
private List<Article> articles=new ArrayList<>();
	

	public RestArticleController() {
		articles.addAll (List.of(
				new Article(1,"title1","link1",2),
				new Article(2,"title2","link2",1),
				new Article(3,"title3","link3",2),
				new Article(4,"title4","link4",0)));
	}
	
	//creation
	@PostMapping("/articles")
	Article postArticle(@RequestBody Article article) {
		articles.add(article);
		return article;
	}
	


	@Autowired
	ArticleRepository articleRepository;
	
	@GetMapping
	public  List<Article>getArticle(){
		return articleRepository.findAll();
	}

	public ArticleRepository getArticleRepository() {
		return articleRepository;
	}

	public void setArticleRepository(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	
	//recuperation
	@GetMapping("/{id}")
	public Article getArticlebYid(@PathVariable("id") long id){
		Article article=articleRepository.findById(id).get();
		return article;
	}
	
	
	
}

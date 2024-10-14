package com.koreait.BAM.dao;

import java.util.ArrayList;
import java.util.List;

import com.koreait.BAM.dto.Article;
import com.koreait.BAM.util.Util;

public class ArticleDao {
	private List<Article> articles;

	ArticleDao() {
		this.articles = new ArrayList<>();

	}

	public void writeArticle(int lastArticleId, String regDate, String regDate2, String title, String body) {
		Article article = new Article(lastArticleId, Util.getDateStr(), Util.getDateStr(), title, body);
		articles.add(article);

	}

	public Article getArticleById(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		return null;
	}

	public int getCmdNum(String cmd) {
		String[] cmdBits = cmd.split(" ");

		int id = 0;

		try {
			id = Integer.parseInt(cmdBits[2]);
		} catch (Exception e) {
			return 0;
		}
		return id;
	}

}

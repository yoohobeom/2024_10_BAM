package com.koreait.BAM.controller;

import java.util.Scanner;

import com.koreait.BAM.dto.Article;
import com.koreait.BAM.service.ArticleService;
import com.koreait.BAM.util.Util;

public class ArticleController {

	private Scanner sc;
	private int lastArticleId;
	private ArticleService articleService;

	public ArticleController(Scanner sc) {

		this.sc = sc;
		this.lastArticleId = 0;
		articleService = new ArticleService();

	}

	public void doWrite() {

		System.out.printf("제목 : ");
		String title = sc.nextLine();
		System.out.printf("내용 : ");
		String body = sc.nextLine();

		lastArticleId++;

		articleService.writeArticle(lastArticleId, Util.getDateStr(), Util.getDateStr(), title, body);

		System.out.printf("%d번 게시물이 생성되었습니다\n", lastArticleId);

	}

	public void doDelete() {
		String cmd = sc.nextLine();
		
		int id = articleService.getCmdNum(cmd);

		if (id == 0) {
			System.out.println("올바른 형식이 아닙니다");
		}

		Article foundArticle = getArticleById(id);

		if (foundArticle == null) {
			System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
		}
		
		if (id > 0) {
			articleService.deleteArticle();
		}
		articles.remove(foundArticle);

		System.out.printf("%d번 게시물이 삭제되었습니다\n", id);

	}

}

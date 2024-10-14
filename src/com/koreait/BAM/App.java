package com.koreait.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.koreait.BAM.controller.ArticleController;
import com.koreait.BAM.controller.MemberController;
import com.koreait.BAM.dto.Article;
import com.koreait.BAM.util.Util;

public class App {
	public void run() {
		System.out.println("== 프로그램 시작 ==");

		Scanner sc = new Scanner(System.in);

		MemberController memberController = new MemberController(sc);
		ArticleController articleController = new ArticleController(sc);
//		makeTestData();

		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("exit")) {
				break;
			}

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}

			if (cmd.equals("member join")) {

				memberController.doJoin();

			} else if (cmd.equals("article write")) {

				articleController.doWrite();
				
			} else if (cmd.startsWith("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시물이 존재하지 않습니다");
					continue;
				}

				List<Article> printArticles = articles;

				String searchKeyword = cmd.substring("article list".length()).trim();

				if (searchKeyword.length() > 0) {

					System.out.println("검색어 : " + searchKeyword);

					printArticles = new ArrayList<>();

					for (Article article : articles) {
						if (article.getTitle().contains(searchKeyword)) {
							printArticles.add(article);
						}
					}

					if (printArticles.size() == 0) {
						System.out.println("검색결과가 없습니다");
						continue;
					}
				}

				System.out.println("번호	|	제목	|	작성일	");
				for (int i = printArticles.size() - 1; i >= 0; i--) {
					Article article = printArticles.get(i);
					System.out.printf("%d	|	%s	|	%s	\n", article.getId(), article.getTitle(),
							article.getRegDate());
				}

			} else if (cmd.startsWith("article detail ")) {
				int id = getCmdNum(cmd);

				if (id == 0) {
					System.out.println("올바른 형식이 아닙니다");
					continue;
				}

				Article foundArticle = getArticleById(id);

				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
					continue;
				}

				System.out.printf("번호 : %d\n", foundArticle.getId());
				System.out.printf("작성일 : %s\n", foundArticle.getRegDate());
				System.out.printf("수정일 : %s\n", foundArticle.getUpdateDate());
				System.out.printf("제목 : %s\n", foundArticle.getTitle());
				System.out.printf("내용 : %s\n", foundArticle.getBody());

			} else if (cmd.startsWith("article modify ")) {
				int id = getCmdNum(cmd);

				if (id == 0) {
					System.out.println("올바른 형식이 아닙니다");
					continue;
				}

				Article foundArticle = getArticleById(id);

				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
					continue;
				}

				System.out.printf("수정할 제목 : ");
				String title = sc.nextLine();
				System.out.printf("수정할 내용 : ");
				String body = sc.nextLine();

				foundArticle.setTitle(title);
				foundArticle.setBody(body);
				foundArticle.setUpdateDate(Util.getDateStr());

				System.out.printf("%d번 게시물이 수정되었습니다\n", id);

			} else if (cmd.startsWith("article delete ")) {

				int id = getCmdNum(cmd);

				if (id == 0) {
					System.out.println("올바른 형식이 아닙니다");
					continue;
				}

				Article foundArticle = getArticleById(id);

				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다\n", id);
					continue;
				}

				articles.remove(foundArticle);

				System.out.printf("%d번 게시물이 삭제되었습니다\n", id);

			} else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
		}

		sc.close();

		System.out.println("== 프로그램 끝 ==");
	}

	private int getCmdNum(String cmd) {
		String[] cmdBits = cmd.split(" ");

		int id = 0;

		try {
			id = Integer.parseInt(cmdBits[2]);
		} catch (Exception e) {
			return 0;
		}
		return id;
	}

	private Article getArticleById(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		return null;
	}

//	private void makeTestData() {
//		System.out.println("테스트용 게시물 데이터 3개를 생성하였습니다");
//		for (int i = 1; i <= 3; i++) {
//			articles.add(new Article(++lastArticleId, Util.getDateStr(), Util.getDateStr(), "제목" + i, "내용" + i));
//		}
//	}
}
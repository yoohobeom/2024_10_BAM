package com.koreait.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");

		Scanner sc = new Scanner(System.in);

		int lastArticleId = 0;

		List<Article> articles = new ArrayList<>();

		while (true) {
			System.out.printf("명령어) ");

			String cmd = sc.nextLine();

			if (cmd.equals("article write")) {

				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();

				Article article = new Article();
				article.id = lastArticleId;
				article.title = title;
				article.body = body;

				articles.add(article);

				System.out.printf("%d 게시물이 생성되었습니다\n", lastArticleId);
				
			} else if (cmd.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시물이 존재하지 않습니다.");
				} else {
					System.out.println("번호	|	제목");
					for (int i = articles.size() - 1; i >= 0; i--) {
						Article article = articles.get(i);
						System.out.printf("%d	|	%s\n", article.id, article.title);
					}
				}
			}

			if (cmd.equals("exit")) {
				break;
			}
		}

		sc.close();

		System.out.println("== 프로그램 종료 ==");
	}
}

class Article {
	int id;
	String title;
	String body;
}
package com.koreait.BAM.service;

import com.koreait.BAM.dao.ArticleDao;

public class ArticleService {
	
	private ArticleDao articleDao;
	
	public void writeArticle(int lastArticleId, String regDate, String regDate2, String title, String body) {
		articleDao.writeArticle(lastArticleId, regDate, regDate2, title, body);
		
	}
	
	public int getCmdNum(String cmd) {
		
		return articleDao.getCmdNum(cmd);
	}
	
}

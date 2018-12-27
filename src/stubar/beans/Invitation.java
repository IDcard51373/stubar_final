package stubar.beans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Invitation {
	private int id;
	private String account;
	private String title;
	private String article;
	private String time;

	public Invitation() {
		super();
	}

	public Invitation(int id, String account, String title, String article, String time) {
		super();
		this.id = id;
		this.account = account;
		this.title = title;
		this.article = article;
		this.time = time;
	}

	@Override
	public String toString() {
		return "Invitation [id=" + id + ", account=" + account + ", title=" + title + ", article=" + article + ", time="
				+ time + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticle() {
//		String web_article=article.replace("/n","</br>");

		String web_article = "";

		if (article!=null) {
			Pattern p = Pattern.compile(" ");
			Matcher m = p.matcher(article);
			web_article = m.replaceAll("&nbsp;");
			System.out.println(web_article);
		}

		if (web_article!=null) {
			Pattern p = Pattern.compile("\n");
			Matcher m = p.matcher(web_article);
			web_article = m.replaceAll("</br>");
		}
        System.out.println(web_article);

		return web_article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}

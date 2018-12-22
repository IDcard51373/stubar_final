package cn.edu360.beans;

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
		return article;
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

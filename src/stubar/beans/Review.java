package stubar.beans;

public class Review {
	private int id;
	private int aid;
	private String observer;
	private String comment;
	private String ctime;

	public Review() {
		super();
	}

	public Review(int id, int aid, String observer, String comment, String ctime) {
		super();
		this.id = id;
		this.aid = aid;
		this.observer = observer;
		this.comment = comment;
		this.ctime = ctime;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", aid=" + aid + ", observer=" + observer + ", comment=" + comment + ", ctime="
				+ ctime + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getObserver() {
		return observer;
	}

	public void setObserver(String observer) {
		this.observer = observer;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

}

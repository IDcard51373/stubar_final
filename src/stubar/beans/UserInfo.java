package stubar.beans;

public class UserInfo {
	private int id;
	private String account;
	private String sex;
	private int age;
	private String qq;
	private String phone;
	private String description;
	private String location;

	public UserInfo() {
		super();
	}

	public UserInfo(int id, String account, String sex, int age, String qq, String phone, String description,
			String location) {
		super();
		this.id = id;
		this.account = account;
		this.sex = sex;
		this.age = age;
		this.qq = qq;
		this.phone = phone;
		this.description = description;
		this.location = location;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", account=" + account + ", sex=" + sex + ", age=" + age + ", qq=" + qq
				+ ", phone=" + phone + ", description=" + description + ", location=" + location + "]";
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}

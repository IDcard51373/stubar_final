package stubar.beans;

/**
 * 市/区Beans
 * 
 * @author Administrator
 *
 */
public class City {
	private int id;
	private int city_index;
	private int province_id;
	private String name;

	public City() {
		super();
	}

	public City(int id, int city_index, int province_id, String name) {
		super();
		this.id = id;
		this.city_index = city_index;
		this.province_id = province_id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", city_index=" + city_index + ", province_id=" + province_id + ", name=" + name
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCity_index() {
		return city_index;
	}

	public void setCity_index(int city_index) {
		this.city_index = city_index;
	}

	public int getProvince_id() {
		return province_id;
	}

	public void setProvince_id(int province_id) {
		this.province_id = province_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

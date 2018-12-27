package stubar.dao;

import stubar.beans.City;
import stubar.dbutils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CityDao {

	/**
	 * 根据传送过来的省份id查找当前省份的所有城市并返回一个城市list
	 * 
	 * @param provId
	 * @return
	 */
	public List<City> queryCityByProvId(String provId) {
		QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
		String sql = "select * from city where province_id = ?";
		try {
			return queryRunner.query(sql, new BeanListHandler<City>(City.class), provId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据id获取当前城市
	 * 
	 * @param cityId
	 * @return
	 */
	public City queryCityById(String cityId) {
		QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
		String sql = "select * from city where id = ?";
		try {
			return queryRunner.query(sql, new BeanHandler<City>(City.class), cityId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

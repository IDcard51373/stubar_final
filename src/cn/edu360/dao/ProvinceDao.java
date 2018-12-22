package cn.edu360.dao;

import cn.edu360.beans.Province;
import cn.edu360.dbutils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProvinceDao {

	/**
	 * 查询当前数据库中存储的所有省级单位，并返回一个list类型数据
	 * @return 
	 */
	public List<Province> queryAllProvince() {
		QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
		String sql = "select * from province";
		try {
			return queryRunner.query(sql, new BeanListHandler<Province>(Province.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Province queryProvinceById(String provId){
		QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
		String sql = "select * from province where id = ?";
		try {
			return queryRunner.query(sql, new BeanHandler<Province>(Province.class), provId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

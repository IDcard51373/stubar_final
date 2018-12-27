package stubar.dao;

import stubar.beans.User;
import stubar.dbutils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {

	/**
	 * 处理用户注册并将数据写入数据库的方法
	 * @param account
	 * @param pwd
	 * @param email
	 * @return
	 */
	public int register(String account, String pwd, String email) {
		QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
		String sql = "insert into user(account,password,email) values(?,?,?)";
		String sql1 = "insert into userinfo(account) values(?)";
		try {
			queryRunner.update(sql1, account);
			return queryRunner.update(sql, account,pwd,email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 处理用户登录并且连接数据库的方法
	 * @param account
	 * @param password
	 * @return 
	 */
	public User login(String account, String password) {
		QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
		String sql = "select * from user where account = ?";
		try {
			List<User> query = queryRunner.query(sql,new BeanListHandler<User>(User.class),account);
			User user = query.get(0);
			if(null != user){
				String currentpwd = user.getPassword();
				if (password.equals(currentpwd)){
					return user;
				} else {
					return null;
				}
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

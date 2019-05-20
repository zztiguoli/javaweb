package cn.edu.zzti.dao.impl.mysql;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.edu.zzti.dao.PersonalDAO;
import cn.edu.zzti.entity.PersonalInfoDO;
import cn.edu.zzti.util.tomcat.DBUtil;

public class PersonalDAOImpl implements PersonalDAO{

	@Override
	public PersonalInfoDO getPersonalInfo(String username) throws SQLException {
		QueryRunner queryrunner = new QueryRunner(DBUtil.getDataSource());
		String sql="select * from personalInfo where username = ?";
		PersonalInfoDO p = queryrunner.query(sql, new BeanHandler<PersonalInfoDO>(PersonalInfoDO.class), username);
		return p;
	}

	@Override
	public void setPersonalInfo(String username, PersonalInfoDO p) throws SQLException {
		QueryRunner queryrunner = new QueryRunner(DBUtil.getDataSource());
		String sql="insert into personalInfo values(?,?,?,?,?,?,?,?,?,?)";
		Object[] params = new Object[]{
				username,
				p.getAge(),
				p.getGender(),
				p.getAddress(),
				p.getTel(),
				p.getEmail(),
				p.getGraduateSchool(),
				p.getHighestEducation(),
				p.getMajor(),
				p.getRealName()
		};
		queryrunner.update(sql, params);
		
	}

}

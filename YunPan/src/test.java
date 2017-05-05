import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.YunPan.dao.User;
import com.YunPan.dao.UsersDao;
import com.YunPan.dao.Impl.UserDaoImpl;
import com.YunPan.util.db.DBUtils;


public class test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		User user = new User("root","root");
		UsersDao uDao = new UserDaoImpl();
		
		if(uDao.findAll(user.getUsername(), user.getPassword()))
		{
			System.out.println("Yes");
		}
		else System.out.println("No");
	}

}

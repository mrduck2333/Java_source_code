package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import utils.JDBCUtils;

public class UserDao {
	public User FindById(int id){
		Connection  c=null;
		try{
			c=JDBCUtils.getConnection();
			String sql="select * from user  where id=?";
			PreparedStatement pst=c.prepareStatement(sql);
			pst.setInt(1,id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				User user=new User();
				user.setId(rs.getInt("id"));
		        user.setUsername(rs.getString("username"));
		        user.setPassword(rs.getString("password"));
				return user;
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public List<User> listUser(int pageNo){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<User> list=new ArrayList<User>();
		int pageSize=5;
		int page=(pageNo-1)*5;
		
		Connection c=null;
	
		String sql="select * from user order by id limit ?,?";
		try {
			 c=JDBCUtils.getConnection();
			pstmt=c.prepareStatement(sql);
			pstmt.setInt(1, page);
			pstmt.setInt(2, pageSize);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				User user=new User();
				user.setId(rs.getInt("id"));
		        user.setUsername(rs.getString("username"));
		        user.setPassword(rs.getString("password"));
		        list.add(user);
			}
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}finally{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			return list;
		}
		
	
	public int getPage(){
		int recordCount=0,t1=0,t2=0;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		Connection c=null; 
		String sql="select count(*) from user";
		try {
			c=JDBCUtils.getConnection();
			pstmt=c.prepareStatement(sql);
			result=pstmt.executeQuery();
			result.next();
			recordCount=result.getInt(1);
			t1=recordCount%5;
			t2=recordCount/5;
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}finally{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(t1 != 0){
			t2=t2+1;
		}
			return t2;
		}
	
	public boolean delete( int id) {
		Connection c=null;
		try{
			 c=JDBCUtils.getConnection();
			String sql="delete from user where id=?";
			PreparedStatement pst=c.prepareStatement(sql);
			pst.setInt(1,id);
			pst.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public boolean update(User user,int id) {
	 	Connection c=null;
	 	try{
	 		c=JDBCUtils.getConnection();
			String sql="update user set username=?,password=? where id=?";
			PreparedStatement pst=c.prepareStatement(sql);
			pst.setString(1,user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setInt(3,id);
			pst.execute();
			return true;
	 	}catch(Exception e){
	 		e.printStackTrace();
	 		return false;
	 	}finally{
	 		try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	}
	}


	public List<User> queryAll(){
		Connection c=null;   
		List<User> list =new ArrayList<User>();
		try{
			c=JDBCUtils.getConnection();
			String sql="select * from user";
			PreparedStatement pst=c.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				User user =new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				list.add(user);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
			
		}finally{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public boolean registe(User user){
		Connection c=null ;      ;
		try{
			c=JDBCUtils.getConnection();
			String sql="insert into user(username,password) values (?,?)";
			PreparedStatement pst=c.prepareStatement(sql);
			pst.setString(1,user.getUsername());
			pst.setString (2,user.getPassword());
			pst.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public User findUser(String username){
		Connection c=null;
		try{
			c=JDBCUtils.getConnection();
			String sql="select * from user where username=?";
			PreparedStatement pst=c.prepareStatement(sql);
			pst.setString(1, username);
			ResultSet rs=pst.executeQuery();
			if(rs.next()==false){
				return null;
			}else{
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

  
    public static void main(String[] args) {
   
    
		
	}


}

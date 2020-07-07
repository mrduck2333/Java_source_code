package dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.Express;
import utils.JDBCUtils;


public class ExpressDao {
	Connection c=null;
	//根据id查询
	public Express queryById(int id){
		
		try{
			c=JDBCUtils.getConnection();
			String sql="select * from express  where id=?";
			PreparedStatement pst=c.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				Express record =new Express();
				record.setId(rs.getInt("id"));
				record.setEno(rs.getString("eno"));
				record.setCarno(rs.getString("carno"));
				record.setGoods(rs.getString("goods"));
				record.setPrice(rs.getDouble("price"));
				record.setIsStartLocation(rs.getString("isStartLocation"));
				record.setIsEndLocation(rs.getString("isEndLocation"));
				record.setCreateTime(rs.getDate("createTime"));
				record.setExpresser(rs.getString("expresser"));
				return record;
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
	
	//全局查询物流信息
	public List<Express> findAll(){
		List<Express> list =new ArrayList<Express>();
		try{
			c=JDBCUtils.getConnection();
			String sql="select * from express order by id asc";
			PreparedStatement pst=c.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				
				Express record =new Express();
				record.setId(rs.getInt("id"));
				record.setEno(rs.getString("expressno"));
				record.setCarno(rs.getString("carno"));
				record.setGoods(rs.getString("goods"));
				record.setPrice(rs.getDouble("price"));
				record.setIsStartLocation(rs.getString("isStartLocation"));
				record.setIsEndLocation(rs.getString("isEndLocation"));
				
				record.setCreateTime(rs.getDate("createTime"));
				record.setExpresser(rs.getString("expresser"));
				list.add(record);
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
	
	//添加快递信息
	public boolean insert(Express express){
		Connection c=null;
		try{
			c=JDBCUtils.getConnection();
			String sql="insert into express(eno,carno,goods,price,isStartLocation,isEndLocation,createTime,expresser) values (?,?,?,?,?,?,?,?)";
			PreparedStatement pst=c.prepareStatement(sql);
			pst.setString(1,express.getEno());
			pst.setString(2, express.getCarno());
			pst.setString(3, express.getGoods());
			pst.setDouble(4, express.getPrice());
			pst.setString(5, express.getIsStartLocation());
			pst.setString(6, express.getIsEndLocation());
			
			pst.setString(7, String.valueOf(express.getCreateTime()));
			pst.setString(8, express.getExpresser());
			
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
	
	//根据id删除
	public boolean deleteExpress( int id) {
		Connection c=null;
		try{
			c=JDBCUtils.getConnection();
			String sql="delete from express where id=?";
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

	
	//模糊查询，根据物流车辆名称查询
	public List<Express> findByEno(String eno){	
		Connection c=null; 
		List<Express> list =new ArrayList<Express>();
		try{
			c=JDBCUtils.getConnection();
			String sql="select * from express where  eno like ?";
			PreparedStatement pst=c.prepareStatement(sql);
			pst.setString(1, "%"+eno+"%");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Express record =new Express();
				record.setId(rs.getInt("id"));
				record.setEno(rs.getString("eno"));
				record.setCarno(rs.getString("carno"));
				record.setGoods(rs.getString("goods"));
				record.setPrice(rs.getDouble("price"));
				record.setIsStartLocation(rs.getString("isStartLocation"));
				record.setIsEndLocation(rs.getString("isEndLocation"));
				record.setCreateTime(rs.getDate("createTime"));
				record.setExpresser(rs.getString("expresser"));
				list.add(record);
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
	
//全局查询并分页
	public List<Express> ListExpress(int pageNo){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Express> list=new ArrayList<Express>();
		int pageSize=5;
		int page=(pageNo-1)*5;
		
		Connection c=null;
	
		
		try {
			c=JDBCUtils.getConnection();
			String sql="select * from express order by id limit ?,?";
			pstmt=c.prepareStatement(sql);
			pstmt.setInt(1, page);
			pstmt.setInt(2, pageSize);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Express record =new Express();
				record.setId(rs.getInt("id"));
				record.setEno(rs.getString("eno"));
				record.setCarno(rs.getString("carno"));
				record.setGoods(rs.getString("goods"));
				record.setPrice(rs.getDouble("price"));
				record.setIsStartLocation(rs.getString("isStartLocation"));
				record.setIsEndLocation(rs.getString("isEndLocation"));
				record.setCreateTime(rs.getDate("createTime"));
				record.setExpresser(rs.getString("expresser"));
		            list.add(record);
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
	
	//统计
	public int getCount() {
		int count =0;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		Connection c=null; 
		String sql="select count(*) from express";
		try {
			c=JDBCUtils.getConnection();
			pstmt=c.prepareStatement(sql);
			result=pstmt.executeQuery();
			result.next();
			count=result.getInt(1);
			
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
		return count;
		}
	
		
	//获取页码及记录数
	public int getPage(){
		int recordCount=0,t1=0,t2=0;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		Connection c=null; 
		
		String sql="select count(*) from express";
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


	//编辑快递信息
	public boolean update(Express express,int id) {
	 	Connection c=null;
	 	try{
	 		c=JDBCUtils.getConnection();
			String sql="update express set eno=?,carno=?,goods=?,price=?,isStartLocation=?,isEndLocation=?,createTime=?,expresser=? where id=?";
			PreparedStatement pst=c.prepareStatement(sql);
			
			pst.setString(1,express.getEno());
			pst.setString(2, express.getCarno());
			pst.setString(3, express.getGoods());
			pst.setDouble(4, express.getPrice());
			pst.setString(5, express.getIsStartLocation());
			pst.setString(6, express.getIsEndLocation());
			
			pst.setString(7, String.valueOf(express.getCreateTime()));
			pst.setString(8, express.getExpresser());
			pst.setInt(9, id);
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
	
	public static void main(String[] args) {
		ExpressDao dao=new ExpressDao();
		int count=dao.getCount();
		System.out.print(count);
		/*List<Express> list=dao.findByEno("红");
		for(Express express:list) {
			System.out.println( "ename:" +express.getEno() + ":comm" +express.getExpresser());  
		}	*/
	
	}
}

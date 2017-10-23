package ch3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class BoardDetailDAO {

	

	public BoardVO boardDetail(String b_no){
		
		BoardVO bVo = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pwd = "tiger";
		
		String sql = "select b_no, b_title, b_writer, b_contents"
				+ ", reg_date from board"
				+ " where b_no=?";
		Connection conn = null;
		PreparedStatement psmt = null;
	    ResultSet rs = null;	
	    
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pwd);
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, b_no);
			
		    rs = psmt.executeQuery();
		    
			while(rs.next()){
			
				bVo = new BoardVO();
				bVo.setB_no(rs.getString("b_no"));
				bVo.setB_title(rs.getString("b_title"));
				bVo.setB_writer(rs.getString("b_writer"));
				bVo.setB_contents(rs.getString("b_contents"));
				bVo.setReg_date(rs.getString("reg_date"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		   try {
				rs.close();
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return bVo;
	}//close select



}

package ch3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class BoardListDAO {


	public ArrayList<BoardVO> select(){
		
		ArrayList<BoardVO> blist = new ArrayList<BoardVO>();
		BoardVO bVo = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pwd = "tiger";
		
		String sql = "select b_no, b_title, b_writer, b_contents"
				+ ", reg_date from board"
				+ " order by b_no";
		Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;	
	    
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pwd);
			stmt = conn.createStatement();
		    rs = stmt.executeQuery(sql);
			while(rs.next()){
				//HashMap<String,String> map	= new HashMap<String, String>();
				bVo = new BoardVO();
				bVo.setB_no(rs.getString("b_no"));
				bVo.setB_title(rs.getString("b_title"));
				bVo.setB_writer(rs.getString("b_writer"));
				bVo.setB_contents(rs.getString("b_contents"));
				bVo.setReg_date(rs.getString("reg_date"));
				blist.add(bVo);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		   try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//System.out.print(blist);
		return blist;
	}//close select



}

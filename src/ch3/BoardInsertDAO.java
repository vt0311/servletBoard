package ch3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class BoardInsertDAO {

	//HashMap<String, String> map;
	
	/*public BoardInsertDAO() {
		// TODO Auto-generated constructor stub
		//map = inMap;
		
	}*/


	public int insert(HashMap<String, String> map) {
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "scott";
		String pwd = "tiger";
		
		String sql = "insert into board (b_no, b_title, b_writer, b_contents, reg_date)"
				+ "values("
				+ "board_no_seq.nextval, ?, ?, ?, sysdate)";
		int scnt = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    conn = DriverManager.getConnection(url, id, pwd);
				
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, map.get("title"));
			psmt.setString(2, map.get("writer"));
			psmt.setString(3, map.get("contents"));
			scnt = psmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return scnt;
	}//close insert

	public ArrayList<HashMap> select(){
		ArrayList<HashMap> blist = new ArrayList<HashMap>();
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "scott";
		String pwd = "tiger";
		
		String sql = "select b_no, b_title, b_writer, b_contents"
				+ ", reg_date from board"
				+ " order by no";
		try {
			Connection conn = DriverManager.getConnection(url, id, pwd);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				HashMap<String,String> map	= new HashMap<String, String>();
				map.put("b_no", rs.getString("b_no"));
				map.put("b_title", rs.getString("b_title"));
				map.put("b_writer", rs.getString("b_writer"));
				map.put("b_contents", rs.getString("b_contents"));
				map.put("reg_date", rs.getString("reg_date"));
//				map.put("clickcnt", rs.getString("clickcnt"));
				blist.add(map);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.print(blist);
		return blist;
	}//close select



}

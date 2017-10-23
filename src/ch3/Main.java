package ch3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		/*String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
	    Statement stmt = null;
	    String sql = "select b_no, b_title, b_writer, b_contents, reg_date from board";
		ResultSet rs = null;	
		
		ArrayList<BoardVO> blist = new ArrayList<BoardVO>();
		
		BoardVO bVo = null;
	    
		try {
		    
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		    conn = DriverManager.getConnection(url, "scott", "tiger");
		    		
		    stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				bVo = new BoardVO();
				bVo.setB_no(rs.getString("b_no"));
				bVo.setB_title(rs.getString("b_title"));
				bVo.setB_writer(rs.getString("b_writer"));
				bVo.setB_contents(rs.getString("b_contents"));
				bVo.setReg_date(rs.getString("reg_date"));
				blist.add(bVo);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
	
			e.printStackTrace();
		}*/
		
		//HttpSession session = request.getSession();
		//session.setAttribute("boardlist", blist);
	
		BoardListDAO dao = new BoardListDAO();
		
		ArrayList<BoardVO> blist = null;
		
		blist =	dao.select();
		
		HttpSession session = request.getSession();
		session.setAttribute("boardlist", blist);
		
		response.sendRedirect("./boardList.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

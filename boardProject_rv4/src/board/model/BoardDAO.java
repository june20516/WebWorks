package board.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class BoardDAO {
	
	private static Connection connection;
	private PreparedStatement pstmt;
	private ResultSet resultSet;
	//private List<DTO> dto = new ArrayList<DTO>();
	
	static public Connection getConn() {
		return connection;
	}
	
	static public final BoardDAO instance;
	
	static {
		instance = new BoardDAO();
	}
	
	public BoardDAO() {
		connection();
	}
	
	public void connection() {
		try {
	         Class.forName("com.mysql.jdbc.Driver");
//	         connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "1234");
	         connection = DriverManager.getConnection("jdbc:mysql://192.168.0.12:3306/twotwo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "hs", "123456");
	         System.out.println("Connection Completed");
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.out.println("Connected Failed");
	      }
	      System.out.println("DB Connected");
	   }
	
	public void write(String id,String title,String content) {
		System.out.println("Wrtie Start");
		int number = 0;
		String sql2 = "select max(bGroup) from board";
		try {
			resultSet=pstmt.executeQuery(sql2);
			if(!(resultSet.next())) {
				number=1;
			}else {
				number= resultSet.getInt(1)+1;
				resultSet.close();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "insert into board ( id, title, content,bGroup, bStep, bIndent) values (?,?,?,"+number+",0,0)";
		try {
			pstmt = connection.prepareStatement(sql);
			//pstmt.setInt(1, num);
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
			System.out.println("Write Insert Success !");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
         
	}

	
	public List<BoardDTO>  getDTOAll(String ...strs){
		List<BoardDTO>  dtos=null;
		//String sql ="select name,title,content,writeday from member,board";
		//String sql = "select * from member,board where member.id = board.id order by num desc";
		try {
			String sql ="";
			if(strs.length==2) {
				
				sql ="select * from board  where  "+strs[0]+" like ?"; 
				pstmt = connection.prepareStatement(sql);
				System.out.println(sql);
				pstmt.setString(1,"%"+strs[1]+"%");
				
			}else {
				sql ="select * from board order by bGroup desc, bStep asc"; 
				pstmt = connection.prepareStatement(sql);
			}
			
//			String sql ="select * from board"; 
			
		//	 sql = "select * from board order by num desc limit 10";
			//pstmt = connection.prepareStatement(sql);
			
			resultSet = pstmt.executeQuery();
			dtos = new ArrayList<BoardDTO>();
			while(resultSet.next()) {
				dtos.add( 
						new BoardDTO(
								resultSet.getInt("num"),
								resultSet.getString("id"), 
								resultSet.getString("title"),  
								resultSet.getString("content"),
								resultSet.getString("writeday")
								)
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} 
		
		return dtos;
	}
	
	
	public BoardDTO getView(int  num) {
		String sql = "select * from board where num = ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, num);
			resultSet = pstmt.executeQuery();
			if(resultSet.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(resultSet.getInt("num"));
				dto.setId(resultSet.getString("id"));
				dto.setTitle(resultSet.getString("title"));
				dto.setContent(resultSet.getString("content"));
				dto.setWriteday(resultSet.getString("writeday"));
				dto.setbGroup(resultSet.getInt("bGroup"));
				return dto;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return null;
	}
	
	/* 글수정 */
	public void update(String title, String content, int  num) {
		String sql = "update board set title=?, content=? where num=?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
	}
	 
	/* 글삭제 */
	public void delete(int  num) {
			
		String sql = "delete from board where num=?";

	      try {
	         pstmt = connection.prepareStatement(sql);
	         System.out.println(num);
	         pstmt.setInt(1, num);
	         pstmt.executeUpdate();

	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }

	   }
	
	/* 이전글 */
	public BoardDTO prev(int  num) {
		String sql = "select num, title from board where num=(select max(num) from board where num < ?)";

		BoardDTO dto = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, num);

			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				dto = new BoardDTO(resultSet.getInt("num"),resultSet.getString("title"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;

	}
	
	/* 다음글 */
	public BoardDTO next(int  num) {
		String sql = "select num, title from board where num=(select min(num) from board where num > ?)";

		BoardDTO dto = null;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, num);

			resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				dto = new BoardDTO(resultSet.getInt("num"),resultSet.getString("title"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dto;

	}
	
	/* 검색 
	public List<DTO> search(String opt, String keyword){
		List<DTO> list =null;
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/
	
	
	//답글
	public BoardDTO reply_view(int str) {
		// TODO Auto-generated method stub
		BoardDTO dto = null;

		try {
			connection();
			System.out.println("--reply_view connection");
			//String sql = "select id, num, name, title, content, bStep, bIndent from board where num = ?";
			String sql = "select * from board where num = ?";
			System.out.println("리플 시작!");
			pstmt = connection.prepareStatement(sql);
			//pstmt.setInt(1, Integer.parseInt(str));
			pstmt.setInt(1, str);
			resultSet = pstmt.executeQuery();
			
			if(resultSet.next()) {
				int  num = resultSet.getInt("num");
				String id = resultSet.getString("id");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
//				Timestamp bDate = resultSet.getTimestamp("bDate");
//				int bHit = resultSet.getInt("bHit");
				String writeday = resultSet.getString("writeday");

				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				
				dto = new BoardDTO(num, id, title, content, writeday, bGroup,bStep, bIndent);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("!!!!!!!reply_view error!!!!!!!");
			e.printStackTrace();
		} 
		
		return dto;
	}
	
	public void reply(int  num, String id, String title, String content,String bGroup, String bStep, String bIndent) {
		// TODO Auto-generated method stub
		
		replyShape(bGroup, bStep);
		
		
		try {
			connection();
			System.out.println("--reply connection");
			
			//insert into board (num, id, title, content,bGroup, bStep, bIndent) values (?,?,?,?,0,0,0)"
			String sql = "insert into board (num, id, title, content, bGroup, bStep, bIndent) values ( null, ?, ?,?, ?, ?,?)";
			pstmt = connection.prepareStatement(sql);
			
			//pstmt.setInt(1, num);
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setInt(4, Integer.parseInt(bGroup));
			pstmt.setInt(5, Integer.parseInt(bStep) + 1);
			pstmt.setInt(6, Integer.parseInt(bIndent) + 1);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("!!!!!!!reply error!!!!!!!");
			e.printStackTrace();
		} 
	}
	

	private void replyShape(String strGroup, String strStep) {
		// TODO Auto-generated method stub
		try {
			connection();
			System.out.println("--replyShape connection");
			String sql = "update board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(strGroup));
			pstmt.setInt(2, Integer.parseInt(strStep));

			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("!!!!!!!replyShape error!!!!!!!");
			e.printStackTrace();
		} 

	}

	public List<CommentDTO> 댓글가져옴(int num) {
		List<CommentDTO> dtoList = null;
		try {
			System.out.println(num+"댓글가져옴");
			
			String sql = "select num,id,cContent from comment where boardNo = ?";
			
			System.out.println("리플 시작!");
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			resultSet = pstmt.executeQuery();
			dtoList = new ArrayList<CommentDTO>();
			while(resultSet.next()) {
				CommentDTO dto= new CommentDTO(num,
						resultSet.getString("id")
						, resultSet.getString("cContent"));
			
				dtoList.add(dto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("!!!!!!!reply_view error!!!!!!!");
			e.printStackTrace();
		} 
		
		return dtoList;
	}

	public List<BoardDTO> getDTOAll(int i, int contentnum) {
		// TODO Auto-generated method stub
		return null;
	}

	public int testcount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
		
}






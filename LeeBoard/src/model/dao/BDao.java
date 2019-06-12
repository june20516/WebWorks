package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.dto.BDto;

public class BDao {
	
	private PreparedStatement pStmt;
	private ResultSet result;
	private Connection conn;
	private static BDao instance = new BDao();

	private BDao() {
		conn = DaoConnection.getConnection();
	}

	

	public static BDao getInstance() {
		return instance;
	}

	public void write(String bName, String bTitle, String bContent) {
		try {
			String sql = "insert into board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (boardSeq.nextval, ?, ?, ?, 0, boardSeq.currval, 0, 0 )";
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, bName);
			pStmt.setString(2, bTitle);
			pStmt.setString(3, bContent);
			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<BDto> list() {
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		try { 
			String sql = "select * from board order by bGroup desc, bIndent asc";
			pStmt = conn.prepareStatement(sql);
			result = pStmt.executeQuery();

			while (result.next()) {
				int bId = result.getInt("bId");
				String bName = result.getString("bName");
				String bTitle = result.getString("bTitle");
				String bContent = result.getString("bContent");
				Timestamp bDate = result.getTimestamp("bDate");
				int bHit = result.getInt("bHit");
				int bGroup = result.getInt("bGroup");
				int bStep = result.getInt("bStep");
				int bIndent = result.getInt("bIndent");

				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}
	
	public ArrayList<BDto> list(int count, int page) {
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		try { 
			String sql = "SELECT * FROM (SELECT ROWNUM AS RNUM, T.*  FROM"+
					" (SELECT * FROM kwon.board order by bGroup desc, bIndent asc) T)" + 
					" WHERE RNUM BETWEEN ? AND  ?" + 
					" ORDER BY RNUM ASC";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, (page-1)*count+1);
			pStmt.setInt(2, count*page);
			result = pStmt.executeQuery();
			while (result.next()) {
				int bId = result.getInt("bId");
				String bName = result.getString("bName");
				String bTitle = result.getString("bTitle");
				String bContent = result.getString("bContent");
				Timestamp bDate = result.getTimestamp("bDate");
				int bHit = result.getInt("bHit");
				int bGroup = result.getInt("bGroup");
				int bStep = result.getInt("bStep");
				int bIndent = result.getInt("bIndent");

				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public BDto contentView(String strID) {
		upHit(strID);
		BDto dto = null;
		try {
			String sql = "select * from board where bId = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, Integer.parseInt(strID));
			result = pStmt.executeQuery();

			if (result.next()) {
				int bId = result.getInt("bId");
				String bName = result.getString("bName");
				String bTitle = result.getString("bTitle");
				String bContent = result.getString("bContent");
				Timestamp bDate = result.getTimestamp("bDate");
				int bHit = result.getInt("bHit");
				int bGroup = result.getInt("bGroup");
				int bStep = result.getInt("bStep");
				int bIndent = result.getInt("bIndent");

				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public void modify(String bId, String bName, String bTitle, String bContent) {
		try {
			String sql = "update board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, bName);
			pStmt.setString(2, bTitle);
			pStmt.setString(3, bContent);
			pStmt.setInt(4, Integer.parseInt(bId));
			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String bId) {
		try {
			String sql = "delete from board where bId = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, Integer.parseInt(bId));
			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public BDto replyView(String str) {
		BDto dto = null;
		try {
			String sql = "select * from board where bId = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, Integer.parseInt(str));
			result = pStmt.executeQuery();

			if (result.next()) {
				int bId = result.getInt("bId");
				String bName = result.getString("bName");
				String bTitle = result.getString("bTitle");
				String bContent = result.getString("bContent");
				Timestamp bDate = result.getTimestamp("bDate");
				int bHit = result.getInt("bHit");
				int bGroup = result.getInt("bGroup");
				int bStep = result.getInt("bStep");
				int bIndent = result.getInt("bIndent");

				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public void reply(String bName, String bTitle, String bContent, String bGroup, String bStep,
			String bIndent) {
		replyShape(bGroup, bStep);
		try {
			String sql = "insert into board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (boardSeq.nextval, ?, ?, ?, ?, ?, ?)";
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, bName);
			pStmt.setString(2, bTitle);
			pStmt.setString(3, bContent);
			pStmt.setInt(4, Integer.parseInt(bGroup));
			pStmt.setInt(5, Integer.parseInt(bStep) + 1);
			pStmt.setInt(6, Integer.parseInt(bIndent) + 1);
			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private void replyShape(String strGroup, String strStep) {
	      try {
	         String sql = "update board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
	         pStmt = conn.prepareStatement(sql);
	         pStmt.setInt(1, Integer.parseInt(strGroup));
	         pStmt.setInt(2, Integer.parseInt(strStep));
	         pStmt.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }

	private void upHit(String bId) {
		try {
			String sql = "update board set bHit = bHit + 1 where bId = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, bId);
			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public int totalCount() {
		String sql = "SELECT COUNT(BID) FROM kwon.board";
		try {
			pStmt = conn.prepareStatement(sql);
			result = pStmt.executeQuery();
			result.next();
			return result.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public List<BDto>  searchBoard(String ...strs){
		List<BDto> dtos=null;
		try {
			String sql ="";
			if(strs.length==2) {
				sql ="select * from board  where  "+strs[0]+" like ?"; 
				pStmt = conn.prepareStatement(sql);
				pStmt.setString(1,"%"+strs[1]+"%");
			}else {
				sql ="select * from board"; 
				pStmt = conn.prepareStatement(sql);
			}
			result = pStmt.executeQuery();
			dtos = new ArrayList<BDto>();
			while(result.next()) {
				int bId = result.getInt("bId");
				String bName = result.getString("bName");
				String bTitle = result.getString("bTitle");
				String bContent = result.getString("bContent");
				Timestamp bDate = result.getTimestamp("bDate");
				int bHit = result.getInt("bHit");
				int bGroup = result.getInt("bGroup");
				int bStep = result.getInt("bStep");
				int bIndent = result.getInt("bIndent");

				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}
	
}

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
import model.dto.CDto;

public class CDao {
	
	private PreparedStatement pStmt;
	private ResultSet result;
	private Connection conn;
	private static CDao instance = new CDao();

	private CDao() {
		conn = DaoConnection.getConnection();
	}

	

	public static CDao getInstance() {
		return instance;
	}

	public void writeComment(String cName, String cTitle, String cContent, int cSuperId) {
		try {
			String sql = "insert into comment (cId, cName, cContent, cSuperId, cGroup, cStep, cIndent) values (CMTSEQ.nextval, ?, ?, ?, CMTSEQ.currval, 0, 0 )";
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, cName);
			pStmt.setString(2, cContent);
			pStmt.setInt(3, cSuperId);
			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<CDto> commentsList(int cSuperId) {
		ArrayList<CDto> cDtoList = new ArrayList<CDto>();
		try { 
			String sql = "select * from comments where cSuperId= ? order by cGroup desc, cIndent asc";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, cSuperId);
			result = pStmt.executeQuery();

			while (result.next()) {
				int cId = result.getInt("cId");
				String cName = result.getString("cName");
				String cContent = result.getString("cContent");
				Timestamp cDate = result.getTimestamp("cDate");
				int cGroup = result.getInt("cGroup");
				int cStep = result.getInt("cStep");
				int cIndent = result.getInt("cIndent");

				CDto dto = new CDto(cId, cName, cContent, cDate, cSuperId, cGroup, cStep, cIndent);
				cDtoList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cDtoList;
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

	public void modify(String cId, String cName, String cContent) {
		try {
			String sql = "update comments set cName = ?, cContent = ? where cId = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, cName);
			pStmt.setString(3, cContent);
			pStmt.setInt(4, Integer.parseInt(cId));
			pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String cId) {
		try {
			String sql = "delete from comments where cId = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, Integer.parseInt(cId));
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

	public void replyComments(String cName, String cContent, String cSuperId, String cGroup, String cStep,
			String cIndent) {
		replyShape(cGroup, cStep);
		try {
			String sql = "insert into comment (cId, cName, cContent, cSuperId, cGroup, cStep, cIndent) values (cmtseq.nextval, ?, ?, ?, ?, ?, ?)";
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, cName);
			pStmt.setString(2, cContent);
			pStmt.setString(3, cSuperId);
			pStmt.setInt(4, Integer.parseInt(cGroup));
			pStmt.setInt(5, Integer.parseInt(cStep) + 1);
			pStmt.setInt(6, Integer.parseInt(cIndent) + 1);
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
	         String sql = "update comments set cStep = cStep + 1 where cGroup = ? and cStep > ?";
	         pStmt = conn.prepareStatement(sql);
	         pStmt.setInt(1, Integer.parseInt(strGroup));
	         pStmt.setInt(2, Integer.parseInt(strStep));
	         pStmt.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	
	public int totalCount() {
		String sql = "SELECT COUNT(cID) FROM comments";
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
	
}

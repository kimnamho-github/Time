package com.admin.date.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;
import com.admin.AdminSupport;
import com.admin.board.model.vo.Board;
import com.admin.board.model.vo.BoardType;
import com.admin.board.model.vo.Recipe;
import com.admin.board.model.vo.RecipeIngrd;
import com.admin.date.model.vo.Dose;
import com.admin.date.model.vo.Ingrd;
import com.common.JDBCTemplate;
import com.common.model.vo.Attachment;
import com.common.model.vo.PageInfo;

public class DateDao {
	private Properties prop = new Properties();

	public DateDao() {
		String filePath = DateDao.class.getResource(new AdminSupport().toXmlUrl("date")).getPath();
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int countIngrd(Connection conn,String search) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String sql = prop.getProperty("countIngrd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,search==null?"":search);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				result = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Ingrd> selectIngrdList(Connection conn, PageInfo pageInfo, String search) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Ingrd> list = new ArrayList<Ingrd>();
		String sql = prop.getProperty("selectIngrdList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,search==null?"":search);
			pstmt.setInt(2, pageInfo.startBoard());
			pstmt.setInt(3, pageInfo.endBoard());
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Ingrd ingrd = new Ingrd(
						rset.getString("INGRD_CODE")
						,rset.getString("INGRD_NAME"));
				list.add(ingrd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int deleteIngrd(Connection conn, String[] ino, HashMap<String, String> map) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deledeIngrd");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < ino.length; i++) {
				if (!map.containsKey(ino[i])) {
					pstmt.setString(1, ino[i]);
					result += pstmt.executeUpdate();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public HashMap<String ,String> selectIngrd(Connection conn, String[] ino) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String, String> map = new HashMap<>();
		String sql = prop.getProperty("selectIngrd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < ino.length; i++) {
				pstmt.setString(1,ino[i]);
				rset = pstmt.executeQuery();
				if (rset.next()) {
					map.put(rset.getString("INGRD_CODE"), rset.getString("INGRD_NAME"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return map;
	}

	public int checkIngrd(Connection conn, String iname) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String sql = prop.getProperty("checkIngrd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,iname);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int inertIngrd(Connection conn, String iname) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("inertIngrd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,iname);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int countDose(Connection conn, String search) {
		// TODO Auto-generated method stub	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String sql = prop.getProperty("countDose");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,search==null?"":search);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				result = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Dose> selectDoseList(Connection conn, PageInfo pageInfo, String search) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Dose> list = new ArrayList<Dose>();
		String sql = prop.getProperty("selectDoseList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,search==null?"":search);
			pstmt.setInt(2, pageInfo.startBoard());
			pstmt.setInt(3, pageInfo.endBoard());
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Dose dose = new Dose(
						rset.getString("DOSE_CODE")
						,rset.getString("DOSE_NAME"));
				list.add(dose);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int checkDose(Connection conn, String dname) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String sql = prop.getProperty("checkDose");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dname);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int inertDose(Connection conn, String dname) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("inertDose");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dname);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public HashMap<String, String> selectDose(Connection conn, String[] dno) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String, String> map = new HashMap<>();
		String sql = prop.getProperty("selectDose");
		
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < dno.length; i++) {
				pstmt.setString(1,dno[i]);
				rset = pstmt.executeQuery();
				if (rset.next()) {
					map.put(rset.getString("DOSE_CODE"), rset.getString("DOSE_NAME"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return map;
	}

	public int deleteDose(Connection conn, String[] dno, HashMap<String, String> map) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteDose");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < dno.length; i++) {
				if (!map.containsKey(dno[i])) {
					pstmt.setString(1, dno[i]);
					result += pstmt.executeUpdate();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	

	
}


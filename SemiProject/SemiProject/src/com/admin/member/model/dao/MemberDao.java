package com.admin.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import com.admin.AdminSupport;
import com.admin.member.model.vo.AdminMember;
import com.admin.member.model.vo.MemberGrade;
import com.common.JDBCTemplate;
import com.common.model.vo.PageInfo;

public class MemberDao {
	private Properties prop = new Properties();

	public MemberDao() {
		String filePath = MemberDao.class.getResource(new AdminSupport().toXmlUrl("member")).getPath();
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public int countMember(Connection conn, String search, String mg) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String sql = prop.getProperty("countMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,search);
			pstmt.setString(2,mg);
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

	public ArrayList<AdminMember> selectMemberList(Connection conn, PageInfo pageInfo, String search, String mg) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AdminMember> list = new ArrayList<AdminMember>();
		String sql = prop.getProperty("selectMemberList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,search);
			pstmt.setString(2,mg);
			pstmt.setInt(3, pageInfo.startBoard());
			pstmt.setInt(4, pageInfo.endBoard());
			rset = pstmt.executeQuery();
			while (rset.next()) {
				AdminMember m = new AdminMember();
				m.setMemberNo(rset.getInt("MEMBER_NO"));
				m.setMemberId(rset.getString("MEMBER_ID"));
				m.setMemberName(rset.getString("MEMBER_NAME"));
				m.setEmail(rset.getString("EMAIL"));
				if (m.getEmail()==null) {
					m.setEmail("-");
				}
				m.setAddress(rset.getString("ADDRESS"));
				if (m.getAddress()==null) {
					m.setAddress("-");
				}
				m.setPhone(rset.getString("PHONE"));
				if (m.getPhone()==null) {
					m.setPhone("-");
				}
				m.setGradeCode(rset.getString("GRADE_NAME"));
				m.setSubscriptionDate(rset.getDate("SUBSCRIPTION_DATE"));
				list.add(m);
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

	public ArrayList<MemberGrade> selectMemberGrade(Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MemberGrade> list = new ArrayList<MemberGrade>();
		String sql = prop.getProperty("selectMemberGrade");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				MemberGrade mg = new MemberGrade(
						rset.getString("GRADE_CODE")
						,rset.getString("GRADE_NAME"));
				
				list.add(mg);
				
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


	public int deleteMember(Connection conn, String[] mno) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMember");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < mno.length; i++) {
				pstmt.setInt(1, Integer.parseInt(mno[i]));
				result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


	public AdminMember selectMember(Connection conn, int mno) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		AdminMember m = null;
		String sql = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,mno);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				m = new AdminMember();
				m.setMemberNo(rset.getInt("MEMBER_NO"));
				m.setMemberId(rset.getString("MEMBER_ID"));
				m.setMemberPwd(rset.getString("MEMBER_PWD"));
				m.setMemberName(rset.getString("MEMBER_NAME"));
				m.setEmail(rset.getString("EMAIL"));
				if (m.getEmail()==null) {
					m.setEmail("");
				}
				m.setAddress(rset.getString("ADDRESS"));
				if (m.getAddress()==null) {
					m.setAddress("");
				}
				m.setPhone(rset.getString("PHONE"));
				if (m.getPhone()==null) {
					m.setPhone("");
				}
				m.setGradeCode(rset.getString("GRADE_CODE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}


	public int updateMember(Connection conn, AdminMember m) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMember");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberPwd());
			pstmt.setString(2, m.getGradeCode());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getAddress());
			pstmt.setInt(7, m.getMemberNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	

	
}


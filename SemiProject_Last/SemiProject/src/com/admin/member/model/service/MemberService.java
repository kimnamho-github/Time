package com.admin.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.admin.member.model.dao.MemberDao;
import com.admin.member.model.vo.AdminMember;
import com.admin.member.model.vo.MemberGrade;
import com.common.JDBCTemplate;
import com.common.model.vo.PageInfo;

public class MemberService {

	public int countMember(String search, String mg) {
		// TODO Auto-generated method stub
		Connection conn =  JDBCTemplate.getConnection();
		int result = new MemberDao().countMember(conn,search,mg);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<AdminMember> selectMemberList(PageInfo pageInfo, String search, String mg) {
		// TODO Auto-generated method stub
		Connection conn =  JDBCTemplate.getConnection();
		ArrayList<AdminMember> list = new MemberDao().selectMemberList(conn,pageInfo,search,mg);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<MemberGrade> selectMemberGrade() {
		// TODO Auto-generated method stub
		Connection conn =  JDBCTemplate.getConnection();
		ArrayList<MemberGrade> list = new MemberDao().selectMemberGrade(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public int deleteMember(String[] mno) {
		// TODO Auto-generated method stub
		Connection conn =  JDBCTemplate.getConnection();
		int result = new MemberDao().deleteMember(conn, mno);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public AdminMember selectMember(int mno) {
		// TODO Auto-generated method stub
		Connection conn =  JDBCTemplate.getConnection();
		AdminMember m = new MemberDao().selectMember(conn, mno);
		JDBCTemplate.close(conn);
		return m;
	}

	public int updateMember(AdminMember m) {
		// TODO Auto-generated method stub
		Connection conn =  JDBCTemplate.getConnection();
		int result = new MemberDao().updateMember(conn, m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}

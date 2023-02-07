package com.admin.date.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.admin.board.model.dao.BoardDao;
import com.admin.date.model.dao.DateDao;
import com.admin.date.model.vo.Dose;
import com.admin.date.model.vo.Ingrd;
import com.common.JDBCTemplate;
import com.common.model.vo.Attachment;
import com.common.model.vo.PageInfo;

public class DateService {

	public int countIngrd(String search) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = new DateDao().countIngrd(conn,search);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Ingrd> selectIngrdList(PageInfo pageInfo, String search) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Ingrd> list = new DateDao().selectIngrdList(conn,pageInfo,search);
		JDBCTemplate.close(conn);
		return list;
	}

	public int deleteIngrd(String[] ino, HashMap<String, String> map) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = new DateDao().deleteIngrd(conn,ino,map);
		if (result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public HashMap<String, String> selectIngrd(String[] ino) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		HashMap<String, String> map = new DateDao().selectIngrd(conn,ino);
		JDBCTemplate.close(conn);
		return map;
	}

	public int checkIngrd(String iname) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = new DateDao().checkIngrd(conn,iname);
		JDBCTemplate.close(conn);
		return result;
	}

	public int inertIngrd(String iname) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = new DateDao().inertIngrd(conn,iname);
		if (result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int countDose(String search) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = new DateDao().countDose(conn,search);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Dose> selectDoseList(PageInfo pageInfo, String search) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Dose> list = new DateDao().selectDoseList(conn,pageInfo,search);
		JDBCTemplate.close(conn);
		return list;
	}

	public int checkDose(String dname) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = new DateDao().checkDose(conn,dname);
		JDBCTemplate.close(conn);
		return result;
	}

	public int inertDose(String dname) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = new DateDao().inertDose(conn,dname);
		if (result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public HashMap<String, String> selectDose(String[] dno) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		HashMap<String, String> map = new DateDao().selectDose(conn,dno);
		JDBCTemplate.close(conn);
		return map;
	}

	public int deleteDose(String[] dno, HashMap<String, String> map) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int result = new DateDao().deleteDose(conn,dno,map);
		if (result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
}

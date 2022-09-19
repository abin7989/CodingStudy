package com.ssafy.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.member.model.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {

	private static MemberDao memberDao= new MemberDaoImpl(); 
	private DBUtil dbUtil;
	private MemberDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	public static MemberDao getMemberDao() {
		return memberDao;
	}
	@Override
	public int idCheck(String userId) throws SQLException {
		int cnt = 1;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			con = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select count(user_id) ");
			sql.append("from members ");
			sql.append("where user_id=?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,userId);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
			
		}finally {
			dbUtil.close(con,pstmt,rs);
		}
		return cnt;
	}

	@Override
	public int joinMember(MemberDto memberDto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberDto loginMember(String userId, String userPwd) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}

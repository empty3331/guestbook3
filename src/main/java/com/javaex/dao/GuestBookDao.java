package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;

@Repository
public class GuestBookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 방명록 리스트(검색할때)
	public List<GuestBookVo> getGuestBookList() {
		List<GuestBookVo> guestBookList = sqlSession.selectList("guestbook.getList");
		return guestBookList;

	}
	
	// 방명록추가
	public int guestBookInsert(GuestBookVo guestBookVo) {
		int count = sqlSession.insert("guestbook.insert", guestBookVo);

		return count;

	}

	// 방명록 삭제
	public int guestBookDelete(int no, String password) {
		Map<String, Object> gMap = new HashMap<String, Object>();
		gMap.put("no", no);
		gMap.put("password", password);
		int count = sqlSession.delete("guestbook.delete", gMap );
		return count;
	}

	/*
	// 방명록추가
	public int guestBookInsert(GuestBookVo guestBookVo) {
		int count = 0;
		getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = ""; // 쿼리문 문자열만들기, ? 주의
			query += " INSERT INTO guestbook ";
			query += " VALUES (seq_guestbook_id.nextval,?,?,?,SYSDATE) ";
			// System.out.println(query);

			pstmt = conn.prepareStatement(query); // 쿼리로 만들기

			pstmt.setString(1, guestBookVo.getName()); // ?(물음표) 중 1번째, 순서중요
			pstmt.setString(2, guestBookVo.getPassword()); // ?(물음표) 중 2번째, 순서중요
			pstmt.setString(3, guestBookVo.getContent()); // ?(물음표) 중 3번째, 순서중요

			count = pstmt.executeUpdate(); // 쿼리문 실행

			// 4.결과처리
			// System.out.println("[" + count + "건 추가되었습니다.]");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
		return count;
	}
	
	
	
	// 방명록 수정
	public int guestBookUpdate(GuestBookVo guestBookVo) {
		int count = 0;
		getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = ""; // 쿼리문 문자열만들기, ? 주의
			query += " UPDATE guestbook ";
			query += " set name = ?, ";
			query += "     password = ?, ";
			query += "     content =? ";
			query += " WHERE no =? ";

			pstmt = conn.prepareStatement(query); // 쿼리로 만들기

			pstmt.setString(1, guestBookVo.getName()); // ?(물음표) 중 1번째, 순서중요
			pstmt.setString(2, guestBookVo.getPassword()); // ?(물음표) 중 2번째, 순서중요
			pstmt.setString(3, guestBookVo.getContent()); // ?(물음표) 중 3번째, 순서중요
			pstmt.setInt(4, guestBookVo.getNo()); // ?(물음표) 중 4번째, 순서중요

			count = pstmt.executeUpdate(); // 쿼리문 실행

			// 4.결과처리
			// System.out.println(count + "건 수정되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		close();
		return count;
	}

	//방명록 삭제
	public int guestBookDelete(int id,String password) {
		int count = 0;
		getConnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = ""; // 쿼리문 문자열만들기, ? 주의
			query += " delete from guestbook ";
			query += " where no = ? ";
			query += " and  password = ?";
			pstmt = conn.prepareStatement(query); // 쿼리로 만들기

			pstmt.setInt(1, id);// ?(물음표) 중 1번째, 순서중요
			pstmt.setString(2, password);
			
			count = pstmt.executeUpdate(); // 쿼리문 실행

			// 4.결과처리
			// System.out.println(count + "건 삭제되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		close();
		return count;
	}
	
*/
}

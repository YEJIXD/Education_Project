package com.edu.java.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.java.dto.ApplicationDto;
import com.edu.java.dto.CourseDto;
import com.edu.java.dto.FaqDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.QnaDto;
import com.edu.java.dto.ReviewDto;

@Repository
public class AdminDaoImpl implements AdminDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int adminUserCount() {
		int count = 0;
		
		try {
			count = sqlSession.selectOne(NAMESPACE + "adminUserCount");
			
		} catch (Exception e) {
			System.out.println("[error] : admin User Count");
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int newAdminUserCount() {
		int count = 0;
		
		try {
			count = sqlSession.selectOne(NAMESPACE + "newAdminUserCount");
		} catch (Exception e) {
			System.out.println("[error] : all user count");
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int adminCancleCount() {
		int count = 0;
		
		try {
			count = sqlSession.selectOne(NAMESPACE + "adminCancleCount");
			
		} catch (Exception e) {
			System.out.println("[error] : admin cancle Count");
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int newAdminCancleCount() {
		int count = 0;
		
		try {
			count = sqlSession.selectOne(NAMESPACE + "newAdminCancleCount");
			
		} catch (Exception e) {
			System.out.println("[error] : all Cancle Count");
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int adminReviewCount() {
		int count = 0;
		
		try {
			count = sqlSession.selectOne(NAMESPACE + "adminReviewCount");
			
		} catch (Exception e) {
			System.out.println("[error] : admin Review Count");
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int newAdminReviewCount() {
		int count = 0;
		
		try {
			count = sqlSession.selectOne(NAMESPACE + "newAdminReviewCount");
			
		} catch (Exception e) {
			System.out.println("[error] : all Review Count");
			e.printStackTrace();
		}
		
		return count;
	}
	
	
	/* 공 지 사 항 */
	@Override
	public List<NoticeDto> adminNoticeList() {
		List<NoticeDto> adminNoticeList = new ArrayList<NoticeDto>();
		
		try {
			adminNoticeList = sqlSession.selectList(NAMESPACE + "adminNoticeList");
			
		} catch (Exception e) {
			System.out.println("[error] : admin notice list");
			e.printStackTrace();
		}
		
		return adminNoticeList;
	}

	/*@Override
	public NoticeDto selectOne(int noti_no) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public int adminNoticeInsert(NoticeDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "adminNoticeInsert", dto);
		} catch (Exception e) {
			System.out.println("[error] : notice insert");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int adminNoticeUpdate(NoticeDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE + "adminNoticeUpdate", dto);
		} catch (Exception e) {
			System.out.println("[error] : admin Notice Update");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int adminNoticeDelete(int noti_no) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"adminNoticeDelete", noti_no);
			
		} catch (Exception e) {
			System.out.println("[error] : admin notice delete");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<CourseDto> adminCourseList() {
		
		return null;
	}

	@Override
	public int adminCourseInsert(CourseDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adminCourseUpdate(CourseDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*@Override
	public int adminCourseDelete(CourseDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}*/

	@Override
	public List<ReviewDto> adminReviewList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adminReviewDelete(int user_no) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<FaqDto> adminFaqList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adminFaqInsert(FaqDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adminFaqUpdate(FaqDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*@Override
	public int adminFaqDelete(FaqDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}*/
	
	@Override
	public List<FaqDto> hashTagSearch(String faq_category){
		List<FaqDto> list = null;
		
		try {
			list = sqlSession.selectList(NAMESPACE+"hashTagSearch", faq_category);
		} catch (Exception e) {
			System.out.println("hashTagSearch Dao Impl error");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<QnaDto> adminQnaList() {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public int adminQnaDelete(QnaDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}*/

	@Override
	public List<ApplicationDto> adminCancleList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adminCancleDelete(int cancle_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adminFaqDelete(int faq_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adminQnaDelete(int q_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adminCourseDelete(int c_no) {
		// TODO Auto-generated method stub
		return 0;
	}
}

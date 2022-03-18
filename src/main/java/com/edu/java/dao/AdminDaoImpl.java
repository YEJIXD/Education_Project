package com.edu.java.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.activation.CommandMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.java.dto.CancleDto;
import com.edu.java.dto.CourseDto;
import com.edu.java.dto.FaqDto;
import com.edu.java.dto.MemberDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.QnaDto;
import com.edu.java.dto.ReviewDto;
import com.edu.java.dto.TeacherDto;

@Repository
public class AdminDaoImpl implements AdminDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	/* 관리자 메인 */
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

	@Override
	public NoticeDto noticeSelectOne(int noti_no) {
		NoticeDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE+"noticeDetail", noti_no);
		} catch (Exception e) {
			System.out.println("[error] : admin Notice Detail error");
			e.printStackTrace();
		}
		return dto;
	}

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
	

	/* Q n A */
	@Override
	public List<QnaDto> adminQnaList() {
		List<QnaDto> adminQnaList = new ArrayList<QnaDto>();
		
		try {
			adminQnaList = sqlSession.selectList(NAMESPACE + "adminQnaList");
		} catch (Exception e) {
			System.out.println("[error] : admin Qna list");
			e.printStackTrace();
		}
		return adminQnaList;
	}
	
	@Override 
	public QnaDto qnaSelectOne(int q_no) {
		QnaDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "qnaSelectOne", q_no);
		} catch (Exception e) {
			System.out.println("[error] : admin Qna Select One error");
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int adminQnaDelete(int q_no) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"adminQnaDelete", q_no);
		} catch (Exception e) {
			System.out.println("[error] : admin Qna Delete error");
			e.printStackTrace();
		}
		return res;
	}

	
	/* F A Q */
	@Override
	public List<FaqDto> adminFaqList() {
		List<FaqDto> adminFaqList = new ArrayList<FaqDto>();
		
		try {
			adminFaqList = sqlSession.selectList(NAMESPACE + "adminFaqList");
		} catch (Exception e) {
			System.out.println("[error] : admin faq list");
			e.printStackTrace();
		}
		return adminFaqList;
	}
	
	@Override
	public FaqDto faqSelectOne(int faq_no) {
		FaqDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "faqSelectOne", faq_no);
		} catch (Exception e) {
			System.out.println("[error] : admin Faq Select One error");
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int adminFaqInsert(FaqDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "adminFaqInsert", dto);
		} catch (Exception e) {
			System.out.println("[error] : admin Faq Insert error");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int adminFaqUpdate(FaqDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE + "adminFaqUpdate", dto);
		} catch (Exception e) {
			System.out.println("[error] : admin Faq Update error");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int adminFaqDelete(int faq_no) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"adminFaqDelete", faq_no);
		} catch (Exception e) {
			System.out.println("[error] : admin Faq Delete error");
			e.printStackTrace();
		}
		return res;
	}
	
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
	
	
	/* Course */
	@Override
	public List<CourseDto> adminCourseList() {
		List<CourseDto> adminCourseList = new ArrayList<CourseDto>();
			
		try {
			adminCourseList = sqlSession.selectList(NAMESPACE + "adminCourseList");
		} catch (Exception e) {
			System.out.println("[error] : admin Course list");
			e.printStackTrace();
		}
		return adminCourseList;
	}
	
	@Override
	public CourseDto adminCourseDetail(int c_no) throws Exception {
		CourseDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "adminCourseDetail", c_no);
		} catch (Exception e) {
			System.out.println("[error] : admin Course Detail error");
			e.printStackTrace();
		}
		return dto;
	}
		
		
	@Override
	public int adminCourseInsert(CourseDto dto) throws Exception{
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "adminCourseInsert", dto);
			System.out.println("dto : " + dto);
		} catch (Exception e) {
			System.out.println("[error] : admin Course Insert error");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int adminCourseUpdate(CourseDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "adminCourseUpdate", dto);
		} catch (Exception e) {
			System.out.println("[error] : admin Course Update error");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int adminCourseDelete(int c_no) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"adminCourseDelete", c_no);
		} catch (Exception e) {
			System.out.println("[error] : admin Course Delete error");
			e.printStackTrace();
		}
		return res;
	}
	
	/* Teacher */
	@Override
	public List<TeacherDto> adminTeacherList() {
		List<TeacherDto> adminTeacherList = new ArrayList<TeacherDto>();
		
		try {
			adminTeacherList = sqlSession.selectList(NAMESPACE + "adminTeacherList");
		} catch (Exception e) {
			System.out.println("[error] : admin Teacher list");
			e.printStackTrace();
		}
		return adminTeacherList;
	}

	@Override
	public int adminTeacherInsert(TeacherDto dto) {
		return 0;
	}

	@Override
	public int adminTeacherUpdate(TeacherDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "adminTeacherUpdate", dto);
		} catch (Exception e) {
			System.out.println("[error] : admin Teacher Update error");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int adminTeacherDelete(int t_no) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"adminTeacherDelete", t_no);
		} catch (Exception e) {
			System.out.println("[error] : admin Teacher Delete error");
			e.printStackTrace();
		}
		return res;
	}
	
	
	/* Member */
	@Override
	public List<MemberDto> adminMemberList() {
		List<MemberDto> adminMemberList = new ArrayList<MemberDto>();
		
		try {
			adminMemberList = sqlSession.selectList(NAMESPACE + "adminMemberList");
		} catch (Exception e) {
			System.out.println("[error] : admin Member list");
			e.printStackTrace();
		}
		return adminMemberList;
	}

	@Override
	public int adminMemberDelete(int user_no) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"adminMemberDelete", user_no);
		} catch (Exception e) {
			System.out.println("[error] : admin Member Delete error");
			e.printStackTrace();
		}
		
		return res;
	}
	
	
}

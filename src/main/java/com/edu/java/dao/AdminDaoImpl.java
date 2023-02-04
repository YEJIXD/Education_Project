package com.edu.java.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.java.dto.ApplicationDto;
import com.edu.java.dto.CourseDto;
import com.edu.java.dto.Criteria;
import com.edu.java.dto.FaqDto;
import com.edu.java.dto.UserDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.PageDto;
import com.edu.java.dto.QnaDto;
import com.edu.java.dto.TeacherDto;

@Repository
public class AdminDaoImpl implements AdminDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int userCount() {
		int count = sqlSession.selectOne(NAMESPACE + "userCount");
		return count;
	}

	@Override
	public int newUserCount() {
		int count = sqlSession.selectOne(NAMESPACE + "newUserCount");
		return count;
	}

	@Override
	public int cancelCount() {
		int count = sqlSession.selectOne(NAMESPACE + "cancelCount");
		return count;
	}

	@Override
	public int newCancelCount() {
		int count = sqlSession.selectOne(NAMESPACE + "newCancelCount");
		return count;
	}

	@Override
	public int reviewCount() {
		int count = sqlSession.selectOne(NAMESPACE + "ReviewCount");
		return count;
	}

	@Override
	public int newReviewCount() {
		int count = sqlSession.selectOne(NAMESPACE + "newReviewCount");	
		return count;
	}
	
	@Override
	public List<NoticeDto> noticeList() {
		List<NoticeDto> adminNoticeList = sqlSession.selectList(NAMESPACE + "noticeList");
		return adminNoticeList;
	}

	@Override
	public NoticeDto selectNotice(int seq) {
		NoticeDto dto = sqlSession.selectOne(NAMESPACE+"selectNotice", seq);
		return dto;
	}

	@Override
	public int inputNotice(NoticeDto dto) {
		int res = sqlSession.insert(NAMESPACE + "inputNotice", dto);
		return res;
	}

	@Override
	public int modifyNotice(NoticeDto dto) {
		int res = sqlSession.update(NAMESPACE + "modifyNotice", dto);
		return res;
	}

	@Override
	public int deleteNotice(int seq) {
		int res = sqlSession.delete(NAMESPACE+"deleteNotice", seq);
		return res;
	}
	
	@Override
	public List<QnaDto> getQna() {
		List<QnaDto> qnaList = sqlSession.selectList(NAMESPACE + "getQna");
		return qnaList;
	}
	
	@Override 
	public QnaDto selectQna(int q_no) {
		QnaDto dto = sqlSession.selectOne(NAMESPACE + "selectQna", q_no);
		return dto;
	}

	@Override
	public int deleteQna(int q_no) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"deleteQna", q_no);
		} catch (Exception e) {
			System.out.println("[error] : admin Qna Delete error");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<FaqDto> faqList() {
		List<FaqDto> faqList = new ArrayList<FaqDto>();
		
		try {
			faqList = sqlSession.selectList(NAMESPACE + "faqList");
		} catch (Exception e) {
			System.out.println("[error] : admin faq list");
			e.printStackTrace();
		}
		return faqList;
	}
	
	@Override
	public FaqDto faqDetail(int faq_no) {
		FaqDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "faqDetail", faq_no);
		} catch (Exception e) {
			System.out.println("[error] : admin Faq Select One error");
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int inputFaq(FaqDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "inputFaq", dto);
		} catch (Exception e) {
			System.out.println("[error] : admin Faq Insert error");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int modifyFaq(FaqDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE + "modifyFaq", dto);
		} catch (Exception e) {
			System.out.println("[error] : admin Faq Update error");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int deleteFaq(int faq_no) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"deleteFaq", faq_no);
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
	
	
	@Override
	public List<Map<String, Object>> courseList(PageDto dto, Criteria cri) {
		List<Map<String, Object>> courseList = new ArrayList<Map<String, Object>>();
		System.out.println(cri);
		try {
			courseList = sqlSession.selectList(NAMESPACE + "courseList", dto);
		} catch (Exception e) {
			System.out.println("[error] : admin Course list");
			e.printStackTrace();
		}
		return courseList;
	}
	
	 @Override 
	 public int getTotalCount(String param) { 
		 int total = 0;
	  
		 try { 
			 total = sqlSession.selectOne(NAMESPACE + "getTotalCount", param);
		 } catch (Exception e) {
			 System.out.println("[error] : Course Get Total"); 
			 e.printStackTrace(); 
		 }
		 return total; 
	}

	@Override
	public CourseDto courseDetail(int c_no) throws Exception {
		CourseDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "courseDetail", c_no);
		} catch (Exception e) {
			System.out.println("[error] : admin Course Detail error");
			e.printStackTrace();
		}
		return dto;
	}
		
		
	@Override
	public int inputCourse(CourseDto dto) throws Exception{
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "inputCourse", dto);
			System.out.println("dto : " + dto);
		} catch (Exception e) {
			System.out.println("[error] : admin Course Insert error");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int modifyCourse(CourseDto dto) throws Exception{
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE + "modifyCourse", dto);
		} catch (Exception e) {
			System.out.println("[error] : admin Course Update error");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public void deleteCourse(int c_no) {
		try {
			sqlSession.delete(NAMESPACE+"deleteCourse", c_no);
		} catch (Exception e) {
			System.out.println("[error] : admin Course Delete error");
			e.printStackTrace();
		}
	}
	
	/*
	 * @Override public int adminCourseCount(String c_count) throws Exception{ int
	 * res = 0;
	 * 
	 * try { res = sqlSession.update(NAMESPACE + "adminCourseCount", c_count); }
	 * catch (Exception e) {
	 * System.out.println("[error] : admin Course Count error");
	 * e.printStackTrace(); } return res; }
	 */
	
	@Override
	public List<TeacherDto> teacherList() {
		List<TeacherDto> teacherList = new ArrayList<TeacherDto>();
		
		try {
			teacherList = sqlSession.selectList(NAMESPACE + "teacherList");
		} catch (Exception e) {
			System.out.println("[error] : admin Teacher list");
			e.printStackTrace();
		}
		return teacherList;
	}

	@Override
	public int inputTeacher(TeacherDto dto) {
		return 0;
	}

	@Override
	public int modifyTeacher(TeacherDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "modifyTeacher", dto);
		} catch (Exception e) {
			System.out.println("[error] : admin Teacher Update error");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int deleteTeacher(int t_no) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"deleteTeacher", t_no);
		} catch (Exception e) {
			System.out.println("[error] : admin Teacher Delete error");
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public List<UserDto> memberList() {
		List<UserDto> memberList = new ArrayList<>();
		
		try {
			memberList = sqlSession.selectList(NAMESPACE + "memberList");
		} catch (Exception e) {
			System.out.println("[error] : admin Member list");
			e.printStackTrace();
		}
		return memberList;
	}

	@Override
	public int deleteMember(int user_no) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE+"deleteMember", user_no);
		} catch (Exception e) {
			System.out.println("[error] : admin Member Delete error");
			e.printStackTrace();
		}
		
		return res;
	}
	
	@Override
	public List<Map<String, Object>> appList(PageDto dto, Criteria cri) {
		List<Map<String, Object>> appList = new ArrayList<Map<String, Object>>();
		System.out.println(cri);
		try {
			appList = sqlSession.selectList(NAMESPACE + "appList", dto);
		} catch (Exception e) {
			System.out.println("[error] : admin App list");
			e.printStackTrace();
		}
		return appList;
	}
	
	 @Override 
	 public int getAppTotal(String param) { 
		 int total = 0;
	  
		 try { 
			 total = sqlSession.selectOne(NAMESPACE + "getAppTotal", param);
		 } catch (Exception e) {
			 System.out.println("[error] : Application Get Total"); 
			 e.printStackTrace(); 
		 }
		 return total; 
	}
	 
	 @Override
	 public ApplicationDto appDetail(int app_no) throws Exception{
		 ApplicationDto dto = null;
			
			try {
				dto = sqlSession.selectOne(NAMESPACE + "appDetail", app_no);
			} catch (Exception e) {
				System.out.println("[error] : admin Application Detail error");
				e.printStackTrace();
			}
			return dto;
	 }
	
}

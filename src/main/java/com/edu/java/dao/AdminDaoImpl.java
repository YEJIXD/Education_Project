package com.edu.java.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.edu.java.dto.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.java.dto.UserDto;

@Repository
public class AdminDaoImpl implements AdminDao{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int userCount() {
		int count = 0;
		
		try {
			count = sqlSession.selectOne(NAMESPACE + "adminUserCount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int newUserCount() {
		int count = 0;
		
		try {
			count = sqlSession.selectOne(NAMESPACE + "newAdminUserCount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int cancelCount() {
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
	public int newCancelCount() {
		int count = 0;
		
		try {
			count = sqlSession.selectOne(NAMESPACE + "newAdminCancleCount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int reviewCount() {
		int count = 0;
		
		try {
			count = sqlSession.selectOne(NAMESPACE + "adminReviewCount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int newReviewCount() {
		int count = 0;
		
		try {
			count = sqlSession.selectOne(NAMESPACE + "newAdminReviewCount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
	@Override
	public List<NoticeDto> noticeList() {
		List<NoticeDto> noticeList = new ArrayList<>();
		
		try {
			noticeList = sqlSession.selectList(NAMESPACE + "noticeList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeList;
	}

	@Override
	public NoticeDto selectNotice(int noti_no) {
		NoticeDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE+"noticeDetail", noti_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public void inputNotice(NoticeDto dto) {
		try {
			sqlSession.insert(NAMESPACE + "inputNotice", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifyNotice(NoticeDto dto) {
		try {
			sqlSession.update(NAMESPACE + "modifyNotice", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteNotice(int noti_no) {
		try {
			sqlSession.delete(NAMESPACE+"deleteNotice", noti_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<QnaDto> qnaList() {
		List<QnaDto> qnaList = new ArrayList<>();
		
		try {
			qnaList = sqlSession.selectList(NAMESPACE + "qnaList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qnaList;
	}
	
	@Override 
	public QnaDto selectQna(int q_no) {
		QnaDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectQna", q_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public void deleteQna(int q_no) {
		try {
			sqlSession.delete(NAMESPACE+"deleteQna", q_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<FaqDto> faqList() {
		List<FaqDto> faqList = new ArrayList<>();
		
		try {
			faqList = sqlSession.selectList(NAMESPACE + "faqList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return faqList;
	}
	
	@Override
	public FaqDto selectFaq(int faq_no) {
		FaqDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectFaq", faq_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public void inputFaq(FaqDto dto) {
		try {
			sqlSession.insert(NAMESPACE + "inputFaq", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifyFaq(FaqDto dto) {
		try {
			sqlSession.update(NAMESPACE + "modifyFaq", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteFaq(int faq_no) {
		try {
			sqlSession.delete(NAMESPACE+"deleteFaq", faq_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		List<Map<String, Object>> courseList = new ArrayList<>();
		try {
			courseList = sqlSession.selectList(NAMESPACE + "courseList", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courseList;
	}
	
	 @Override
	 public int getTotal(String param) { 
		 int total = 0;
	  
		 try { 
			 total = sqlSession.selectOne(NAMESPACE + "getTotal", param);
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 return total; 
	}
	 
//	 @Override
//	 @SuppressWarnings("unchecked")
//	 public List<Map<String, Object>> selectBoardList(Criteria cri) {
//		    return (List<Map<String,Object>>)selectList(NAMESPACE + "adminCourseList", cri);
//		}
//
//
//	private List<Map<String, Object>> selectList(String string, Criteria cri) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public CourseDto selectCourse(int c_no) throws Exception {
		CourseDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "adminCourseDetail", c_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
		
		
	@Override
	public void inputCourse(CourseDto dto) {
		try {
			sqlSession.insert(NAMESPACE + "inputCourse", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifyCourse(CourseDto dto) throws Exception{
		try {
			sqlSession.update(NAMESPACE + "modifyCourse", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCourse(int c_no) {
		try {
			sqlSession.delete(NAMESPACE+"deleteCourse", c_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int courseCount(String c_count) throws Exception{
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE + "courseCount", c_count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public List<TeacherDto> teacherList() {
		List<TeacherDto> teacherList = new ArrayList<>();
		
		try {
			teacherList = sqlSession.selectList(NAMESPACE + "teacherList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teacherList;
	}

	@Override
	public void inputTeacher(TeacherDto dto) {
		sqlSession.insert(NAMESPACE + "inputTeacher", dto);
	}

	@Override
	public void modifyTeacher(TeacherDto dto) {
		try {
			sqlSession.insert(NAMESPACE + "modifyTeacher", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTeacher(int t_no) {
		try {
			sqlSession.delete(NAMESPACE + "deleteTeacher", t_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<UserDto> userList() {
		List<UserDto> adminMemberList = new ArrayList<>();
		
		try {
			adminMemberList = sqlSession.selectList(NAMESPACE + "adminMemberList");
		} catch (Exception e) {
			System.out.println("[error] : admin Member list");
			e.printStackTrace();
		}
		return adminMemberList;
	}

	@Override
	public void deleteUser(int user_no) {
		try {
			sqlSession.delete(NAMESPACE+"adminMemberDelete", user_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

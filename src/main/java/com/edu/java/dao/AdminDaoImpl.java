package com.edu.java.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
		return sqlSession.selectOne(NAMESPACE + "adminUserCount");
	}

	@Override
	public int newUserCount() {
		return sqlSession.selectOne(NAMESPACE + "newAdminUserCount");
	}

	@Override
	public int cancelCount() {
		return sqlSession.selectOne(NAMESPACE + "adminCancleCount");
	}

	@Override
	public int newCancelCount() {
		return sqlSession.selectOne(NAMESPACE + "newAdminCancleCount");
	}

	@Override
	public int reviewCount() {
		return sqlSession.selectOne(NAMESPACE + "adminReviewCount");
	}

	@Override
	public int newReviewCount() {
		return sqlSession.selectOne(NAMESPACE + "newAdminReviewCount");
	}
	
	
	@Override
	public List<NoticeDto> noticeList() {
		return sqlSession.selectList(NAMESPACE + "noticeList");
	}

	@Override
	public NoticeDto selectNotice(int noti_no) {
		return sqlSession.selectOne(NAMESPACE+"noticeDetail", noti_no);
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
		return sqlSession.selectList(NAMESPACE + "qnaList");
	}
	
	@Override 
	public QnaDto selectQna(int q_no) {
		return sqlSession.selectOne(NAMESPACE + "selectQna", q_no);
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
		return sqlSession.selectList(NAMESPACE + "faqList");
	}
	
	@Override
	public FaqDto selectFaq(int faq_no) {
		return sqlSession.selectOne(NAMESPACE + "selectFaq", faq_no);
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
		return sqlSession.selectList(NAMESPACE+"hashTagSearch", faq_category);
	}
	
	@Override
	public List<HashMap<String, Object>> courseList(PageDto dto, Criteria cri) {
		return sqlSession.selectList(NAMESPACE + "courseList", dto);
	}
	
	 @Override
	 public int getTotal(String param) {
		 return sqlSession.selectOne(NAMESPACE + "getTotal", param);
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

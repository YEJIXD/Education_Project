package com.edu.java.dao;

import java.util.HashMap;
import java.util.List;

import com.edu.java.dto.*;

public interface AdminDao {
	String NAMESPACE = "admin.";
	
	int userCount();
	int newUserCount();
	int cancelCount();
	int newCancelCount();
	int reviewCount();
	int newReviewCount();

	List<NoticeDto> noticeList();
	NoticeDto selectNotice(int notice_seq);
	void inputNotice(NoticeDto dto);
	void modifyNotice(NoticeDto dto);
	void deleteNotice(int notice_seq);

	List<QnaDto> qnaList();
	QnaDto selectQna(int q_no);
	void deleteQna(int q_no);

	List<FaqDto> faqList();
	FaqDto selectFaq(int faq_no);
	void inputFaq(FaqDto dto);
	void modifyFaq(FaqDto dto);
	void deleteFaq(int faq_no);
	List<FaqDto> hashTagSearch(String faq_category);
	
	List<HashMap<String, Object>> courseList(PageDto dto, Criteria cri) ;
	int getTotal(String param);
	//List<Map<String, Object>> selectBoardList(Criteria cri);
	CourseDto selectCourse(int c_no) throws Exception;
	void inputCourse(CourseDto dto) throws Exception;
	void modifyCourse(CourseDto dto) throws Exception;
	void deleteCourse(int c_no);
	int courseCount(String c_count) throws Exception;
	
	List<TeacherDto> teacherList();
	void inputTeacher(TeacherDto dto);
	void modifyTeacher(TeacherDto dto);
	void deleteTeacher(int t_no);
	
	List<UserDto> userList();
	void deleteUser(int user_no);
	
}

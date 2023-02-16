package com.edu.java.mapper;

import java.util.HashMap;
import java.util.List;

import com.edu.java.dto.*;
import com.edu.java.dto.UserDto;

public interface AdminMapper {
	int userCount();

	int newUserCount();

	int cancelCount();

	int newCancelCount();

	int reviewCount();

	int newReviewCount();

	List<NoticeDto> noticeList() throws Exception;

	NoticeDto selectNotice(int noti_no);

	void inputNotice(NoticeDto dto);

	void modifyNotice(NoticeDto dto);

	void deleteNotice(int noti_no);

	List<QnaDto> qnaList();

	QnaDto selectQna(int q_no);

	void deleteQna(int q_no);

	List<FaqDto> faqList();

	FaqDto selectFaq(int faq_no);

	void inputFaq(FaqDto dto);

	void modifyFaq(FaqDto dto);

	void deleteFaq(int faq_no);

	List<FaqDto> hashTagSearch(String faq_category);

	List<HashMap<String, Object>> courseList(PageDto dto, Criteria cri);

	int getTotal(String param);

	CourseDto selectCourse(int c_no);

	void inputCourse(CourseDto dto);

	void modifyCourse(CourseDto dto);

	void deleteCourse(int c_no);

	List<TeacherDto> teacherList();

	void inputTeacher(TeacherDto dto);

	void modifyTeacher(TeacherDto dto);

	void deleteTeacher(int t_no);

	List<UserDto> userList();

	void deleteUser(int user_no);
}


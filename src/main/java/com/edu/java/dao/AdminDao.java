package com.edu.java.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.edu.java.dto.ApplicationDto;
import com.edu.java.dto.CourseDto;
import com.edu.java.dto.Criteria;
import com.edu.java.dto.FaqDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.PageDto;
import com.edu.java.dto.QnaDto;
import com.edu.java.dto.TeacherDto;
import com.edu.java.dto.UserDto;

@Mapper
public interface AdminDao {
	String NAMESPACE = "admin.";
	
	int userCount();
	int newUserCount();
	int cancelCount();
	int newCancelCount();
	int reviewCount();
	int newReviewCount();
	
	List<NoticeDto> getNotice();
	NoticeDto selectNotice(int seq);
	int inputNotice(NoticeDto dto);
	int modifyNotice(NoticeDto dto);
	int deleteNotice(int seq);
	
	List<QnaDto> getQna();
	QnaDto selectQna(int q_no);
	int deleteQna(int q_no);
	
	List<FaqDto> faqList();
	FaqDto faqDetail(int faq_no);
	int inputFaq(FaqDto dto);
	int modifyFaq(FaqDto dto);
	int deleteFaq(int faq_no);
	List<FaqDto> hashTagSearch(String faq_category);
	
	List<Map<String, Object>> courseList(PageDto dto, Criteria cri) ;
	int getTotalCount(String param);
	//List<Map<String, Object>> selectBoardList(Criteria cri);
	CourseDto courseDetail(int c_no) throws Exception;
	int inputCourse(CourseDto dto) throws Exception;
	int modifyCourse(CourseDto dto) throws Exception;
	void deleteCourse(int c_no);
	//int courseCount(String c_count) throws Exception;
	
	List<TeacherDto> teacherList();
	int inputTeacher(TeacherDto dto);
	int modifyTeacher(TeacherDto dto);
	int deleteTeacher(int t_no);
	
	List<UserDto> memberList();
	int deleteMember(int user_no);
	
	List<Map<String, Object>> appList(PageDto dto, Criteria cri);
	int getAppTotal(String param);
	ApplicationDto appDetail(int app_no) throws Exception;
}

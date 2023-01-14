package com.edu.java.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.edu.java.dto.ApplicationDto;
import com.edu.java.dto.CourseDto;
import com.edu.java.dto.Criteria;
import com.edu.java.dto.FaqDto;
import com.edu.java.dto.MemberDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.PageDto;
import com.edu.java.dto.QnaDto;
import com.edu.java.dto.TeacherDto;

@Mapper
public interface AdminDao {
	String NAMESPACE = "admin.";
	
	public int userCount();
	public int newUserCount();
	public int cancleCount();
	public int newCancleCount();
	public int ReviewCount();
	public int newReviewCount();
	
	public List<NoticeDto> getNotice();
	public NoticeDto selectNotice(int noti_no);
	public int inputNotice(NoticeDto dto);
	public int modifyNotice(NoticeDto dto);
	public int deleteNotice(int noti_no);
	
	public List<QnaDto> getQna();
	public QnaDto selectQna(int q_no);
	/*public int deleteQna(int q_no);
	
	public List<FaqDto> faqList();
	public FaqDto faqDetail(int faq_no);
	public int inputFaq(FaqDto dto);
	public int modifyFaq(FaqDto dto);
	public int deleteFaq(int faq_no);
	public List<FaqDto> hashTagSearch(String faq_category);
	
	public List<Map<String, Object>> courseList(PageDto dto, Criteria cri) ;
	public int getTotalCount(String param);
	//List<Map<String, Object>> selectBoardList(Criteria cri);
	public CourseDto courseDetail(int c_no) throws Exception;
	public int inputCourse(CourseDto dto) throws Exception;
	public int modifyCourse(CourseDto dto) throws Exception;
	public void deleteCourse(int c_no);
	//public int courseCount(String c_count) throws Exception;
	
	public List<TeacherDto> teacherList();
	public int inputTeacher(TeacherDto dto);
	public int modifyTeacher(TeacherDto dto);
	public int deleteTeacher(int t_no);
	
	public List<MemberDto> memberList();
	public int deleteMember(int user_no);
	
	public List<Map<String, Object>> appList(PageDto dto, Criteria cri);
	public int getAppTotal(String param);
	public ApplicationDto appDetail(int app_no) throws Exception;*/
}

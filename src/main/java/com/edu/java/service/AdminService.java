package com.edu.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.java.dao.AdminDao;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.QnaDto;

@Service
public class AdminService {
	
	@Autowired
	AdminDao adminDao;
	
	public int userCount() {
		return adminDao.userCount();
	}
	
	public int newUserCount() {
		return adminDao.newUserCount();
	}
	
	public int cancelCount() {
		return adminDao.cancelCount();
	}
	
	public int newCancelCount() {
		return adminDao.newCancelCount();
	}
	
	public int ReviewCount() {
		return adminDao.ReviewCount();
	}
	
	public int newReviewCount() {
		return adminDao.newReviewCount();
	}
	
	public List<NoticeDto> getNotice(){
		return adminDao.getNotice();
	}
	
	public NoticeDto selectNotice(int seq) {
		return adminDao.selectNotice(seq);
	}
	
	public int inputNotice(NoticeDto dto) {
		return adminDao.inputNotice(dto);
	}
	
	public int modifyNotice(NoticeDto dto) {
		return adminDao.modifyNotice(dto);
	}
	
	public int deleteNotice(int seq) {
		return adminDao.deleteNotice(seq);
	}
	
	public List<QnaDto> getQna(){
		return adminDao.getQna();
	}
	
	/*public QnaDto selectQna(int q_no);
	public int deleteQna(int q_no);
	
	public List<FaqDto> getFaq();
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

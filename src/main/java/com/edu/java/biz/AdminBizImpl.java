package com.edu.java.biz;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.edu.java.dao.AdminDao;
import com.edu.java.dao.CourseDao;
import com.edu.java.dao.MemberDao;
import com.edu.java.dto.ApplicationDto;
import com.edu.java.dto.CourseDto;
import com.edu.java.dto.Criteria;
import com.edu.java.dto.FaqDto;
import com.edu.java.dto.MemberDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.PageDto;
import com.edu.java.dto.QnaDto;
import com.edu.java.dto.TeacherDto;

@Service
public class AdminBizImpl implements AdminBiz{

	@Inject
	AdminDao adminDao;
	CourseDao courseDao;
	MemberDao memberDao;
	
	/* 관리자 메인*/
	@Override
	public int userCount() {
		return adminDao.userCount();
	}

	@Override
	public int newUserCount() {
		return adminDao.newUserCount();
	}

	@Override
	public int cancleCount() {
		return adminDao.cancleCount();
	}

	@Override
	public int newCancleCount() {
		return adminDao.newCancleCount();
	}

	@Override
	public int ReviewCount() {
		return adminDao.ReviewCount();
	}

	@Override
	public int newReviewCount() {
		return adminDao.newReviewCount();
	}

	@Override
	public List<NoticeDto> getNotice(){
		return adminDao.getNotice();
	}

	@Override
	public NoticeDto selectNotice(int noti_no) {
		return adminDao.selectNotice(noti_no);
	}

	@Override
	public int inputNotice(NoticeDto dto) {
		return adminDao.inputNotice(dto);
	}

	@Override
	public int modifyNotice(NoticeDto dto) {
		return adminDao.modifyNotice(dto);
	}

	@Override
	public int deleteNotice(int noti_no) {
		return adminDao.deleteNotice(noti_no);
	}
	
	@Override
	public List<QnaDto> getQna() {
		return adminDao.getQna();
	}
	
	/*@Override
	public QnaDto qnaDetail(int q_no) {
		return adminDao.qnaDetail(q_no);
	}

	@Override
	public int deleteQna(int q_no) {
		return adminDao.deleteQna(q_no);
	}
	
	@Override
	public List<FaqDto> getFaq() {
		return adminDao.getFaq();
	}
	
	@Override
	public FaqDto faqDetail(int faq_no) {
		return adminDao.faqDetail(faq_no);
	}

	@Override
	public int inputFaq(FaqDto dto) {
		return adminDao.inputFaq(dto);
	}

	@Override
	public int modifyFaq(FaqDto dto) {
		return adminDao.modifyFaq(dto);
	}

	@Override
	public int deleteFaq(int faq_no) {
		return adminDao.deleteFaq(faq_no);
	}
	
	@Override
	public List<FaqDto> hashTagSearch(String faq_category){
		return adminDao.hashTagSearch(faq_category);
	}

	@Override
	public List<Map<String, Object>> courseList(PageDto dto, Criteria cri) {
		return adminDao.courseList(dto, cri);
	}
	
	public int getTotalCount(String param) { 
		return adminDao.getTotalCount(param);
	}

	@Override
	public CourseDto courseDetail(int c_no) throws Exception{
		return adminDao.courseDetail(c_no);
	}

	@Override
	public int inputCourse(CourseDto dto) throws Exception{
		return adminDao.inputCourse(dto);
	}

	@Override
	public int modifyCourse(CourseDto dto) throws Exception {
		return adminDao.modifyCourse(dto);
	}

	@Override
	public void deleteCourse(int c_no) {
		adminDao.deleteCourse(c_no);
	}
	
	@Override
	public int adminCourseCount(String c_count) throws Exception{
		return adminDao.adminCourseCount(c_count);
	}

	@Override
	public List<TeacherDto> teacherList(){
		return adminDao.teacherList();
	}
	
	@Override
	public int inputTeacher(TeacherDto dto) {
		return adminDao.inputTeacher(dto);
	}
	
	@Override
	public int modifyTeacher(TeacherDto dto) {
		return adminDao.modifyTeacher(dto);
	}
	
	@Override
	public int deleteTeacher(int t_no) {
		return adminDao.deleteTeacher(t_no);
	}
	
	@Override
	public List<MemberDto> memberList(){
		return adminDao.memberList();
	}
	
	@Override
	public int deleteMember(int user_no) {
		return adminDao.deleteMember(user_no);
	}
	
	@Override
	public List<Map<String, Object>> appList(PageDto dto, Criteria cri) {
		return adminDao.appList(dto, cri);
	}
	
	@Override
	public int getAppTotal(String param) {
		return adminDao.getAppTotal(param);
	}
	
	@Override
	public ApplicationDto appDetail(int app_no) throws Exception{
		return adminDao.appDetail(app_no);
	}*/
}

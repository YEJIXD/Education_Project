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

	/* 공지사항 */
	@Override
	public List<NoticeDto> noticeList(){
		return adminDao.noticeList();
	}

	@Override
	public NoticeDto noticeDetail(int noti_no) {
		return adminDao.noticeDetail(noti_no);
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
	

	/* Q n A */
	@Override
	public List<QnaDto> qnaList() {
		return adminDao.qnaList();
	}
	
	@Override
	public QnaDto qnaDetail(int q_no) {
		return adminDao.qnaDetail(q_no);
	}

	@Override
	public int deleteQna(int q_no) {
		return adminDao.deleteQna(q_no);
	}
	
	
	/* F A Q */
	@Override
	public List<FaqDto> faqList() {
		return adminDao.faqList();
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

	
	/* Course */
	@Override
	public List<Map<String, Object>> courseList(PageDto dto, Criteria cri) {
		return adminDao.courseList(dto, cri);
	}
	
	// 게시물 총 갯수
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
	
	/*@Override
	public int adminCourseCount(String c_count) throws Exception{
		return adminDao.adminCourseCount(c_count);
	}*/

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
	
	/* Application */
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
	}
	
}

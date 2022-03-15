package com.edu.java.biz;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.edu.java.dao.AdminDao;
import com.edu.java.dao.CourseDao;
import com.edu.java.dao.MemberDao;
import com.edu.java.dto.CancleDto;
import com.edu.java.dto.CourseDto;
import com.edu.java.dto.FaqDto;
import com.edu.java.dto.MemberDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.QnaDto;
import com.edu.java.dto.ReviewDto;
import com.edu.java.dto.TeacherDto;

@Service
public class AdminBizImpl implements AdminBiz{

	@Inject
	AdminDao adminDao;
	CourseDao courseDao;
	MemberDao memberDao;
	
	/* 관리자 메인*/
	@Override
	public int adminUserCount() {
		return adminDao.adminUserCount();
	}

	@Override
	public int newAdminUserCount() {
		return adminDao.newAdminUserCount();
	}

	@Override
	public int adminCancleCount() {
		return adminDao.adminCancleCount();
	}

	@Override
	public int newAdminCancleCount() {
		return adminDao.newAdminCancleCount();
	}

	@Override
	public int adminReviewCount() {
		return adminDao.adminReviewCount();
	}

	@Override
	public int newAdminReviewCount() {
		return adminDao.newAdminReviewCount();
	}

	/* 공지사항 */
	@Override
	public List<NoticeDto> adminNoticeList() throws Exception{
		return adminDao.adminNoticeList();
	}

	@Override
	public NoticeDto noticeSelectOne(int noti_no) {
		return adminDao.noticeSelectOne(noti_no);
	}

	@Override
	public int adminNoticeInsert(NoticeDto dto) {
		return adminDao.adminNoticeInsert(dto);
	}

	@Override
	public int adminNoticeUpdate(NoticeDto dto) {
		return adminDao.adminNoticeUpdate(dto);
	}

	@Override
	public int adminNoticeDelete(int noti_no) {
		return adminDao.adminNoticeDelete(noti_no);
	}
	

	/* Q n A */
	@Override
	public List<QnaDto> adminQnaList() {
		return adminDao.adminQnaList();
	}
	
	@Override
	public QnaDto qnaSelectOne(int q_no) {
		return adminDao.qnaSelectOne(q_no);
	}

	@Override
	public int adminQnaDelete(int q_no) {
		return adminDao.adminQnaDelete(q_no);
	}
	
	
	/* F A Q */
	@Override
	public List<FaqDto> adminFaqList() {
		return adminDao.adminFaqList();
	}
	
	@Override
	public FaqDto faqSelectOne(int faq_no) {
		return adminDao.faqSelectOne(faq_no);
	}

	@Override
	public int adminFaqInsert(FaqDto dto) {
		return adminDao.adminFaqInsert(dto);
	}

	@Override
	public int adminFaqUpdate(FaqDto dto) {
		return adminDao.adminFaqUpdate(dto);
	}

	@Override
	public int adminFaqDelete(int faq_no) {
		return adminDao.adminFaqDelete(faq_no);
	}
	
	@Override
	public List<FaqDto> hashTagSearch(String faq_category){
		return adminDao.hashTagSearch(faq_category);
	}

	
	/* Course */
	@Override
	public List<CourseDto> adminCourseList() {
		return adminDao.adminCourseList();
	}
	
	@Override
	public CourseDto courseSelectOne(int c_no) {
		return adminDao.courseSelectOne(c_no);
	}

	@Override
	public int adminCourseInsert(CourseDto dto) {
		return adminDao.adminCourseInsert(dto);
	}

	@Override
	public int adminCourseUpdate(CourseDto dto) {
		return adminDao.adminCourseUpdate(dto);
	}

	@Override
	public int adminCourseDelete(int c_no) {
		return adminDao.adminCourseDelete(c_no);
	}

	/* Teacher */
	@Override
	public List<TeacherDto> adminTeacherList(){
		return adminDao.adminTeacherList();
	}
	
	@Override
	public int adminTeacherInsert(TeacherDto dto) {
		return adminDao.adminTeacherInsert(dto);
	}
	
	@Override
	public int adminTeacherUpdate(TeacherDto dto) {
		return adminDao.adminTeacherUpdate(dto);
	}
	
	@Override
	public int adminTeacherDelete(int t_no) {
		return adminDao.adminTeacherDelete(t_no);
	}
	
	/* Member */
	@Override
	public List<MemberDto> adminMemberList(){
		return adminDao.adminMemberList();
	}
	
	@Override
	public int adminMemberDelete(int user_no) {
		return adminDao.adminMemberDelete(user_no);
	}
	
	/* Cancle */
	@Override
	public List<CancleDto> adminCancleList(){
		return adminDao.adminCancleList();
	}
	
	@Override
	public CancleDto cancleSelectOne(int cancle_no) {
		return adminDao.cancleSelectOne(cancle_no);
	}
	
	@Override
	public int adminCancleDelete(int cancle_no) {
		return adminDao.adminCancleDelete(cancle_no);
	}

	
	/* Review */
	@Override
	public List<ReviewDto> adminReviewList() {
		return adminDao.adminReviewList();
	}
	
	@Override
	public ReviewDto reviewSelectOne(int r_no) {
		return adminDao.reviewSelectOne(r_no);
	}

	@Override
	public int adminReviewDelete(int r_no) {
		return adminDao.adminReviewDelete(r_no);
	}

	
}
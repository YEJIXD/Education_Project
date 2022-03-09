package com.edu.java.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.java.dao.AdminDao;
import com.edu.java.dao.CourseDao;
import com.edu.java.dao.MemberDao;
import com.edu.java.dto.ApplicationDto;
import com.edu.java.dto.CourseDto;
import com.edu.java.dto.FaqDto;
import com.edu.java.dto.NoticeDto;
import com.edu.java.dto.QnaDto;
import com.edu.java.dto.ReviewDto;

@Service
public class AdminBizImpl implements AdminBiz{

	@Autowired
	AdminDao adminDao;
	CourseDao courseDao;
	MemberDao memberDao;
	
	
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

	@Override
	public List<NoticeDto> adminNoticeList() {
		return adminDao.adminNoticeList();
	}

	/*@Override
	public NoticeDto selectOne(int noti_no) {
		return adminDao.selectOne(noti_no);
	}*/

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

	@Override
	public List<FaqDto> adminFaqList() {
		return adminDao.adminFaqList();
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

	@Override
	public List<QnaDto> adminQnaList() {
		return adminDao.adminQnaList();
	}

	@Override
	public int adminQnaDelete(int q_no) {
		return adminDao.adminQnaDelete(q_no);
	}

	@Override
	public List<CourseDto> adminCourseList() {
		return adminDao.adminCourseList();
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

	@Override
	public List<ApplicationDto> adminCancleList() {
		return adminDao.adminCancleList();
	}

	@Override
	public int adminCancleDelete(int cancle_no) {
		return adminDao.adminCancleDelete(cancle_no);
	}

	@Override
	public List<ReviewDto> adminReviewList() {
		return adminDao.adminReviewList();
	}

	@Override
	public int adminReviewDelete(int r_no) {
		return adminDao.adminReviewDelete(r_no);
	}

	
}

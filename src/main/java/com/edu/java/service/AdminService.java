package com.edu.java.service;

import java.util.List;
import java.util.Map;

import com.edu.java.dto.*;
import com.edu.java.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.java.dao.AdminDao;

@Service
public class AdminService implements AdminMapper {
	
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
	
	public int reviewCount() {
		return adminDao.reviewCount();
	}
	
	public int newReviewCount() {
		return adminDao.newReviewCount();
	}
	
	public List<NoticeDto> noticeList(){
		return adminDao.noticeList();
	}
	
	public NoticeDto selectNotice(int seq) {
		return adminDao.selectNotice(seq);
	}
	
	public void inputNotice(NoticeDto dto) {
		adminDao.inputNotice(dto);
	}
	
	public void modifyNotice(NoticeDto dto) {
		adminDao.modifyNotice(dto);
	}
	
	public void deleteNotice(int seq) {
		adminDao.deleteNotice(seq);
	}
	
	public List<QnaDto> qnaList(){
		return adminDao.qnaList();
	}

	public QnaDto selectQna(int q_no) {
		return adminDao.selectQna(q_no);
	}

	public void deleteQna(int q_no){
		adminDao.deleteQna(q_no);
	};
	
	public List<FaqDto> faqList(){
		return adminDao.faqList();
	}

	public FaqDto selectFaq(int faq_no) {
		return adminDao.selectFaq(faq_no);
	}

	public void inputFaq(FaqDto dto){
		adminDao.inputFaq(dto);
	}

	public void modifyFaq(FaqDto dto){
		adminDao.modifyFaq(dto);
	}

	public void deleteFaq(int faq_no){
		adminDao.deleteFaq(faq_no);
	}

	public List<FaqDto> hashTagSearch(String faq_category){
		return adminDao.hashTagSearch(faq_category);
	}

	public List<Map<String, Object>> courseList(PageDto dto, Criteria cri){
		return adminDao.courseList(dto, cri);
	}

	public int getTotal(String param){
		return adminDao.getTotal(param);
	}

	public CourseDto selectCourse(int c_no) {
		try {
			return adminDao.selectCourse(c_no);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void inputCourse(CourseDto dto){
		try {
			adminDao.inputCourse(dto);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void modifyCourse(CourseDto dto) {
		try {
			adminDao.modifyCourse(dto);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void deleteCourse(int c_no){
		adminDao.deleteCourse(c_no);
	}
	//public int courseCount(String c_count) throws Exception;
	
	public List<TeacherDto> teacherList(){
		return adminDao.teacherList();
	}
	public void inputTeacher(TeacherDto dto){
		adminDao.inputTeacher(dto);
	}
	public void modifyTeacher(TeacherDto dto){
		adminDao.modifyTeacher(dto);
	}

	public void deleteTeacher(int t_no){
		adminDao.deleteTeacher(t_no);
	}
	
	public List<UserDto> userList(){
		return adminDao.userList();
	}

	public void deleteUser(int user_no){
		adminDao.deleteUser(user_no);
	}
}

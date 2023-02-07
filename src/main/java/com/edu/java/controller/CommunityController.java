package com.edu.java.controller;

import com.edu.java.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommunityController {

    @Autowired
    CommunityService communityService;

    @RequestMapping(value="/community/notice", method= RequestMethod.GET)
    public ModelAndView noticeList() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("/community/notice");
        mav.addObject("list", communityService.noticeList());

        return mav;
    }

    @RequestMapping(value = "/community/noticeDetail", method=RequestMethod.GET)
    public ModelAndView noticeDetail() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/community/noticeDetail");

        return mav;
    }

    @RequestMapping(value="/community/noticeDetail", method=RequestMethod.POST)
    public ModelAndView noticeDetailPost(@RequestParam int notice_seq) {
        ModelAndView mav = new ModelAndView("jsonView");
        System.out.println("notice_Seq :::: " + notice_seq);
        mav.addObject("list", communityService.noticeDetail(notice_seq));

        return mav;
    }

    @RequestMapping(value="/community/faq", method=RequestMethod.GET)
    public ModelAndView faq() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/community/faq");
        return mav;
    }

    @RequestMapping(value="/community/faq", method=RequestMethod.POST)
    public ModelAndView faqList() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("list", communityService.faq());

        return mav;
    }

    @RequestMapping(value="/community/qna", method=RequestMethod.GET)
    public ModelAndView qna() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/user/community/qna");

        return mav;
    }

    @RequestMapping(value="/community/qna", method=RequestMethod.POST)
    public ModelAndView qnaList() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("list", communityService.qna());

        return mav;
    }

    @RequestMapping("/qnaDetail")
    public String qnaDetail() {
        return "/community/qnaDetail";
    }
}
package com.tgt.redallure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("friends.do")
public class FriendController {

	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView getFriends() {
	
        ModelAndView mv=new ModelAndView("friendsList");
        
//      mv.addObject("storeId", storeId);
//        mv.addObject("deptName", deptName);
        return mv;
	}

}

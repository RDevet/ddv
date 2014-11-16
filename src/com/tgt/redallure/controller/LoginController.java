package com.tgt.redallure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("login.do")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView getDepts(@RequestParam("emailId") String emailId, @RequestParam("pwd") String pwd) {
	
        ModelAndView mv=new ModelAndView("LoginSuccess");
        mv.addObject("storeId", 1375);
      	mv.addObject("itemList", "electronics");
        
//      mv.addObject("storeId", storeId);
//        mv.addObject("deptName", deptName);
        return mv;
	}

}

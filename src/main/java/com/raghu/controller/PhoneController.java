package com.raghu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.raghu.model.Phone;
import com.raghu.model.User;
import com.raghu.service.PhoneManager;

@Controller
@RequestMapping("/Phone")
public class PhoneController {
	
	@Autowired
    PhoneManager manager;
	
	/**
     * Method will be called in initial page load at GET /User
     * */
    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(Model model) 
    {
        Phone phoneVO = new Phone();
        model.addAttribute("phone", phoneVO);
        return "phoneView";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String submitUser(@ModelAttribute("phone") Phone phone) 
    {
    	
        System.out.println(phone);
        manager.addPhone(phone);
        return "redirect:Phone";
    }
    @RequestMapping(value="/{phoneId}",method=RequestMethod.GET)
    public 	String getPhoneAsHtml(@PathVariable int phoneId,Model model) throws Exception{
    	//System.out.println(userId);
    	Phone phone=manager.findPhone(phoneId);
    	if(phone==null){
    		return "noPhoneExists";
    	}
    	model.addAttribute(phone);
    	return "phoneViewForUpdateNDelete";
    }
    @RequestMapping(value="/{phoneId}",method=RequestMethod.POST)
    public 	String updateUser(@ModelAttribute("phone") Phone phone,Model model) throws Exception{
    	System.out.println("in update");
    	phone=manager.updatePhone(phone);
    	model.addAttribute(phone);
    	return "phoneViewForUpdateNDelete";
    }
    @RequestMapping(value="/{phoneId}",method=RequestMethod.DELETE)
    public String deletePhone(@ModelAttribute("phone") Phone phone){
    	System.out.println("in delete");
    	if(manager.deletePhone(phone)){
    		return "redirect:";
    	}
    	return "redirect:";
    }
    @RequestMapping(value="/{phoneId}",params="json",headers="Accept=*/*", produces="application/json",method=RequestMethod.GET)
    public @ResponseBody String userAsJSON(@PathVariable int phoneId) throws Exception{
    	System.out.println("in get User Json");
    	Phone phone=manager.findPhone(phoneId);
    	ObjectWriter ow=new ObjectMapper().writer().withDefaultPrettyPrinter();
    	String json=ow.writeValueAsString(phone);
    	System.out.println(phone);
    	return json;
    }

}

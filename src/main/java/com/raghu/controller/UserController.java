package com.raghu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.raghu.model.User;
import com.raghu.service.UserManager;

@Controller
@RequestMapping("/User")


public class UserController {
	 
	@Autowired
    UserManager manager;
	
	/**
     * Method will be called in initial page load at GET /User
     * */
    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(Model model) 
    {
        User userVO = new User();
        model.addAttribute("user", userVO);
        return "userView";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String submitUser(@ModelAttribute("user") User user) 
    {
        if(manager.addUser(user)==false)
        {
        return "noUserExists";	
        }
        else{
        return "redirect:User";
        }
    }
    @RequestMapping(value="/{userId}",method=RequestMethod.DELETE)
    public String deleteUser(@ModelAttribute("user") User user){
    	System.out.println("in delete");
    	if(manager.deleteUser(user)){
    		return "redirect:/User";
    	}
    	return "redirect:/User";
    }
    @RequestMapping(value="/{userId}",params="json",headers="Accept=*/*", produces="application/json",method=RequestMethod.GET)
    public @ResponseBody String userAsJSON(@PathVariable int userId) throws Exception{
    	System.out.println("in get User Json");
    	User user=manager.findUser(userId);
    	ObjectWriter ow=new ObjectMapper().writer().withDefaultPrettyPrinter();
    	String json=ow.writeValueAsString(user);
    	System.out.println(user);
    	return json;
    }
    @RequestMapping(value="/{userId}",method=RequestMethod.GET)
    public 	String getUserAsHtml(@PathVariable int userId,Model model) throws Exception{
    	//System.out.println(userId);
    	User user=manager.findUser(userId);
    	if(user==null){
    		return "noUserExists";
    	}
    	model.addAttribute(user);
    	return "userViewForUpdateNDelete";
    }
    @RequestMapping(value="/{userId}",method=RequestMethod.POST)
    public 	String updateUser(@ModelAttribute("user") User user,Model model) throws Exception{
    	System.out.println("in update");
    	user=manager.updateUser(user);
    	model.addAttribute(user);
    	return "userViewForUpdateNDelete";
    }
}

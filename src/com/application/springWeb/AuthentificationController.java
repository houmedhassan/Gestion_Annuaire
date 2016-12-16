package com.application.springWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.application.beans.Person;
import com.application.metier.AuthentificationValidator;

@Controller("/authentification")
public class AuthentificationController {

		@Autowired 
		AuthentificationValidator validator;
		
		@RequestMapping(value="/home", method=RequestMethod.GET)
		public String loginPage(){
			return "accueil";
		}
		
		@RequestMapping(value="/listofGroup", method=RequestMethod.POST)
		public String loginVerify( 	@ModelAttribute(value="loginPers") Person person, BindingResult result,ModelMap modelMap,
											@RequestParam String mail, @RequestParam String password){
			validator.validate(person, result);
			if(result.hasErrors()){
					return "accueil";
			}
			
			validator.login(mail, password,person, result);
			
			if(result.hasErrors()){
				return "accueil";
			}
			
			return "listofGroup";
		}
	
}

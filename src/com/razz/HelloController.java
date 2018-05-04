package com.razz;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//class level request mapping to remove conflicts  
@RequestMapping("/greet")
public class HelloController {
	
	@RequestMapping("/welcome/{countryName}/{username}")
	//@Pathvariable used to enter manual URL
	public  ModelAndView helloworld(@PathVariable("username") String name,
			@PathVariable("countryName") String countryName) {
		
		ModelAndView model= new ModelAndView("HelloPage");
		model.addObject("msg","hello " +name+""+"you are from "+countryName);
		return model;
		
	}
	
	//multiaction controller class
	
	@RequestMapping("/{stateName}/{username}")
	//PathVariable using Map in the method argument
	//instead of using more than one @pathvarible we can use @PathVariable with Map
	public ModelAndView hiworld(@PathVariable Map<String,String> m )
	{
		String username=m.get("username");
		String stateName=m.get("stateName");
		
		ModelAndView model= new ModelAndView("HelloPage");
		model.addObject("msg","Hi "+username+"You belong to state "+stateName);
		return model;
	}

}

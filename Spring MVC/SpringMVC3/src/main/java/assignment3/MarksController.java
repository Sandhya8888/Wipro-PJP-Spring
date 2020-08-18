package assignment3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MarksController {
	@RequestMapping(value="/marks", method = RequestMethod.GET)
	public ModelAndView marks() {
		return new ModelAndView("marks","command",new Marks());
		
	}
	@GetMapping(value="/result")
	public String getMarks(@ModelAttribute("getMarks")Marks m,ModelMap model) {
		int total=m.getScienceMarks()+m.getMathsMarks()+m.getEnglishMarks();
		model.addAttribute("science",m.getScienceMarks());
		model.addAttribute("maths",m.getMathsMarks());
		model.addAttribute("english",m.getEnglishMarks());
		model.addAttribute("total",total);
		return "result";
	}
	

}

package assignment1;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import bean.Student;

@Controller
public class StudentController {
	private InsertData d;
	@Autowired
	public void getInsertData(InsertData d2) {
		this.d=d2;
	}
	
	@RequestMapping(value="/Form", method = RequestMethod.GET)
	public ModelAndView f() {
		return new ModelAndView("Form","command",new Student());
	}
	@RequestMapping(value="/re", method = RequestMethod.POST)
	public String getMarks(@ModelAttribute("command")Student s,ModelMap model) {
		boolean p = d.insertData(s);
		ArrayList<Student> a=new ArrayList<Student>();
		a.add(s);
		if(p) {
			String m="Inserted successfully";
			model.addAttribute("list",a);
			model.addAttribute("msg",m);
		}
		else {
			String m="Already a student exists with same id. So insertion failed";
			model.addAttribute("msg",m);
		}
		return "result";
		
	}
}

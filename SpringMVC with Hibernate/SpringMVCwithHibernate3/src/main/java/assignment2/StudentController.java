package assignment2;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import bean.Student;

@Controller
public class StudentController {
	private GetData d;
	@Autowired
	public void getGetData(GetData d2) {
		this.d=d2;
	}
	@RequestMapping(value="/re")
	public String getMarks(@ModelAttribute("command")Student s,ModelMap model) {
		ArrayList<Student> a=new ArrayList<Student>();
		a=(ArrayList<Student>) d.getList(s);
		if(a.isEmpty()) {
			String m="There is no student data in the table";
			model.addAttribute("list",a);
			model.addAttribute("msg",m);
		}
		else {
			String m="The details of the students: ";
			model.addAttribute("list",a);
			model.addAttribute("msg",m);
		}
		
		return "result";
		
	}
	

}

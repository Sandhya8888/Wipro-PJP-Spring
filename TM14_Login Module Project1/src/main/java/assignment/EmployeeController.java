package assignment;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import bean.Employee;
import bean.User;

@Controller
public class EmployeeController {
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }	
	private InsertEmployee d;
	private UserValidation v;
	private GetName n;
	@Autowired
	public void getInsertEmployee(InsertEmployee d2) {
		this.d=d2;
	}
	@Autowired
	public void UserValidation(UserValidation v) {
		this.v=v;
	}
	@Autowired
	public void GetName(GetName n) {
		this.n=n;
	}
	
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String H(@ModelAttribute("Employee")Employee e,@ModelAttribute("User")User u,ModelMap model) {
		return "Home";
	}
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String R(@ModelAttribute("Employee")Employee e,@ModelAttribute("User")User u,ModelMap model) {
		return "Register";
	}
	@RequestMapping(value="/add")
	public String A(@Valid @ModelAttribute("Employee")Employee e,BindingResult b,@ModelAttribute("User")User u,ModelMap model) {
		if(b.hasErrors()) {
			return "Register";
		}
		else {
			String p = d.insertEmployee(e, u);
			ArrayList<Employee> a1=new ArrayList<Employee>();
			a1.add(e);
			ArrayList<User> a2=new ArrayList<User>();
			a2.add(u);
			if(p.equals("ok")) {
				String m="Inserted successfully";
				model.addAttribute("list",a1);
				model.addAttribute("user",a2);
				model.addAttribute("msg",m);
			}
			else {
				model.addAttribute("msg",p);
			}
			return "Add";
		}
		
	}
	
	@RequestMapping(value="/login")
	public String f(@ModelAttribute("Employee")Employee e,@ModelAttribute("User")User u,ModelMap model) {
		model.addAttribute("User",new User());
		return "Login";
	}
	
	@RequestMapping(value="/loginCheck")
	public String C(@ModelAttribute("Employee")Employee e,@ModelAttribute("User")User u,ModelMap model) {
		String s=v.checkUser(u);
		if(s.equals("ok")) {
			String h=n.getName(u);
			model.addAttribute("name",h);
			return "Welcome";
		}
		else {
			model.addAttribute("error",s);
			return "Login";
		}
	}

}

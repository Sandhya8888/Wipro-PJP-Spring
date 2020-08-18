package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bean.Employee;
import bean.User;

@Controller
public class EmployeeController {
	private InsertEmployee d;
	private UserValidation v;
	private GetName n;
	private DeleteEmployee d1;
	private DeleteEmployee2 d2;
	private Modify m;
	private AllEmployees a;
	@Autowired
	public void getInsertEmployee(InsertEmployee d) {
		this.d=d;
	}
	@Autowired
	public void UserValidation(UserValidation v) {
		this.v=v;
	}
	@Autowired
	public void Modify(Modify m) {
		this.m=m;
	}
	@Autowired
	public void DeleteEmployee(DeleteEmployee d1) {
		this.d1=d1;
	}
	@Autowired
	public void DeleteEmployee2(DeleteEmployee2 d2) {
		this.d2=d2;
	}
	@Autowired
	public void GetName(GetName n) {
		this.n=n;
	}
	@Autowired
	public void AllEmployees(AllEmployees a) {
		this.a=a;
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
	public String A(@ModelAttribute("Employee")@Valid Employee e,BindingResult b,@ModelAttribute("User")User u,ModelMap model) {
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
	
	@RequestMapping(value="/delete")
	public String D(@ModelAttribute("Employee")Employee e,@ModelAttribute("User")User u,ModelMap model) {
		model.addAttribute("Employee", new Employee());
		return "Delete";
		
	}
	
	@RequestMapping(value="/deleteEmp")
	public String D1(@ModelAttribute("Employee")Employee e,@ModelAttribute("User")User u,ModelMap model) {
		List<Employee> list=d1.getEmployee(e, u);
		if(list.isEmpty()) {
			String msg="No employee exists with that id";
			model.addAttribute("msg",msg);
			return "Delete";
		}
		else {
			model.addAttribute("Employee", new Employee());
			model.addAttribute("list", list);
			return "Delete2";
		}
		
	}
	@RequestMapping(value="/deleteEmp2")
	public String D2(@RequestParam("id") String id,@ModelAttribute("Employee")Employee e,@ModelAttribute("User")User u,ModelMap model) {
		String s=d2.deleteEmployee(id, e);
		return s;
		
	}
	@RequestMapping(value="/modify")
	public String M(@ModelAttribute("Employee")Employee e,@ModelAttribute("User")User u,ModelMap model) {
		model.addAttribute("Employee", new Employee());
		return "Modify";
		
	}
	@RequestMapping(value="/edit")
	public String M1(@ModelAttribute("Employee")Employee e,@ModelAttribute("User")User u,ModelMap model) {
		List<Employee> list=d1.getEmployee(e, u);
		if(list.isEmpty()) {
			String msg="No employee exists with that id";
			model.addAttribute("msg",msg);
			return "Modify";
		}
		else {
			model.addAttribute("Employee", new Employee());
			model.addAttribute("list", list);
			return "Edit";
		}
		
	}
	@RequestMapping(value="/update")
	public String M2(@RequestParam Map<?,?> r,@ModelAttribute("Employee")Employee e,@ModelAttribute("User")User u,ModelMap model) {
		String id=(String) r.get("id");
		String p=m.updateEmployee(id,e, r);
		model.addAttribute("msg",p);
		List<Employee> list=d1.getEmployee(e, u);
		model.addAttribute("list", list);
		return "Add";
		
	}
	@RequestMapping(value="/select")
	public String S(@ModelAttribute("Employee")Employee e,@ModelAttribute("User")User u,ModelMap model) {
		model.addAttribute("Employee", new Employee());
		return "Select";
		
	}
	@RequestMapping(value="/getEmp")
	public String S1(@ModelAttribute("Employee")Employee e,@ModelAttribute("User")User u,ModelMap model) {
		List<Employee> list=d1.getEmployee(e, u);
		if(list.isEmpty()) {
			String msg="No employee exists with that id";
			model.addAttribute("msg",msg);
			return "Select";
		}
		else {
			String msg="The employee details are:";
			model.addAttribute("msg",msg);
			model.addAttribute("list", list);
			return "Add";
		}
		
	}
	@RequestMapping(value="/all")
	public String A1(@ModelAttribute("Employee")Employee e,@ModelAttribute("User")User u,ModelMap model) {
		List<Employee> list=a.getAllEmployees();
		if(list.isEmpty()) {
			String msg="No employee data inserted";
			model.addAttribute("msg",msg);
		}
		else {
			String msg="The employee details are:";
			model.addAttribute("msg",msg);
			model.addAttribute("list", list);
		}
		return "Add";
	}
	

}

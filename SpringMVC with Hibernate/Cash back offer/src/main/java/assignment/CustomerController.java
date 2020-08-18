package assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Coupon;
import bean.Customer;

@Controller

public class CustomerController {
	private LoginValidation l;
	private GetBalance v;
	private UpdateBalance u1;
	private CouponValidation m;
	@Autowired
	public void getInsertData(LoginValidation l) {
		this.l=l;
	}
	@Autowired
	public void GetBalance(GetBalance v) {
		this.v=v;
	}
	@Autowired
	public void UpdateBalance(UpdateBalance u1) {
		this.u1=u1;
	}
	@Autowired
	public void CouponValidation(CouponValidation m) {
		this.m=m;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView f(@ModelAttribute("Customer")Customer c,ModelMap model) {
		model.addAttribute("Customer", new Customer());
	return new ModelAndView("Login","command",new Customer());
	}
	
	@RequestMapping(value="/loginCheck")
	public ModelAndView getMarks(@ModelAttribute("Customer")Customer c,ModelMap model) {
		String s=l.check(c);
		if(s.equals("ok")) {
			int b=v.Balance(c);
			String h=c.getCustomerID();
			model.addAttribute("balance",b);
			model.addAttribute("id",h);
			return new ModelAndView("Coupon","command",c);
		}
		else {
			model.addAttribute("error",s);
			return new ModelAndView("Login","command",new Customer());
		}
	}
	
	@RequestMapping(value="/validCoupon")
	public ModelAndView getUpdate(@RequestParam("id") String id,@ModelAttribute("Coupon")Coupon p,ModelMap model) {
		int x=m.checkCoupon(p);
		if(x==-1) {
			model.addAttribute("error","Invalid Coupon Code");
			return new ModelAndView("Coupon","command",new Coupon());
		}
		else {
			int z=u1.uBalance(id, p);
			model.addAttribute("ubal",z);
			model.addAttribute("cash", x);
			return new ModelAndView("Update","command",new Coupon());
		}
		
	}
}

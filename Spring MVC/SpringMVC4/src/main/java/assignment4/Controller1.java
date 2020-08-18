package assignment4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class Controller1 {
	@RequestMapping("/Movies")
	public ModelAndView printMovies() {
		ModelAndView m=new ModelAndView("Movies");
		List<String> namesList = Arrays.asList( "Bloodshot", "The invisible man", "Down hill","Little Women","The Turning",
				"Money heist","Dark","Breaking Bad","Stranger Things","Ozark");
        ArrayList<String> l = new ArrayList<>();
        l.addAll(namesList);  
		m.addObject("list",l);
		return m;
		
		
	}
}

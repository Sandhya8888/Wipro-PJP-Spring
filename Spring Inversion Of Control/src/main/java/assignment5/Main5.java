package assignment5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("deprecation")
public class Main5 {

	public static void main(String[] args) {
		Resource re=new FileSystemResource("src/main/resources/beans5.xml");
		BeanFactory b=new XmlBeanFactory(re);
		Player p1=(Player)b.getBean("p1");
		Player p2=(Player)b.getBean("p2");
		Player p3=(Player)b.getBean("p3");
		Player p4=(Player)b.getBean("p4");
		Player p5=(Player)b.getBean("p5");
		List<Player> l=Arrays.asList(p1,p2,p3,p4,p5);
		ArrayList<Player> p=new ArrayList<Player>();
		p.addAll(l);
		System.out.println("All players details:");
		System.out.println(p1+"\n"+p2+"\n"+p3+"\n"+p4+"\n"+p5+"\n");
		System.out.println();
		System.out.println("Players belonging to India");
		for(Player s:p) {
			String c=s.getCountry().getCountryName();
			if(c.equals("India")) {
				System.out.println(s);
			}
		}

	}

}

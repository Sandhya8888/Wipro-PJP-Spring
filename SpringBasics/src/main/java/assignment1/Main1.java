package assignment1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("deprecation")
public class Main1 {

	public static void main(String[] args) {
		Resource r=new FileSystemResource("src/main/resources/beans.xml");
		BeanFactory b=new XmlBeanFactory(r);
		Movie m=b.getBean(Movie.class);
		System.out.println(m);

	}

}

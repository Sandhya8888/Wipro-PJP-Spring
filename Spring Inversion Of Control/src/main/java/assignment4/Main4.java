package assignment4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("deprecation")
public class Main4 {

	public static void main(String[] args) {
		Resource re=new FileSystemResource("src/main/resources/beans4.xml");
		BeanFactory b=new XmlBeanFactory(re);
		Student s1=(Student)b.getBean("s1");
		Student s2=(Student)b.getBean("s2");
		System.out.println(s1);
		System.out.println(s2);

	}

}

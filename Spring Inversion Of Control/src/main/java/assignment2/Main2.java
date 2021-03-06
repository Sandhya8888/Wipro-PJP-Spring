package assignment2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


@SuppressWarnings("deprecation")
public class Main2 {

	public static void main(String[] args) {
		Resource re=new FileSystemResource("src/main/resources/beans2.xml");
		BeanFactory b=new XmlBeanFactory(re);
		ConstructorMessage m=(ConstructorMessage)b.getBean("c");
		System.out.println(m.getMessage());
	}

}

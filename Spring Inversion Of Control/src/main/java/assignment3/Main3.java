package assignment3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("deprecation")
public class Main3 {

	public static void main(String[] args) {
		Resource re=new FileSystemResource("src/main/resources/beans3.xml");
		BeanFactory b=new XmlBeanFactory(re);
		SetterMessage m=(SetterMessage)b.getBean("s");
		System.out.println(m.getMessage());

	}

}

package assignment1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("deprecation")
public class DrawShape {

	public static void main(String[] args) {
		Resource re=new FileSystemResource("src/main/resources/beans1.xml");
		BeanFactory b=new XmlBeanFactory(re);
		Shape r=(Shape)b.getBean("r");
		r.draw();
		Shape t=(Shape)b.getBean("t");
		t.draw();
		Shape p=(Shape)b.getBean("p");
		p.draw();

	}

}

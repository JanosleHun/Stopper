package hu.pallas.stopper;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	 public static void main(String[] args) {
		 
		 Resource resource= new ClassPathResource("applicationContext.xml");
		 BeanFactory factory = new XmlBeanFactory(resource);
			
		Main watch = (Main)factory.getBean("visible");
	    Stopwatch stopwatch = new Stopwatch();

	 }
	}
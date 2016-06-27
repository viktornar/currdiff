package lt.viktornar.currdiff.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class HelloWorld {
	public String getHello() {
		return "Hello from PrimeFaces and Tomcat Embedded server with some Spring components!";
	}
}

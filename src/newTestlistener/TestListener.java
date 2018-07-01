package newTestlistener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestListener implements ServletContextListener {
	public static int count=0;//记录session的数量
    public void contextDestroyed(ServletContextEvent sc)  { 
    	count--;
    	ServletContext application =sc.getServletContext();
    	application.setAttribute("Count", count);
         System.out.println("销毁");
    }

    public void contextInitialized(ServletContextEvent sc)  { 
    	count++;
    	ServletContext application =sc.getServletContext();
    	application.setAttribute("Count", count);
        System.out.println("开始");
        System.out.println(count);
    }
	
}

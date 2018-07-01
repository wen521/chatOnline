package newTestlistener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestListener implements ServletContextListener {
	public static int count=0;//��¼session������
    public void contextDestroyed(ServletContextEvent sc)  { 
    	count--;
    	ServletContext application =sc.getServletContext();
    	application.setAttribute("Count", count);
         System.out.println("����");
    }

    public void contextInitialized(ServletContextEvent sc)  { 
    	count++;
    	ServletContext application =sc.getServletContext();
    	application.setAttribute("Count", count);
        System.out.println("��ʼ");
        System.out.println(count);
    }
	
}

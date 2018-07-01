package newTestfilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xalan.internal.xsltc.dom.Filter;


public abstract class  CodeFilter implements Filter {

	 public void destroy() {
        System.out.println("destroy---CodeFilter");                          
    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
        System.out.println("start----doFilter--CodeFilter");

        HttpServletRequest request =(HttpServletRequest) arg0;
        HttpServletResponse response =(HttpServletResponse) arg1;
        //以上是强制内型转换，使用request对象和response对象
        
        request.setCharacterEncoding("utf-8");          //设置过滤页面提取数据的编码
        response.setContentType("text/html;charset=utf-8");  //设置过滤页面显示数据的编码
        
        arg2.doFilter(arg0, arg1);//在页面跳转之前执行此语句前面的代码，执行完页面的代码之后，在执行后面的语句
        System.out.println("第一个字符过滤器");
        System.out.println("end------doFilter--CodeFilter");    
        }

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init----CodeFilter");
    }

}

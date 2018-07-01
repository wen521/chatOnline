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
        //������ǿ������ת����ʹ��request�����response����
        
        request.setCharacterEncoding("utf-8");          //���ù���ҳ����ȡ���ݵı���
        response.setContentType("text/html;charset=utf-8");  //���ù���ҳ����ʾ���ݵı���
        
        arg2.doFilter(arg0, arg1);//��ҳ����ת֮ǰִ�д����ǰ��Ĵ��룬ִ����ҳ��Ĵ���֮����ִ�к�������
        System.out.println("��һ���ַ�������");
        System.out.println("end------doFilter--CodeFilter");    
        }

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init----CodeFilter");
    }

}

package newTest;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jspfold/login.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html;charset=utf-8"); 
        //�˳�ע������Ϊʹ��CodeFilter���������Servlet��ת������
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        String checkBox = request.getParameter("save_password");

        //System.out.println("userName:"+userName+"\n"+"passWord:"+passWord);
//        System.out.println(userName);
//        System.out.println(passWord);
        HttpSession session =request.getSession();
        session.setAttribute("nameSession", userName);
        String[] name_one = {"��ѩ��","����","����"};
        String[] pwd_one = {"12151207","002","003"};
        String name_two = "";
        String pwd_two = "";
        boolean login_test = false;
        for(int i=0;i<3;i++){
            name_two = name_one[i];
            pwd_two = pwd_one[i];
            if(userName.equals(name_two) && passWord.equals(pwd_two))
                login_test = true;                           
        }
        
        if(login_test) {
            if ("save".equals(checkBox)) {
                //Cookie��ȡʱ��URLEncoder.encode���б���(PS:��ȡʱURLDecoder.decode���н���)
                String name = URLEncoder.encode(userName,"UTF-8");
                //��������Cookie����
                Cookie nameCookie = new Cookie("username", name);
                //����Cookie����Ч��Ϊ3��
                nameCookie.setMaxAge(60 * 60 * 24 * 3);
                String pwd = URLEncoder.encode(passWord,"UTF-8");
                Cookie pwdCookie = new Cookie("password", pwd);
                pwdCookie.setMaxAge(60 * 60 * 24 * 3);
                response.addCookie(nameCookie);
                response.addCookie(pwdCookie);
             }
             request.getRequestDispatcher("/jspfold/welcome.jsp").forward(request, response);           
        }   
        else{
             response.sendRedirect(request.getContextPath()+"/jspfold/loginFail.jsp");      
             //request.getRequestDispatcher("loginFail.jsp").forward(request, response);             
        }
	}

}

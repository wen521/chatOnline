package newTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InputInformation")
public class InputInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//���������¼�������˴�Ϊȫ�ֱ���
	private String chat_record = ""; 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html;charset=utf-8"); 
        //�˳�ע������Ϊʹ��CodeFilter���������Servlet��ת������
        //request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
        String input_textarea = request.getParameter("input_textarea");
        response.setCharacterEncoding("utf-8");
        Date now = new Date();    //�������ڶ��󣬼�ϵͳ��ǰʱ��
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
        String time = dateFormat.format( now ); //���ո��������ڸ�ʽ��ȡϵͳ��ǰʱ��
        String t = (String)request.getSession().getAttribute("nameSession");  //��ȡ��½ҳ���û���
        chat_record += t+"  "+input_textarea+"  "+time+"\n";   //�����¼�洢
        request.setAttribute("input_textarea",chat_record); //����ǰ�����������ݴ洢
        request.getRequestDispatcher("/jspfold/main.jsp").forward(request,response);  //��ת����ǰ����������棬�����沼�ֲ���
	}

}

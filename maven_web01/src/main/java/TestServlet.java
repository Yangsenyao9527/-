import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*

 *@author:杨森垚
 *@version:
 *@Date:2022/9/21 15:04
 *@Package:
 *@Description:
 */
@WebServlet("/testservlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("测试 Maven Servlet");
        resp.sendRedirect("index.jsp");
    }

}

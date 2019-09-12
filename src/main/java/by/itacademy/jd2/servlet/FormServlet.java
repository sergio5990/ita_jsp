package by.itacademy.jd2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "form" , urlPatterns = "/formServlet")
public class FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String fio = rq.getParameter("fio");
        Enumeration<String> headerNames = rq.getHeaderNames();
        StringBuilder sb = new StringBuilder();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            String header = rq.getHeader(headerName);
            sb.append(headerName + ":" + header + "  ");
        }
        rs.setContentType("UTF-8");
        PrintWriter writer = rs.getWriter();
        writer.write(fio + "/" + fio.toUpperCase());
        writer.write(sb.toString());
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String fio = rq.getParameter("fio");
        rs.setContentType("UTF-8");
        PrintWriter writer = rs.getWriter();
        writer.write(fio + "/" + fio.toLowerCase());
        rs.addCookie(new Cookie("mycookie", fio));
        HttpSession session = rq.getSession();
        Object attr = session.getAttribute("attr");
        if (attr == null) {
            session.setAttribute("attr", "123");
        }

        writer.write("session attr:" + attr);
    }
}

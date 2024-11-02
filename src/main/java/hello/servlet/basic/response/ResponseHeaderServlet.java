package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // status line
        response.setStatus(HttpServletResponse.SC_OK);

        // response headers
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Custom-Header", "hello");

        // header convenient methods
        setContent(response);
        setCookie(response);
        setRedirect(response);

        // message body
        PrintWriter writer = response.getWriter();
        writer.println("ok");
    }

    private void setContent(HttpServletResponse response) {
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.setContentLength(2);
    }

    private void setCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("customCookie", "good");
        cookie.setMaxAge(600); // 600 seconds
        response.addCookie(cookie);
    }

    private void setRedirect(HttpServletResponse response) throws IOException {
        // response.setStatus(HttpServletResponse.SC_FOUND);
        // response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }

}

package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestQueryParamServlet", urlPatterns = "/request-param")
public class RequestQueryParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        printTotalParam(request);
        printSingleParam(request);
    }

    private void printTotalParam(HttpServletRequest request) {
        System.out.println("--- Total parameters - start ---");

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + " = " + request.getParameter(paramName)));

        System.out.println("--- Total parameters - end ---\n");
    }

    private void printSingleParam(HttpServletRequest request) {
        System.out.println("--- Single parameter - start ---");
        System.out.println("request.getParameter(\"username\") = " + request.getParameter("username"));
        System.out.println("request.getParameter(\"age\") = " + request.getParameter("age"));
        System.out.println("--- Single parameter - end ---\n");
    }

}

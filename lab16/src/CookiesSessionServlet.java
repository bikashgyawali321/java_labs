
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import javax.servlet.http.*;
import java.io.*;
import java.net.URLEncoder;

public class CookiesSessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the user's name from the request
        String name = request.getParameter("name");

        // URL-encode the name to avoid invalid characters in the cookie
        String encodedName = URLEncoder.encode(name, "UTF-8");

        // Create session and store the name in it
        HttpSession session = request.getSession();
        session.setAttribute("username", name);

        // Create a cookie and store the name in it
        Cookie cookie = new Cookie("username", encodedName);
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);

        // Redirect to display the name on the result.jsp page
        response.sendRedirect("result.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

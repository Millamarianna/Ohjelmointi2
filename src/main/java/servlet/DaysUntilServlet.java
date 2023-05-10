package servlet;

import static java.time.temporal.ChronoUnit.DAYS;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/daysUntil")
public class DaysUntilServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	req.getRequestDispatcher("/WEB-INF/daysUntil.jsp").forward(req, resp);
    	
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	LocalDate dateNow = LocalDate.now();
    	String day = req.getParameter("day");
    	if(day.length() < 2) {
    		day = "0" +req.getParameter("day");
    	}
    	
    	String month = req.getParameter("month");
    	
    	if(month.length() < 2) {
    		month = "0" +req.getParameter("month");
    	}
    	
    	String year = req.getParameter("year");
    	
        String dateString = year + "-" + month + "-" + day;
        LocalDate inputDate = LocalDate.parse(dateString);
        long daysBetween = DAYS.between(dateNow, inputDate);

        req.setAttribute("untilDate", daysBetween);
        req.setAttribute("inputDate", dateString);

        // forward the request to the index.jsp page
        req.getRequestDispatcher("/WEB-INF/daysUntil.jsp").forward(req, resp);
    	
    	
    }
}

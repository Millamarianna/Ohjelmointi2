package servlet;

import static java.time.temporal.ChronoUnit.DAYS;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/christmas")
public class ChristmasCountdownServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	LocalDate dateNow = LocalDate.now();
    	LocalDate christmas = LocalDate.of(2023, Month.DECEMBER, 24);
    	long daysBetween = DAYS.between(dateNow, christmas);
    	
        req.setAttribute("untilChristmas", daysBetween);

        req.getRequestDispatcher("/WEB-INF/untilChristmas.jsp").forward(req, resp);
    }
}

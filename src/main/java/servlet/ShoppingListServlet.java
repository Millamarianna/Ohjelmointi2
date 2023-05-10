package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCShoppingListItemDao;
import database.ShoppingListItemDao;
import model.ShoppingListItem;

@WebServlet("/list")
public class ShoppingListServlet extends HttpServlet{

	private ShoppingListItemDao dao = new JDBCShoppingListItemDao();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ShoppingListItem> allItems = this.dao.getAllItems();
		req.setAttribute("items", allItems);
		req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	   
		String itemTitle = req.getParameter("title");

		itemTitle = itemTitle.substring(0, 1).toUpperCase() + itemTitle.substring(1);
		
		ShoppingListItem newItem = new ShoppingListItem(itemTitle);
		
		this.dao.addItem(newItem);
		
		resp.sendRedirect("/list");
	}

	
}

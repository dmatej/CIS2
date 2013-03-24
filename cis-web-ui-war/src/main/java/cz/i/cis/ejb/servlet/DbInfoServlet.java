package cz.i.cis.ejb.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.i.cis.db.person.PhotoService;

/**
 * @author David Matějček
 */
@WebServlet("/db")
public class DbInfoServlet extends HttpServlet {

  @EJB
  private PhotoService photoService;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.getWriter().append(String.format("Photos in database: %d", photoService.getCountOfImages()));
  }

}

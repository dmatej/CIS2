package cz.i.cis.ejb.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.i.cis.db.person.PhotoService;

/**
 * @author David Matějček
 */
@WebServlet("/db")
public class DbInfoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private static final Logger LOG = LoggerFactory.getLogger(DbInfoServlet.class);

  @EJB
  private PhotoService photoService;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    LOG.debug("doGet(request={}, response={})", request, response);
    response.getWriter().append(String.format("Photos in database: %d", photoService.getCountOfImages()));
  }

}

package cz.i.cis.ejb.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.LoggerFactory;

/**
 * Řeší konflikt s automatickým vyhodnocením log4j.properties na classpath, které provádí aplikační server.
 * Ten pak upřednostní vlastní verzi log4j, místo aby použil čistě tu dodanou aplikací.
 * Je to hlášená chyba Glassfishe 3 (a já bych jim měl popsat tento workaround ;) ).
 *
 * @author David Matějček
 */
@WebServlet(loadOnStartup = 1)
public class Initializer extends HttpServlet {

  @Override
  public void init(ServletConfig servletConfig) {
    PropertyConfigurator.configure(Initializer.class.getClassLoader().getResource("cis2.log4j.properties"));
    LoggerFactory.getLogger(Initializer.class).info("LOG4J has been successfuly configured.");
  }
}

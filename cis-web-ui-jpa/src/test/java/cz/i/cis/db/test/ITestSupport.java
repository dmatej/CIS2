package cz.i.cis.db.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author David Matějček
 */
public class ITestSupport {
  private static final Logger LOG = LoggerFactory.getLogger(ITestSupport.class);

  private static Context context;


  @BeforeClass
  public static void initEnvironment() throws NamingException, IOException, ClassNotFoundException {
    LOG.debug("initEnvironment()");
    if (context != null) {
      LOG.debug("Environment is already initialized.");
      return;
    }

// TODO: mozna bude treba konfigurace aplikace. Mozna si ji ale dame do databaze ;)
//    final String path = ITestSupport.class.getClassLoader().getResource("ecis.properties").getPath();
//    System.setProperty(EcisSettings.SYS_ECIS_PROPERTIES_PATH, path);
//    EcisSettings.initialize();

    final URL openejbPath = ITestSupport.class.getClassLoader().getResource("openejb.properties");
    final InputStream propertiesStream = openejbPath.openStream();
    final Properties p = new Properties();
    p.load(propertiesStream);
    context = EJBContainer.createEJBContainer(p).getContext();
    propertiesStream.close();

    LOG.debug("context={}", context);
  }


  @Before
  public void initContext() throws NamingException {
    context.bind("inject", this);
  }


  @Rule
  public TestRule watcher = new TestWatcher() {

    @Override
    protected void starting(final Description description) {
      LOG.info("Starting test: {}", description);
    }


    @Override
    protected void finished(final Description description) {
      LOG.info("Finished test: {}", description);
    }
  };

}

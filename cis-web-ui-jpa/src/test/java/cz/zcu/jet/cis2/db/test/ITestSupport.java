package cz.zcu.jet.cis2.db.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author David Matějček
 */
public class ITestSupport {
  private static final Logger LOG = LoggerFactory.getLogger(ITestSupport.class);


  // TODO: nejspis bude treba se do db nejak dobyt.
  protected Properties loadProperties() {
    LOG.trace("loadProperties()");
    final String fileName = "informix.properties";

    final InputStream stream = ITestSupport.class.getClassLoader().getResourceAsStream(fileName);
    if (stream == null) {
      throw new IllegalStateException("The resource with the name '" + fileName
          + "' could not be found by the current classloader.");
    }

    try {
      final Properties props = new Properties();
      props.load(stream);
      return props;
    } catch (final IOException e) {
      throw new IllegalStateException("Could not load properties from file '" + fileName + "'", e);
    } finally {
      IOUtils.closeQuietly(stream);
    }
  }
}

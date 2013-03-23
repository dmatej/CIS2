/**
 *
 */
package cz.zcu.jet.cis2.db.tool;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.eclipse.persistence.config.SessionCustomizer;
import org.eclipse.persistence.logging.SessionLog;
import org.eclipse.persistence.sessions.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Internal session customizer. Sets the custom logger for eclipselink to
 * {@link CisEclipseLinkSessionLogger} and resets the default logging level.
 *
 * @author David Matějček
 */
public abstract class EclipseLinkSessionCustomizer implements SessionCustomizer {

  private static final Logger LOG = LoggerFactory.getLogger(EclipseLinkSessionCustomizer.class);


  @Override
  public void customize(final Session aSession) {
    LOG.info("customize(aSession={})", aSession);

    final CisEclipseLinkSessionLogger aCustomLogger = new CisEclipseLinkSessionLogger();

    aCustomLogger.setLevel(getLogLevel());
    aSession.setSessionLog(aCustomLogger);

    if (LOG.isInfoEnabled()) {
      LOG.info("Session name: {}", aSession.getName());
      LOG.info("Server platform: \n  {}", ReflectionToStringBuilder.toString(aSession.getServerPlatform()));
      LOG.info("Database platform: \n  {}", ReflectionToStringBuilder.toString(aSession.getPlatform()));
    }
  }


  /**
   * Uses EclipseLink levels (which are the same as Toplink levels)
   * Reason for this is performance - skip logging as soon as possible (in JPA logger or later in
   * slf4j)
   *
   * @return {@link SessionLog}.level
   */
  private int getLogLevel() {

    return SessionLog.FINE;
  }

}

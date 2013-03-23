/**
 *
 */
package cz.zcu.jet.cis2.db.tool;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.persistence.logging.AbstractSessionLog;
import org.eclipse.persistence.logging.SessionLog;
import org.eclipse.persistence.logging.SessionLogEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * EclipseLink logger. Writes to a {@value #PKG_BASE}.* loggers depending on an entry namespace.
 * Level is mapped from JUL logging to SLF4J levels.
 *
 * @author David Matějček
 */
public class CisEclipseLinkSessionLogger extends AbstractSessionLog implements SessionLog {

//  private static final Logger LOG = LoggerFactory.getLogger(CisEclipseLinkSessionLogger.class);

  /** The base name of loggers */
  public static final String PKG_BASE = "cz.zcu.jet.cis2.db.jpa";


  private Logger getLogger(final SessionLogEntry entry) {
    if (entry.getNameSpace() == null) {
      return LoggerFactory.getLogger(PKG_BASE);
    }

    final StringBuilder packageName = new StringBuilder(32);
    packageName.append(PKG_BASE);
    packageName.append('.').append(entry.getNameSpace());
    return LoggerFactory.getLogger(packageName.toString());
  }


  @Override
  public void log(final SessionLogEntry sessionLogEntry) {
    // makes too much mess.
//    LOG.trace("log(sessionLogEntry={})", sessionLogEntry);

    final StringBuilder msg = new StringBuilder();
    msg.append(sessionLogEntry.getMessage());

    if (sessionLogEntry.getException() != null) {
      // no need to close!
      final StringWriter sw = new StringWriter();
      sessionLogEntry.getException().printStackTrace(new PrintWriter(sw));
      msg.append('\n').append(sw.toString()).append('\n');
    }

    final Logger log = getLogger(sessionLogEntry);
    switch (sessionLogEntry.getLevel()) {
      case SessionLog.ALL:
      case SessionLog.FINEST:
        log.trace(msg.toString());
        break;
      case SessionLog.INFO:
        log.info(msg.toString());
        break;
      case SessionLog.WARNING:
        log.warn(msg.toString());
        break;
      case SessionLog.SEVERE:
        log.error(msg.toString());
        break;
      case SessionLog.OFF:
        break;
      case SessionLog.FINER:
      case SessionLog.FINE:
      case SessionLog.CONFIG:
      default:
        log.debug(msg.toString());
    }
  }
}

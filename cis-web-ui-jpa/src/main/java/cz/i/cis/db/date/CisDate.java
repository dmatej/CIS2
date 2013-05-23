package cz.i.cis.db.date;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:david.matejcek@i.cz">David Matejcek</a>
 */
public class CisDate implements Comparable<CisDate>, Serializable {

  /** 00000000 */
  public static final CisDate EMPTY = new CisDate("00000000");

  private static final long serialVersionUID = -2962672354700196115L;

  private static final Logger LOG = LoggerFactory.getLogger(CisDate.class);

  private static final Pattern EMPTY_REGEX = Pattern.compile("[0Xx]+");

  private final String date;

  /**
   * Creates a CisDate instance. Throws {@link IllegalArgumentException} if
   * cisDate does not match the following syntax rules:
   * <ul>
   * <li>cisDate must have 8 characters: YYYYMMDD
   * <li>YYYY matches [0-9Xx]{4}
   * <li>MM matches (([0][0-9])||([1][0-2])||([Xx]{1,2}))
   * <li>DD matches (([0-2][0-9])||([3][01])||([Xx]{1,2}))
   * </ul>
   * X charachters are replaced with zeroes. <br>
   * TODO: X by tu neměly být povoleny, měly by se odstraňovat při parsování!
   *
   * @param cisDate
   *          - values matching [0-9Xx]{8} are accepted, but internaly contains
   *          only [0-9]{8}. X chars are replaced with 0.
   */
  public CisDate(final String cisDate) {

    if (cisDate == null || cisDate.length() != 8) {
      throw new IllegalArgumentException("Invalid cis date: '" + cisDate + "'");
    }

    this.date = cisDate.replaceAll("[Xx]", "0");
  }

  /**
   * @return "YYYY"
   */
  public String getYear() {
    return date.substring(0, 4);
  }

  /**
   * @return "MM"
   */
  public String getMonth() {
    return date.substring(4, 6);
  }

  /**
   * @return "DD"
   */
  public String getDay() {
    return date.substring(6, 8);
  }

  /**
   * Convert date to 8 character representation and wrap it into CisDate
   * instance.
   *
   * @param date
   *          Date string to be parsed.
   * @return CisDate instance
   * @throws ParseException
   * @throws DateParserException
   *           - parsed date is null or has not 8 characters or doesn't achieve
   *           some other rule
   */
  public static CisDate parseDate(final String date) throws ParseException {
    SimpleDateFormat sd = new SimpleDateFormat("d.M.yyyy");
    Date d = sd.parse(date);
    String cisDate = new Integer(d.getYear() + 1900).toString();
    cisDate += d.getMonth() < 10 ? "0" : "";
    cisDate += d.getMonth();
    cisDate += d.getDate() < 10 ? "0" : "";
    cisDate += d.getDate();

    return new CisDate(cisDate);
  }

  private static CisDateCompareStatus compareItems(final String myItem,
      final String otherItem) {
    if (!isConcrete(myItem) || !isConcrete(otherItem)) {
      return CisDateCompareStatus.UNKNOWN;
    }

    final int cmp = myItem.compareTo(otherItem);
    if (cmp == 0) {
      return CisDateCompareStatus.EQUAL;
    }

    if (cmp > 0) {
      return CisDateCompareStatus.LOWER;
    }

    return CisDateCompareStatus.HIGHER;
  }

  private static CisDateCompareStatus compare(final CisDate my,
      final CisDate other) {

    final CisDateCompareStatus yearCmp = compareItems(my.getYear(),
        other.getYear());
    if (yearCmp.isFinalResult()) {
      return yearCmp;
    }

    final CisDateCompareStatus monthCmp = compareItems(my.getMonth(),
        other.getMonth());
    if (monthCmp.isFinalResult()) {
      return monthCmp;
    }

    return compareItems(my.getDay(), other.getDay());
  }

  /**
   * @param when
   * @return true if this is after the when
   */
  public boolean isAfter(final CisDate when) {

    final CisDateCompareStatus result = compare(this, when);
    if (result.isFinalResult()) {
      return result.getResult();
    }

    // could not compare.
    return false;
  }

  /**
   * @param when
   *          CisDate
   * @return true if this is before the when
   */
  public boolean isBefore(final CisDate when) {
    final CisDateCompareStatus result = compare(when, this);
    if (result.isFinalResult()) {
      return result.getResult();
    }

    // could not compare.
    return false;
  }

  /**
   * Compares dates lexicographically.
   *
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  public int compareTo(final CisDate another) {

    return date.compareTo(another.date);
  }

  @Override
  public int hashCode() {
    return 33 + toString().hashCode();
  }

  /**
   * @param obj
   * @return boolean
   */
  @Override
  public boolean equals(final Object obj) {

    if (obj == null) {
      return false;
    }

    if (!(obj instanceof CisDate)) {
      return false;
    }

    return date.equalsIgnoreCase(((CisDate) obj).date);

  }
  /**
   * Date yyyymmdd with zeroes when item value is not known
   */
  public String getCodeDate(){
    return date;
  }


  @Override
  public String toString() {
    //TODO [stulc] upravit výpis data narození
    return date;

  }

  /**
   * Safe method for toString() - null causes null, not NPE.
   *
   * @param date
   * @return null or toString() value
   */
  public static String toString(final CisDate date) {

    if (date == null) {
      return null;
    }

    return date.toString();
  }

  /**
   * @param date
   * @return true if date is null or equal to {@link #EMPTY}
   */
  public static boolean isEmpty(final CisDate date) {
    return date == null || EMPTY.equals(date);
  }

  /**
   * @param date
   * @return false if any part of the date is not concrete
   */
  public static boolean isConcrete(final CisDate date) {
    return isConcrete(date.getDay()) && isConcrete(date.getMonth())
        && isConcrete(date.getYear());
  }

  /**
   * @param date
   *          YYYYMMDD or null or empty String
   * @return null if date is null or empty, CisDate otherwise.
   * @throws IllegalArgumentException
   */
  public static CisDate getInstance(final String date)
      throws IllegalArgumentException {

    LOG.debug("getInstance(date={})", date);

    if (date == null || date.isEmpty()) {
      return null;
    }

    return new CisDate(date);
  }

  /**
   * @param date
   *          YYYYMMDD or null or empty String
   * @return null if date is null or empty, CisDate otherwise.
   * @throws IllegalArgumentException
   */
  public static CisDate valueOf(final String date)
      throws IllegalArgumentException {
    return getInstance(date);
  }

  private static boolean isConcrete(final String datePart) {
    return datePart != null && !EMPTY_REGEX.matcher(datePart).matches();
  }

  private static enum CisDateCompareStatus {
    /** items are equal, comparing another item needed */
    EQUAL(false, null),
    /** first item is lower. End. */
    LOWER(true, Boolean.TRUE),
    /** first item is higher. End. */
    HIGHER(true, Boolean.FALSE),
    /** items are not concrete, so they are not comparable. End. */
    UNKNOWN(true, Boolean.FALSE);

    private boolean finalResult;
    private Boolean result;

    private CisDateCompareStatus(final boolean isFinalResult,
        final Boolean result) {
      this.finalResult = isFinalResult;
      this.result = result;
    }

    /**
     * @return true/false/null ~ true/false/don't know
     */
    public Boolean getResult() {
      return result;
    }

    /**
     * @return true if there is not needed to continue with another items.
     */
    public boolean isFinalResult() {
      return finalResult;
    }

  }

}
/**
 *
 */
package cz.i.cis.person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("filterpersons")
@RequestScoped
public class FilterPersonsBean {
    private String firstname;
    private String lastname;
    private String birthnumber;
    private String sex;

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getBirthnumber() {
        return birthnumber;
    }
    public void setBirthnumber(String birthnumber) {
        this.birthnumber = birthnumber;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
}

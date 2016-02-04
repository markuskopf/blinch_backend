package com.blinch.server.domain.group;

import com.blinch.common.domain.AbstractAuditableEntity;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Size;

/**
 * Created by markuskopf on 26/01/16.
 */
public class BLIGroup  extends AbstractAuditableEntity {

    @Size(min = 2, max = 1000)

    @NotEmpty
    private String domainName;

    @Size(min = 2, max = 1000)
    @NotEmpty
    private String groupName;

    @NotEmpty
    private String city;

    private String zipCode;

    @NotEmpty
    private String country;

    private String street;

    public BLIGroup() {
    }

    public BLIGroup(String domainName, String groupName, String city, String country) {
        this.domainName = domainName;
        this.groupName = groupName;
        this.city = city;
        this.country = country;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

}

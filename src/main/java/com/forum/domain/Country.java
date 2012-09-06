package com.forum.domain;

public class Country {
    private String countryId;
    private String countryName;

    public Country(String countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (countryId != null ? !countryId.equals(country.countryId) : country.countryId != null) return false;
        if (countryName != null ? !countryName.equals(country.countryName) : country.countryName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countryId != null ? countryId.hashCode() : 0;
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        return result;
    }
}

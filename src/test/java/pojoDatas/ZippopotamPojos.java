package pojoDatas;

public class ZippopotamPojos {
     /*
    {
    "post code": "34010",
    "country": "Turkey",
    "country abbreviation": "TR",
    "places": [
              {
                "place name": "Maltepe Mah.",
                "longitude": "32.3609",
                "state": "İstanbul",
                "state abbreviation": "34",
                "latitude": "40.1589"
              }
              ]
    }
     */
private String postCode;
private String country;
private String countryAbbreviation;
private ZippopotamPlacePojo zippopotamPlacePojo;

public ZippopotamPojos(){

}

    public ZippopotamPojos(String postCode, String country, String countryAbbreviation,ZippopotamPlacePojo zippopotamPlacePojo) {
        this.postCode = postCode;
        this.country = country;
        this.countryAbbreviation = countryAbbreviation;
        this.zippopotamPlacePojo = zippopotamPlacePojo;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }

    public ZippopotamPlacePojo getZippopotamPlacePojo() {
        return zippopotamPlacePojo;
    }

    public void setZippopotamPlacePojo(ZippopotamPlacePojo zippopotamPlacePojo) {
        this.zippopotamPlacePojo = zippopotamPlacePojo;
    }

    @Override
    public String toString() {
        return "ZippopotamPojos{" +
                "postCode='" + postCode + '\'' +
                ", country='" + country + '\'' +
                ", countryAbbreviation='" + countryAbbreviation + '\'' +
                ", zippopotamPlacePojo='" + zippopotamPlacePojo +
                '}';
    }

}

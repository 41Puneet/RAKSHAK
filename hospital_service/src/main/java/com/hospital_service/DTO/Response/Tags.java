package com.hospital_service.DTO.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tags {
    
    private String name;
    private String amenity;
    @JsonProperty("addr:street")
    private String street;
    @JsonProperty("addr:city")
    private String city;
    @JsonProperty("addr:postcode")
    private String postcode;
    public Tags(){
    }
        public Tags(String name,String amenity,String street,String city,String postcode){
            this.name=name;
            this.amenity=amenity;
            this.street=street;
            this.city=city;
            this.postcode=postcode;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getAmenity() {
            return amenity;
        }
        public void setAmenity(String amenity) {
            this.amenity = amenity;
        }
        public String getStreet() {
            return street;
        }
        public void setStreet(String street) {
            this.street = street;
        }
        public String getCity() {
            return city;
        }
        public void setCity(String city) {
            this.city = city;
        }
        public String getPostcode() {
            return postcode;
        }
        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }
    
        public String getFullAddress() {
    return String.join(", ",
            street != null ? street : "",
            city != null ? city : "",
            postcode != null ? postcode : "");
}
}

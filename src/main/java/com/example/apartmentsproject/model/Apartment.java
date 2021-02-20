package com.example.apartmentsproject.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "apartments")
  public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final String apartmentId;

    private final String apartmentName;

    private final float pricePerNight;

    private final int numGuests;


    public Apartment(@JsonProperty("apartmentId") String apartmentId,
        @JsonProperty("apartmentName") String apartmentName,
        @JsonProperty("pricePerNight") float pricePerNight,
        @JsonProperty("numGuests") int numGuests) {
      this.apartmentId = apartmentId;
      this.apartmentName = apartmentName;
      this.pricePerNight = pricePerNight;
      this.numGuests = numGuests;

    }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }

    if (!Apartment.class.isAssignableFrom(obj.getClass())) {
      return false;
    }

    final Apartment other = (Apartment) obj;
    if ((this.apartmentName == null) ? (other.apartmentName != null) : !this.apartmentName.equals(other.apartmentName)) {
      return false;
    }

    if (this.numGuests != other.numGuests) {
      return false;
    }

    if (this.pricePerNight != other.pricePerNight) {
      return false;
    }

    return true;
  }

    public String getApartmentId() {
      return apartmentId;
    }

    public String getApartmentName() {
      return apartmentName;
    }

    public float getPricePerNight() {
      return pricePerNight;
    }

    public int getNumGuests() {
      return numGuests;
    }


  }



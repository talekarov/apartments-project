package com.example.apartmentsproject.repository;

import com.example.apartmentsproject.model.Apartment;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends MongoRepository<Apartment, String> {

  List<Apartment> findAllByNumGuestsEquals(int numGuests);

  List<Apartment> findAllByPricePerNightLessThanEqualOrderByPricePerNightDesc(
      float pricePerNight);

  Apartment findByApartmentId(String apartmentId);

  List<Apartment> findAll();

  List<Apartment> findAllByPricePerNightLessThanEqual(float pricePerNight);






}

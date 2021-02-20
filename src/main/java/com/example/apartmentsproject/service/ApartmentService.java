package com.example.apartmentsproject.service;

import com.example.apartmentsproject.model.Apartment;
import com.example.apartmentsproject.repository.ApartmentRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApartmentService {

  private final ApartmentRepository apartmentRepository;

  @Autowired
  public ApartmentService(ApartmentRepository apartmentRepository) {
    this.apartmentRepository = apartmentRepository;
  }

  public List<Apartment> getAll() {
    return apartmentRepository.findAll();
  }

  public List<Apartment> getByPrice(float pricePerNight) {

    return apartmentRepository
        .findAllByPricePerNightLessThanEqualOrderByPricePerNightDesc(pricePerNight);
  }

  public List<Apartment> getByGuests(int numGuests) {
    return apartmentRepository.findAllByNumGuestsEquals(numGuests);
  }

  public Apartment getById(String apartmentId) {
    return apartmentRepository.findByApartmentId(apartmentId);
  }

  public void addNewApartment(Apartment apartment){
    apartmentRepository.insert(apartment);
  }

  public List<Apartment> getAllByFilter(int numGuests, float pricePerNight) {
    List<Apartment> apartmentsGuests = apartmentRepository.findAllByNumGuestsEquals(numGuests);
    List<Apartment> apartmentsPrice = apartmentRepository
        .findAllByPricePerNightLessThanEqual(pricePerNight);

    List<Apartment> apartments = apartmentsGuests.stream()
        .filter(apartmentsPrice::contains)
        .collect(Collectors.toList());

    return apartments;
  }

}

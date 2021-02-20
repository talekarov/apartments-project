package com.example.apartmentsproject.controller;

import com.example.apartmentsproject.model.Apartment;
import com.example.apartmentsproject.service.ApartmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apartments")
public class ApartmentController {

  private final ApartmentService apartmentService;

  @Autowired
  public ApartmentController(ApartmentService apartmentService) {
    this.apartmentService = apartmentService;
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping(value = "/")
  public List<Apartment> getAllApartments() {
    return apartmentService.getAll();
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping(value = "/byPrice={pricePerNight}")
  public List<Apartment> getAllApartmentsByPrice(
      @PathVariable("pricePerNight") float pricePerNight) {
    return apartmentService.getByPrice(pricePerNight);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping(value = "/byGuests={numGuests}")
  public List<Apartment> getAllApartmentsByGuests(@PathVariable("numGuests") int numGuests) {
    return apartmentService.getByGuests(numGuests);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping(value = "/byId={apartmentId}")
  public Apartment getApartmentById(@PathVariable("apartmentId") String apartmentId) {
    return apartmentService.getById(apartmentId);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @PostMapping(value ="/add")
  public void addApartment(Apartment apartment){
    apartmentService.addNewApartment(apartment);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping(value = "/byFilter/numGuests={numGuests}pricePernight={pricePerNight}")
  public List<Apartment> getAllApartmentsByFilter(@PathVariable("numGuests") int numGuests,
      @PathVariable("pricePerNight") float pricePerNight) {
    return apartmentService.getAllByFilter(numGuests, pricePerNight);
  }
}

package com.doranco.flash.ReservationJPA;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {
	
	
	
	ReservationRepository reservationsRepository;
	
	
	
	public ReservationController(ReservationRepository reservationsRepository)
	{
		
		this.reservationsRepository = reservationsRepository;
		
		
	}
	
	
	//get list of all hotel reservations
	@GetMapping("/all")
	public List<Hotel> getHotels()
	{
		return reservationsRepository.findAll();
	}
	
	//get list of reservations given by @param prix
	@GetMapping("/abordable/{prix}")
	public List<Hotel> getAbordable(@PathVariable double prix)
	{

		return reservationsRepository.findByNuiteLessThan(prix);

	}
	
	@PostMapping("/create")
	public List<Hotel> create(@RequestBody Hotel hotel)
	{
		
		 reservationsRepository.save(hotel);

		return reservationsRepository.findAll();
	}

	@GetMapping("/delete/{id}")
	public List<Hotel> delete(@PathVariable long id)
	{

		reservationsRepository.deleteById(id);
		
		return reservationsRepository.findAll();
		
	}
	
	@PutMapping("/update/{id}")
	public List<Hotel> update(@RequestBody Hotel hotel, @PathVariable long id)
	{
		 reservationsRepository.findById(id).ifPresent(hotelTemp -> {
			hotelTemp.setNom(hotel.getNom());
			hotelTemp.setNuite(hotel.getNuite());
			hotelTemp.setNbNuits(hotel.getNbNuits());
			
			reservationsRepository.save(hotelTemp);
			
		});
		
		 return reservationsRepository.findAll();
	}
	
	
	

}

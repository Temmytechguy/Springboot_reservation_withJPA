package com.doranco.flash.ReservationJPA;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 
 * @author user
 *apres que l'application soit lancee
 *apres que tous les beans soient crees
 *apres que le context de l'application soit cree
 *toutes les classes qui implement le CLR sont executes
 */
@Component
public class DBInit implements CommandLineRunner{
	
	private ReservationRepository reservationRepository;

	/**
	 * permit de injection
	 * @param reservationRepository
	 */
	@Autowired
	public DBInit(ReservationRepository reservationRepository) {
		
		this.reservationRepository = reservationRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		List<Hotel> reservations = new ArrayList<>();
		//add hotel to the list
		reservations.add(new Hotel("Hilton",200.50,4));
		reservations.add(new Hotel("Ibiza",259.90,2));
		reservations.add(new Hotel("Tipton",100.90,8));
		
		reservationRepository.saveAll(reservations);
		
	}
	
	
	
	

}

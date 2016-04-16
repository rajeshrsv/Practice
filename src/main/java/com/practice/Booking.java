package com.practice;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Entity
public class Booking {
	@Id
	@GeneratedValue
	private Long id;
	private String bookingName;

	public Long getId() {
		return id;
	}

	public String getBookingName() {
		return bookingName;
	}

	public Booking() {
	}

	public Booking(String bookingName) {
		super();
		this.bookingName = bookingName;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookingName=" + bookingName + "]";
	}
}

@RestController
class BookingRestController {
	@RequestMapping("/bookings")
	Collection<Booking> bookings() {
		return this.bookingRepository.findByBookingName("Poonkodi");
	}

	@Autowired
	BookingRepository bookingRepository;
}

interface BookingRepository extends JpaRepository<Booking, Long> {
	Collection<Booking> findByBookingName(String bookingName);
}

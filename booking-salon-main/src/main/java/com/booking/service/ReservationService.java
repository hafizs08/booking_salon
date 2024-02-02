package com.booking.service;

import java.util.List;
import java.util.Scanner;

import com.booking.models.Customer;
import com.booking.models.Employee;
import com.booking.models.Person;
import com.booking.models.Reservation;
import com.booking.models.Service;
import com.booking.repositories.PersonRepository;
import com.booking.repositories.ServiceRepository;

public class ReservationService {

    private static Scanner input = new Scanner(System.in);

    public static void createReservation(List<Person> persons, List<Service> services, List<Reservation> reservations) {
        // Implementasi createReservation
        // ...

        // Contoh penggunaan:
        System.out.print("Masukkan Customer ID: ");
        String customerId = input.nextLine();
        Customer customer = getCustomerByCustomerId(customerId, persons);

        System.out.print("Masukkan Employee ID: ");
        String employeeId = input.nextLine();
        Employee employee = getEmployeeById(employeeId, persons);

        // ... (lanjutkan proses pembuatan reservasi sesuai dengan permintaan)

        Reservation newReservation = new Reservation(/* parameter sesuai kebutuhan */);
        reservations.add(newReservation);

        System.out.println("Reservasi berhasil dibuat!");
    }

    public static Customer getCustomerByCustomerId(String customerId, List<Person> persons) {
        // Implementasi getCustomerByCustomerId
        for (Person person : persons) {
            if (person instanceof Customer && person.getId().equals(customerId)) {
                return (Customer) person;
            }
        }
        System.out.println("Customer yang dicari tidak tersedia");
        return null;
    }

    public static Employee getEmployeeById(String employeeId, List<Person> persons) {
        // Implementasi getEmployeeById
        for (Person person : persons) {
            if (person instanceof Employee && person.getId().equals(employeeId)) {
                return (Employee) person;
            }
        }
        System.out.println("Employee yang dicari tidak tersedia");
        return null;
    }

    public static void editReservationWorkstage(List<Reservation> reservations) {
        // Implementasi editReservationWorkstage
        // ...

        // Contoh penggunaan:
        System.out.print("Masukkan Reservation ID: ");
        String reservationId = input.nextLine();
        Reservation reservationToEdit = getReservationById(reservationId, reservations);

        if (reservationToEdit != null) {
            // Ubah workstage sesuai kebutuhan
            reservationToEdit.setWorkstage("In Process");
            System.out.println("Workstage reservasi berhasil diubah!");
        }
    }

    private static Reservation getReservationById(String reservationId, List<Reservation> reservations) {
        // Implementasi getReservationById
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId().equals(reservationId)) {
                return reservation;
            }
        }
        System.out.println("Reservation yang dicari tidak tersedia");
        return null;
    }
}

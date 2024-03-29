package com.booking.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.booking.models.Person;
import com.booking.models.Reservation;
import com.booking.models.Service;
import com.booking.repositories.PersonRepository;
import com.booking.repositories.ServiceRepository;

public class MenuService {
    private static List<Person> personList = PersonRepository.getAllPerson();
    private static List<Service> serviceList = ServiceRepository.getAllService();
    private static List<Reservation> reservationList = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void mainMenu() {
        PrintService printService = new PrintService();
        ReservationService reservationService = new ReservationService();

        String[] mainMenuArr = {"Show Data", "Create Reservation", "Complete/cancel reservation", "Exit"};
        String[] subMenuArr = {"Recent Reservation", "Show Customer", "Show Available Employee", "Back to main menu"};

        int optionMainMenu;
        int optionSubMenu;

        boolean backToMainMenu = false;
        boolean backToSubMenu = false;

        do {
            PrintService.printMenu("Main Menu", mainMenuArr);
            optionMainMenu = Integer.valueOf(input.nextLine());
            switch (optionMainMenu) {
                case 1:
                    do {
                        PrintService.printMenu("Show Data", subMenuArr);
                        optionSubMenu = Integer.valueOf(input.nextLine());
                        switch (optionSubMenu) {
                            case 1:
                                printService.showRecentReservation(reservationList);
                                break;
                            case 2:
                                printService.showAllCustomer(personList);
                                break;
                            case 3:
                                printService.showAllEmployee(personList);
                                break;
                            case 4:
                                //printService.showHistoryReservation(reservationList);
                                break;
                            case 0:
                                backToSubMenu = false;
                                break;
                        }
                    } while (!backToSubMenu);
                    break;
                case 2:
                    //reservationService.createReservation(personList, serviceList, reservationList);
                    break;
                case 3:
                    //reservationService.editReservationWorkstage(reservationList);
                    break;
                case 0:
                    backToMainMenu = false;
                    break;
            }
        } while (!backToMainMenu);
    }
}

import entity.*;
import repository.ClientRepository;
import repository.EventRepository;
import repository.TicketRepository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private final static EntityManager em = Persistence.createEntityManagerFactory("Ticketing_JPA").createEntityManager();
    private final static ClientRepository clientRepository = new ClientRepository(em);
    private final static EventRepository eventRepository = new EventRepository(em);
    private final static TicketRepository ticketRepository = new TicketRepository(em);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Create Client");
            System.out.println("2. Read Client");
            System.out.println("3. Read All Clients");
            System.out.println("4. Update Client");
            System.out.println("5. Delete Client");
            System.out.println("6. Create Event");
            System.out.println("7. Read Event");
            System.out.println("8. Read All Events");
            System.out.println("9. Update Event");
            System.out.println("10. Delete Event");
            System.out.println("11. Check Ticket Availability");
            System.out.println("12. Create Ticket");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createClient(scanner);
                    break;
                case 2:
                    readClient(scanner);
                    break;
                case 3:
                    readAllClients();
                    break;
                case 4:
                    updateClient(scanner);
                    break;
                case 5:
                    deleteClient(scanner);
                    break;
                case 6:
                    createEvent(scanner);
                    break;
                case 7:
                    readEvent(scanner);
                    break;
                case 8:
                    readAllEvent();
                    break;
                case 9:
                    updateEvent(scanner);
                    break;
                case 10:
                    deleteEvent(scanner);
                    break;
                case 11:
                    checkTicketAvailability(scanner);
                    break;
                case 12:
                    createTicket(scanner);
                    break;
                case 0:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private static void createClient(Scanner scanner) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.println("Enter street: ");
        String street = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        Address address = Address.builder().street(street).city(city).build();
        Client client = Client.builder().firstName(firstName).lastName(lastName).phone(phone).address(address).build();
        clientRepository.save(client);
        System.out.println("Client created: " + client);
    }

    private static void readClient(Scanner scanner) {
        System.out.print("Enter client ID: ");
        int clientId = scanner.nextInt();
        Client client = clientRepository.findById(clientId);
        if (client == null){
            System.out.println("Client not found");
            return;
        }
        System.out.println("Client: " + client);
    }
    private static void readAllClients() {
        List<Client> clients = clientRepository.findAll();
        clients.forEach(System.out::println);
    }
    private static void updateClient(Scanner scanner) {
        System.out.print("Enter client ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        Client client = clientRepository.findById(clientId);
        if (client == null) {
            System.out.println("Client not found");
            return;
        }
        System.out.print("Enter new first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter new last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter new phone: ");
        String phone = scanner.nextLine();
        System.out.println("Enter new street: ");
        String street = scanner.nextLine();
        System.out.print("Enter new city: ");
        String city = scanner.nextLine();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setPhone(phone);
        client.getAddress().setStreet(street);
        client.getAddress().setCity(city);
        clientRepository.save(client);
        System.out.println("Client updated: " + client);
    }

    private static void deleteClient(Scanner scanner) {
        System.out.print("Enter client ID: ");
        int clientId = scanner.nextInt();
        Client client = clientRepository.findById(clientId);
        if (client == null){
            System.out.println("Client not found !");
            return;
        }
        clientRepository.delete(client);
        System.out.println("Client deleted");
    }
    private static void createEvent(Scanner scanner) {
        System.out.print("Enter event name: ");
        String name = scanner.nextLine();
        System.out.print("Enter number of places: ");
        int numberOfPlace = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter street: ");
        String street = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        Location location = Location.builder().street(street).city(city).capacity(numberOfPlace).build();
        Event event = Event.builder().name(name).numberOfPlace(numberOfPlace).location(location).build();
        eventRepository.save(event);
        System.out.println("Event created: " + event);
    }

    private static void readEvent(Scanner scanner) {
        System.out.print("Enter event ID: ");
        int eventId = scanner.nextInt();
        Event event = eventRepository.findById(eventId);
        System.out.println("Event: " + event);
    }
    private static void readAllEvent(){
        List<Event> events = eventRepository.findAll();
        events.forEach(System.out::println);
    }
    private static void updateEvent(Scanner scanner) {
        System.out.print("Enter event ID: ");
        int eventId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        Event event = eventRepository.findById(eventId);
        if (event == null) {
            System.out.println("Event not found");
            return;
        }
        System.out.print("Enter new event name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new number of places: ");
        int numberOfPlace = scanner.nextInt();
        event.setName(name);
        event.setNumberOfPlace(numberOfPlace);
        eventRepository.save(event);
        System.out.println("Event updated: " + event);
    }

    private static void deleteEvent(Scanner scanner) {
        System.out.print("Enter event ID: ");
        int eventId = scanner.nextInt();
        Event event = eventRepository.findById(eventId);
        if (event == null){
            System.out.println("Event not found!");
            return;
        }
        eventRepository.delete(event);
        System.out.println("Event deleted");
    }

    private static void checkTicketAvailability(Scanner scanner) {
        readAllEvent();
        System.out.print("Enter event ID: ");
        int eventId = scanner.nextInt();
        Event event = eventRepository.findById(eventId);
        if (event == null){
            System.out.println("Event not found!");
            return;
        }
        int ticketAvailable = event.getNumberOfPlace() - event.getTicketList().size();
        if (ticketAvailable > 0) {
            System.out.println(ticketAvailable + " tickets available");
        } else {
            System.out.println("No tickets available for this event.");
        }
    }

    private static void createTicket(Scanner scanner){
        Random random = new Random();
        readAllClients();
        Client client = null;
        while (client == null){
            System.out.println("Enter client ID: ");
            int clientId = scanner.nextInt();
            scanner.nextLine();
            client = clientRepository.findById(clientId);
        }
        readAllEvent();
        Event event = null;
        while (event == null){
            System.out.println("Enter event ID: ");
            int eventId = scanner.nextInt();
            scanner.nextLine();
            event = eventRepository.findById(eventId);
        }
        int seatNumber = random.nextInt(event.getNumberOfPlace()) + 1;
        System.out.println("Type of place: ");
        TypeTicket typeTicket = null;
        while (typeTicket == null){
            System.out.println("1. Standard");
            System.out.println("2. Gold");
            System.out.println("3. VIP");
            int choice = scanner.nextInt();
            scanner.nextLine();
            typeTicket = switch (choice) {
                case 1 -> TypeTicket.STANDARD;
                case 2 -> TypeTicket.GOLD;
                case 3 -> TypeTicket.VIP;
                default -> null;
            };
        }
        Ticket ticket = Ticket.builder().seatNumber(seatNumber).client(client).event(event).typeTicket(typeTicket).build();
        ticketRepository.save(ticket);
        System.out.println("Ticket created: " + ticket);
    }
}
# Don't Wreck my house plan.

# High Requirement.

The application user is an accommodation administrator. They pair guests to hosts to make reservations.

*The administrator may view existing reservations for a host.
*The administrator may create a reservation for a guest with a host.
*The administrator may edit existing reservations.
*The administrator may cancel a future reservation.


#Technical Requirements
* Must be a Maven project.
* Spring dependency injection configured with either XML or annotations.
* All financial math must use BigDecimal.
* Dates must be LocalDate, never strings.
* All file data must be represented in models in the application.
* Reservation identifiers are unique per host,
* not unique across the entire application. Effectively,
* the combination of a reservation identifier and a host identifier 
* is required to uniquely identify a reservation.

## Three layer architecture.
##Data

[X] DataException
[X] GuestFileRepository
[X] GuestRepository : Interface
[X] HostFileRepository 
[X] HostRepository 
[X] ReservationFileRepository

##Domain: 

[X] GuestService
[X] HostService
[X] ReservationService
[X] Result
[X] Response

##Models: 
[X} Guest

private int guestId;
private String firstName;
private String lastName;
private String email;
private String phone;
private String state;

[X} Host
private String hostId;
private String lastName;
private String email;
private String phone;
private String address;
private String city;
private String state;
private String postalCode;
private BigDecimal standardRate;
private BigDecimal weekEndRate;

[X} Reservation

private int reservationId;
private LocalDate startDate;
private LocalDate endDate;
private Guest guest;
private BigDecimal total;

## UI: 
[X] Console IO 
[X] View
[X] MainMenuOption 
[X] Controller

#Main Method to call the program 

[X] App -- app entry point

## STEPS.

[X] Create a Maven Project 
[X] Add Maven Dependencies to support unit test
[X] Spring dependency injection configured with either XML or annotations 
[X] Create the Guest, Host, Reservation Models.

[X] Create the data Layer DataException custom exception
[X] Create the HostFIleRepository class ,
All the method should catch IOExceptions and throw the data layers DataException custom exception.
[X]Create the GuestFIleRepository class , 
All the method should catch IOExceptions and throw the data layers DataException custom exception.
[X] Create the ReservationFIleRepository class, 
All the method should catch IOExceptions and throw the data layers DataException custom exception.

* add a fields for(Host, Guest, Reservation) for the file path and create a constructor to initialize the field
* generate tests for the repositories
* create a data directory in the project root. add test, seed, and production data files
* implement and test all of the needed repository methods
* be sure to establish known-good-state with @BeforeAll

[X] Extract an interface GuestRepository(IntelliJ: Refactor -> Extract Interface) 
from the GuestFileRepository class.

[X] Extract an interface HostRepository(IntelliJ: Refactor -> Extract Interface)
from the HostFileRepository class.

[X] Extract an interface ReservationRepository(IntelliJ: Refactor -> Extract Interface)
from the ReservationRepository class.

[X] Create a GuestResult, HostResult, ReservationResult, Result, Response class.


[X] Create the GuestService class:
* Add a field for the GuestRepository (not the GuestFileRepository class!) with a corresponding constructor
* Generate tests for the service
* Create a GuestRepositoryTestDouble class to support service testing, this test class implements the GuestRepository interface
* Implement and test all of the needed service methods

[X] Create the HostService class:
* Add a field for the HostRepository (not the HostFileRepository class!) with a corresponding constructor
* Generate tests for the service
* Create a HostRepositoryTestDouble class to support service testing, this test class implements the HostRepository interface
* Implement and test all of the needed service methods

[X] Create the ReservationService class:
* Add a field for the ReservationRepository (not the ReservationFileRepository class!) with a corresponding constructor
* Generate tests for the service
* Create a ReservationRepositoryTestDouble class to support service testing, this test class implements the ReservationRepository interface
* Implement and test all of the needed service methods

[X] Create a View
* add Scanner field
* create read* methods: readString, readRequiredString, readInt, readInt (with min/max) 

[X] Create a Controller
* add fields for service and view with corresponding constructor
* add a run method

[X] Create App and the main method
* instantiate all required objects: repository, service, view, and controller
* run the controller

[X] Work back and forth between controller and view. 
    Run early and often. Add System.out.println as breadcrumbs in
    controller, but don't forget to remove them when development is complete.
    Determine the correct sequence for service calls and view calls.



## Controller Perspectives

1 - View Reservations for Host 
[X] Collect the email for the host.
[X] Display all the reservation for the guests.


##Make a Reservation

* ask for the guest email
* ask for the host email
* display the available days for the host.
* ask the user to enter a valid date 
* Start date 
* End date 
* Calculate the total of days (Friday and Saturday different prices)
* Print total and ask the user to confirm [YES OR NO]

##Edit a Reservation
* Ask the user for the Guest email
* Ask the user for the host email
* display the reservation
* update by id


##Cancel a Reservation
* ask for the guest email
* ask for the host email
* display the reservation 
* delete by id 
* display confirmation of the cancellations


#Total Completion Time Estimate: 60 hours.

[X]Create the models - 2 hours

Host
Guest
Reservation

[X] Create the interfaces - 1 hour

HostRepository
GuestRepository
ReservationRepository

[X]Create HostFileRepository class 1 hour

[X]Create HostFileRepositoryTest class in test package -  Time: 1 hour

[X]Create GuestFileRepository class -  Time: 1 hour

[X]Create GuestFileRepositoryTest class in test package - 40 Min

[X]Create ReservationFileRepository class - Actual Time: 5 hours


[X]Create HostService class - 40 min


[X]Create HostRepositoryDouble class in test package - time : 1 Hour


[X]Create HostServiceTest class in test package - time : 45 min


[X]Create GuestServiceTest class in test package - 30 min


[X]Create ReservationService class - 10+ Hours
        Write CRUD methods











 

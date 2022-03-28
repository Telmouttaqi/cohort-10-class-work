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
#Data 

[ ] DataException
[ ] GuestFileRepository
[ ] GuestRepository : Interface
[ ] HostFileRepository 
[ ] HostRepository 
[ ] ReservationFileRepository

##Domain: 

[ ] GuestService
[ ] HostService
[ ] ReservationService
[ ] Result
[ ] Response

##Models: 
[ ] Guest
[ ] Host
[ ] Reservation

## UI: 
[ ] Console IO 
[ ] View
[ ] MainMenuOption 
[ ] Controller

#Main Method to call the program 

[ ] App -- app entry point

## STEPS.

[ ] Create a Maven Project 
[ ] Add Maven Dependencies to support unit test
[ ] Spring dependency injection configured with either XML or annotations 
[ ] Create the Guest, Host, Reservation Models.

[ ] Create the data Layer DataException custom exception
[ ] Create the HostFIleRepository class ,
All the method should catch IOExceptions and throw the data layers DataException custom exception.
[ ]Create the GuestFIleRepository class , 
All the method should catch IOExceptions and throw the data layers DataException custom exception.
[ ] Create the ReservationFIleRepository class, 
All the method should catch IOExceptions and throw the data layers DataException custom exception.

* add a fields for(Host, Guest, Reservation) for the file path and create a constructor to initialize the field
* generate tests for the repositories
* create a data directory in the project root. add test, seed, and production data files
* implement and test all of the needed repository methods
* be sure to establish known-good-state with @BeforeAll

[ ] Extract an interface GuestRepository(IntelliJ: Refactor -> Extract Interface) 
from the GuestFileRepository class.

[ ] Extract an interface HostRepository(IntelliJ: Refactor -> Extract Interface)
from the HostFileRepository class.

[ ] Extract an interface ReservationRepository(IntelliJ: Refactor -> Extract Interface)
from the ReservationRepository class.

[ ] Create a GuestResult, HostResult, ReservationResult, Result, Response class.


[ ] Create the GuestService class:
* Add a field for the GuestRepository (not the GuestFileRepository class!) with a corresponding constructor
* Generate tests for the service
* Create a GuestRepositoryTestDouble class to support service testing, this test class implements the GuestRepository interface
* Implement and test all of the needed service methods

[ ] Create the HostService class:
* Add a field for the HostRepository (not the HostFileRepository class!) with a corresponding constructor
* Generate tests for the service
* Create a HostRepositoryTestDouble class to support service testing, this test class implements the HostRepository interface
* Implement and test all of the needed service methods

[ ] Create the ReservationService class:
* Add a field for the ReservationRepository (not the ReservationFileRepository class!) with a corresponding constructor
* Generate tests for the service
* Create a ReservationRepositoryTestDouble class to support service testing, this test class implements the ReservationRepository interface
* Implement and test all of the needed service methods

[ ] Create a View
* add Scanner field
* create read* methods: readString, readRequiredString, readInt, readInt (with min/max) 

[ ] Create a Controller
* add fields for service and view with corresponding constructor
* add a run method

[] Create App and the main method
* instantiate all required objects: repository, service, view, and controller
* run the controller

[ ] Work back and forth between controller and view. 
    Run early and often. Add System.out.println as breadcrumbs in
    controller, but don't forget to remove them when development is complete.
    Determine the correct sequence for service calls and view calls.

* implement the menu
* implement the "view by section" feature
* implement the "add panel" feature
* implement the "update panel" feature
* implement the "delete panel" feature

## Controller Perspectives

1 - View Reservations for Host 
[ ] Collect the email for the host.
[ ] Display all the reservation for the guests.


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













 
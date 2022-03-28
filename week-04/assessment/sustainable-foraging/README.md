## Sustainable Foraging


I) Implement missing features

-Add a Forage option  **is missing the validation**
to prevent a duplicate combination of date, item, and forager

-Add Forager [Not Implemented]
*Ask the user FirstName, LastName, State : ** Required and not duplicate**
* Create add method inside the ForagerFileRepositories.
* Add validation inside the ForagerService
* Create a AddForager inside the Controller


    (Test all Methods in unit test)

- View Foragers by state:
    * add view by state to the main menu
    * add viewByState in controller and view

- Create a report that displays the kilograms of each item collected on one day.
    * Use streams to filter by date, groupingBy(Forage::getKilograms)

- Create a report that displays the total value of each Category collected on one day.
  *filter by date, filter by category type, map using .collect
  *(key-value is categoryType-count of that category)


## Add Spring dependency injection

- ForagerService is dependent on ForagerFileRepository
- ForageService is dependent on all three file repositories (Forage,Forager,Item)
- ItemService is dependent on the ItemFileRepository
- Controller depends on all three services (Forage,Forager,Item) and the View
- View is dependent on the ConsoleIO


# Start working.
Requirement for the items.

Add Spring dependency injection to the Memories Application POM
org.springframework 5.2.7.RELEASE
add @Repository to the ForageFileRepository.
add @Repository to the ForagerFileRepository.
add @Repository to the ItemRepository.
-------
add findALL() TO forageRepository .
add report for kg item.

Implement method View Foragers by State.

1) Add the view by foragers by state to the menu OPTION-7
2) create a method displayForagers in the VIEW.
3) private method getStateAbbr
4) add method findByState inside the Forage Service.

Implement method Add forager
1)add the method inside the interface ForagerRepository : 
2) write all and serialize method getters id , first name , last name , state.

Implement:
Create a report that displays the   kilogramsOfEachItem   collected on one day.




[x] Name is required.
[x] Name cannot be duplicated.
[x] Category is required.
[x] Dollars/Kg is required.
[x] Dollars/Kg must be between $0 (inedible, poisonous) and $7500.
[x] Item ID is a system-generated unique sequential integer.

Requirements for the foragers.

[ ] First name is required.
[ ] Last name is required.
[ ] State is required.
[ ] The combination of first name, last name, and state cannot be duplicated.
[ ] Forager ID is a system-generated GUID (globally unique identifier).

Requirements for the Forages

[ ] Item is required and must exist.
[ ] Forager is required and must exist.
[ ] Date is required and must not be in the future.
[ ] Kilograms must be a positive number not more than 250.
[ ] The combination of date, Item, and Forager cannot be duplicated. (Can't forage the same item on the same day. It should be tracked as one Forage.)
[ ] Forage ID is a system-generated GUID (globally unique identifier).












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












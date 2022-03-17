* # Project Gomoku
   * Steps:
- Display the menu includes two options [ 1 - 2 ].
- ask the user to pick one of the options available
- Human or Random
- if Human : Ask the user of the name.
- if Random Player under the class Random Player there is a method will determine a random name
- print : (Randomizing)
- Program will randomly pick the first player
- first player should have the black Stone
- check if player return == null its human Player
- ask the Human Player for the location (row and column)
- else 
- Random player will display all the move no need to enter the location
- if the location already use display invalid until is a valid location.
- Random Player use generateMove method.
- print the board after each successfully move
- Check after each move if one of the player 1 or player two won
- if won print the name of the player and  "Wins!"
- if not, continue to next player move.
- at the end of the game ask the user if would play again
- if yes start again
- if not end the game

How to Plan for the Gomoku Assessmentg
* Detailed planning process
* 1- Human or Random
    * Review the game rules (you don't have to implement the rules for the game but it helps to understand how the basic mechanics of the game works)
    * Review the notes in the instructions about the provided code
    * Review the provided requirements
    * Review the provided sample UI
    * Review and document the provided code (more about this in the next session)
    * Describe the flow through the UI
    * Think about the classes and methods you'll need to implement the UI
    * Document any "known unknowns" and describe the steps that you'll take to turn these "unknowns" into "knowns"
    * For inspiration, review the Roguelike lab
    * You'll need to write one or two classes and instance methods on those classes, but you shouldn't need any base or parent classes or interfaces
    * You also don't need to write any new unit tests (unless you find that to be helpful to confirm your understanding of the provided code)
* Questions that you should be asking yourself...

    * What are the steps that need to be completed to set up a game?
    - Run a gomoku game: 
    * 1- Create the players 
    * 2- Create the board
    * 
    * What are the steps that need to be completed for a player turn?
    * - Display the name of the player whose turn it is
    * 
    * What are the steps that need to be completed to end a game?
      - the place() method must be called correctly because 
      - It checks if a player's move will result in a win or draw
    * 
    * How will you prompt the user for their player type and information?
     - Scanner to get input 
  
    * How will I determine if the player is a human or random player? (hint: you don't need to use the `instanceof` operator)
    - check the user input if equal 1 = human.
    - check the user input if equal 2 = Random Player.
    * How will you let the player know that it's their turn?
      -Print the current player name.
    * 
    * How do you know if a stone placement was successful or not?
     -the place() method determines if a stone placement was successful
    * 
    * How will you re-prompt the user for their stone placement until it's successful?
    - Verification inside the Place method(). 
    * 
    * How often do you need to render the game board?
     - After each successful move.
    * 
    * How will you render the game board?
     - Loop to print the 2D array in the gomoku class board field.
     - Change start position add one to the index instead of print 14 it will display 15
    * 
    * How will you know if a location on the game board contains a stone?
    *  
     - I need to use a loop to check if the row x and colm y been checked before by a player.
  
    * How do you determine the color of the stone?
    * 
    * - if isBlack return true
    * - else should be white
    * - x -->  black stone
    * - o -->  White stone
  
* Write out a list of tasks
    * Review your planning and identify distinct units of work
    * What order do the tasks need to be completed in?
    * Are there dependencies between tasks? Document them.
    * What tasks need to be completed to create an MVP (minimal viable product)?
    * Estimate each task
    * Document how long each task actually takes
* Review and document the provided code
    * Review the unit tests
    * Read the comments within each test
    * Set a break point within each method, debug each unit test, step through each line of code
    * Pay close attention to how a method modifies the internal state of its class
* You can't change the provided code, but feel free to add your own comments to the code describing what each line (or section) or code does
    * Optionally add javadoc comments to each method
* Confirm your understanding of the provided code by writing temporary code (i.e. a "proof of concept" or "POC") in the `App` class to play a game (without requiring any user interaction)
    * Look at the code in the unit tests for clues on what classes and methods to use to play a complete game
### The Tao of Gomoku
* Don't maintain state that the `Gomoku` class tracks for you
    * Identify all of the state that the `Gomoku` class tracks
    * Use the debugger to show that state when playing the POC
* Be one with the `Player` interface; use the interface
    * Demonstrate that a `HumanPlayer` and `RandomPlayer` can be assigned to a `Player` variable
    * Demonstrate that the behavior of `Player` type can be used to tell you what you need to do next in your code
* Use the `Result` object that's returned to you after attempting to place a stone
    * Review the `Result` type
    * Talk about why the Result type was introduced (if necessary, implement a similar pattern in Capsule Hotel)
* **You don't need a 2D array to render the game board**
    * In fact, you don't need to maintain any state at all as the Gomoku class maintains all of the game board state for you
    * Think back to Roguelike...
        * How was the map rendered?
        * How did we determine if a treasure was a specific location on the map?
        * Can you apply that technique here?
### Strategy
* Plan time to review the provided code
    * Don't try to do this all in one long sitting
    * Break this work up into chunks and spread it out over the first day
* Don't allow yourself to get stuck on a single task
    * Identify the top 4-5 tasks for your project
    * When you get stuck (or tired of working on something), 
    * move onto another task 
    * (allow you brain to background process what you're currently stuck on)

# Plan for Testing the Program

The test plan lays out the actions and data I will use to test the functionality of my program.

Terminology:

- **VALID** data values are those that the program expects
- **BOUNDARY** data values are at the limits of the valid range
- **INVALID** data values are those that the program should reject

---
## Starter
The counter is the starting point of the game.

## Test data used

The current location of the player at the start of the game.

## Expected Test Result

The player should see "Counter" at the start of the game.

## Movement check
### Move north

Check whether the player has moved north.

### Test data used

Clicking the north button and the game map

### Expected result

After the player clicks the north button, the current location display should be the location in the north direction.

### Move east

Check whether the player has moved east.

### Test data used

The input of clicking "▶" button and the game map

### Expected result

After clicking "▶" button, the location display is changed to the location on the east.

### Move south

Check whether the player has moved south.

### Test data used

Clicking the south button and the game map.

### Expected result

After clicking the south button, the location display is changed to the location on the south.

### Move west

Check whether the player has moved west

### Test data used

Clicking the west button and the game map.

### Expected result

After clicking the west button, the location display is changed to the location on the west.

[//]: # (-------------------------------------------------------------------------------------------------------------------------------)


## Out of bound check

Check whether the player is attempting to move out of bound or not (somewhere on the map that does not exist).

### Test Data To Use

Try moving the player to somewhere out of bound. The system will crash down if the check added does not work.

### Expected Test Result

If the player tries to move out of bound, there should be a warning message popping up and/or the button for that direction as soon as there is no location in that direction (but that will make it too easy for the player because they will know which direction not to go)
Otherwise, the player should be able to move freely.

---

## Recipe check

### Showing recipe
A recipe, which has a list of ingredients a player is required to collected is shown.

### Test Data To Use
Adding a recipe to the program

### Expected Test Result
A list of things need for the recipe will be shown on the left of the interface.

### Recipe's randomisation
The recipe should e randomized after each round.

### Test Data To Use
Different lists of recipes

### Expected Test Result
After the player have won the round, the recipe is changed to another random recipe i.e. things need for that recipe will be dofferent.

### Items found
The player has entered the room that has got the item required in the recipe.

### Data To Use
Items the map, recipe, and the movement of the player

### Expected Test Result
The text of the name of that item on the recipe turns green and the bell sound is played. This shows that the player have found that item after entering that room and is now allowed to move on to the next item on the list.

### Order of items
The player is required to collect each item from the recipe list in order

### Test Data To Use
Text of the item name on the list and the movement of the player on the map

### Expected Test Result
If the first item has not been found yet, then eventhough the player has entered a room with the item that is the second on the list, then the text still remains white. It indicates that the list has not been moved on to the next item, and that the player is required to find the first item.


### Recipe finished
The player has completed the recipe i.e. the player has collected everything need from the list.

### Data To Use
Try collecting last thing from the recipe and observe what happen

### Expected Test Result
The sound "Tada" or congratulations sound kind of like plays, another random recipe is generated.

## How to play button
How to play button is displayed and can tell the player about how to play this game.

## Data To Use
Pop up window with a brief instruction on how to play and clicking on that button

## Expected Test Result
A pop up window with an instruction text appears when the How to play button is clicked and the player must hit the cross button to exit the window.

## Play button
The player clicks play button when they want to start the game.

## Data To Use
Clicking the play button

## Expected Test Result
The movement button are disabled before the play button is clicked. Once it is clicked, the movement button are enabled and the play button becomes disabled.

## Timer

### Countdown time
Timer is displayed as countdown i.e. the time goes down by 1 second

### Data To Use
The timer label shown on the interface

### Expected Test Result
The time should go down by 1 every second

### Time limit
The time limit becomes lesser and lesser after the player has completed each recipe to challenge the player.

### Data To Use
The timer label with a first time limit as 120 seconds

### Expected Test Result
The time shown should be reduced by 20% after the player has completed the recipe. In this case the time should be 0.8*120 = 96 seconds.

## Score

### Item's score
The player earns some scores when they have collected items.

### Data To Use
Score is shown as 0 at the start of the game and 10 scores worth for each item. Try moving into the room with the item need.

### Expected Test Result
The score changes from 0 to 10.

## Recipe's score
The player earns some scores after completing a recipe.

### Data To Use
Score is shown as 0 at the start of the game and each recipe completed worth 100 scores. Try collecting all the items need.

### Expected Test Result
The score changes from 0 to 100 plus the scores from items collected.

## End of the game
The game ends once the player cannot complete the recipe before the timer runs out.

## Data To Use
Timer reaches 0

## Expected Test Result
A pop up window appears. It shows a congratulations message, the player's score, and a play again button.

## Play again button
The player can click the play again button that appears on the pop up window.

## Data To Use
Clicking the play again button

## Expected Test Result
The pop up window disappear and the game reset and starts straight away (the time limit is set back as 120 seconds, the player has no score and is placed at the counter which is the starter point on the map).

## Reset the game
This is when the player hit the cross button on the pop up window after the game has finished.

## Data To Use
Hitting the cross button to exit the ending pop up window.

## Expected Test Result
Everything is reset, including the movement buttons being disabled. The game has not started yet.

##



---



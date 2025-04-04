# Plan for Testing the Program

The test plan lays out the actions and data I will use to test the functionality of my program.

Terminology:

- **VALID** data values are those that the program expects
- **BOUNDARY** data values are at the limits of the valid range
- **INVALID** data values are those that the program should reject

---
## Starter

The player should start at the counter.

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

## Example Test Name

Example test description. Example test description. Example test description. Example test description. Example test description. Example test description.

### Test Data To Use

Details of test data and reasons for selection. Details of test data and reasons for selection. Details of test data and reasons for selection.

### Expected Test Result

Statement detailing what should happen. Statement detailing what should happen. Statement detailing what should happen. Statement detailing what should happen.

---



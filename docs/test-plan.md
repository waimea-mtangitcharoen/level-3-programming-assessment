# Plan for Testing the Program

The test plan lays out the actions and data I will use to test the functionality of my program.

Terminology:

- **VALID** data values are those that the program expects
- **BOUNDARY** data values are at the limits of the valid range
- **INVALID** data values are those that the program should reject

---

## Out of bound check

Check whether the player is attempting to move out of bound or not (somewhere on the map that does not exist)

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



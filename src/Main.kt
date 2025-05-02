/**
 * =====================================================================
 * Programming Project for NCEA Level 3, Standard 91906
 * ---------------------------------------------------------------------
 * Project Name:   PROJECT NAME HERE
 * Project Author: Chittranuch Tangitcharoen (Mimi)
 * GitHub Repo:    https://github.com/waimea-mtangitcharoen/level-3-programming-assessment
 * ---------------------------------------------------------------------
 * Notes: Whatever is written on readme.
 * PROJECT NOTES HERE
 * =====================================================================
 */



import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.sound.sampled.AudioSystem
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    val app = App()         // Create the app model
    MainWindow(app)         // Create and show the UI, using the app model




}

/**
 * The location class
 * This contains fields and variables that
 * will indicate the relationship of locations
 */
class Location(
    val name:String,
    val description:String,
    var north: Int? = null,
    var east: Int? = null,
    var south: Int? = null,
    var west: Int? = null,
    val itemName: String? = null,
)



/**
 * The application class (model)
 * This is the place where any application data should be
 * stored, plus any application logic functions
 */
class App() {
    val INITIAL_TIME_LIMIT = 120
    val TIME_LIMIT_ADJUST = 0.8
    var timeLimit = INITIAL_TIME_LIMIT
    var time = timeLimit

    val ITEM_SCORE = 10
    val RECIPE_SCORE = 100

    val locationList = mutableListOf<Location>()
    var currentLocation = 0

    val recipes = mutableListOf<List<String>>()

    // List of recipes for ice cream orders
    var recipe1 = listOf("Cone", "Ice cream", "Gummy bear", "Strawberry sauce")
    var recipe2 = listOf("Paper cup", "Ice cream", "Whip cream", "Sprinkle")
    var recipe3 = listOf("Cone", "Soft-serve", "Cherry")
    var recipe4 = listOf("Paper cup", "Soft-serve", "Cookie", "Chocolate")
    var recipe5 = listOf("Boat", "Ice cream", "Almonds", "Whip cream", "Cherry")
    var recipe6 = listOf("Cookie", "Soft-serve", "Sprinkle")
    var recipe7 = listOf("Cone", "Almonds", "Soft-serve", "Gummy bear")
    var recipe8 = listOf("Boat", "Chocolate", "Whip cream", "Ice cream", "Cone")
    var recipe9 = listOf("Cookie", "Strawberry sauce", "Ice cream", "Whip cream")
    var recipe10 = listOf("Marshmallow", "Soft-serve", "Cone", "Cherry")
    var recipe11 = listOf("Cone", "Ice cream", "Pretzel", "Brownie")
    var recipe12 = listOf("Brownie", "Whip cream", "Ice cream", "Strawberry sauce")

    // Recipes for an order will be randomised
    var currentRecipe: List<String>

    // Set to true when a new recipe should be loaded on the next timer beat
    var loadNewRecipe = false

    // Tracks the item we are looking for within the recipe
    var currentItem = 0
    // Track the score, initial score is 0
    var score = 0


    init {
        setupMap()

        recipes.add(recipe1)
        recipes.add(recipe2)
        recipes.add(recipe3)
        recipes.add(recipe4)
        recipes.add(recipe5)
        recipes.add(recipe6)
        recipes.add(recipe7)
        recipes.add(recipe8)
        recipes.add(recipe9)
        recipes.add(recipe10)
        recipes.add(recipe11)
        recipes.add(recipe12)

        currentRecipe = recipes.random()
    }

    // To start a game all over again
    fun resetGame() {
        timeLimit = INITIAL_TIME_LIMIT
        time = timeLimit
        currentRecipe = recipes.random()
        currentItem = 0
        currentLocation = 0
        score = 0
    }

    // For playing a sound file
    fun playSound(file: String) {
        val soundFile = this::class.java.getResourceAsStream("sounds/$file.wav")
        val soundStream = AudioSystem.getAudioInputStream(soundFile)
        val soundClip = AudioSystem.getClip()
        soundClip.open(soundStream)
        soundClip.start()
    }

    // Create location and define the connection
    fun setupMap() {
        locationList.add(Location("Counter", "This is where your order will be placed.", 1, 8, null, 14,""))  // 0
        locationList.add(Location("Fridge", "You can collect ice cream from here", null, 2,0,null, "Ice cream")) // 1
        locationList.add(Location("Chocolate room", "You can collect chocolates from here", 3,null,null,1, "Chocolate")) // 2
        locationList.add(Location("Fruit bar", "You can collect fruits here",4,null,2,15, "Cherry")) // 3
        locationList.add(Location("Topping station", "You can collect some sprinkles here", null,6,3,5,"Sprinkle")) // 4
        locationList.add(Location("Soft-serve machine", "You can collect soft-serve here",null,4,null,null, "Soft-serve")) // 5
        locationList.add(Location("Cookies cupboard", "You can collect cookies here", 7,null,null,4,"Cookie")) // 6
        locationList.add(Location("Dish washer", "You can collect boat here", null,null,6,16,"Boat")) // 7
        locationList.add(Location("Paper cupboard", "You can collect paper cup here", null,11,9,0,"Paper cup")) // 8
        locationList.add(Location("Cone room", "You can collect cones here", 8,13,10,null, "Cone")) //9
        locationList.add(Location("Candy storage", "You can collect candies here",9,13,null,null,"Gummy bear")) //10
        locationList.add(Location("Sauce fountain", "You can put sauces on in here", 12,null,null,8, "Strawberry sauce")) //11
        locationList.add(Location("Dairy fridge", "You can collect dairy stuff here", null,null,11,null,"Whip cream")) //12
        locationList.add(Location("Nuts cupboard", "You can collect almonds here",null,null,null,10, "Almonds"))//13
        locationList.add(Location("Brownie bay", "You can collect brownies here", null,0,null,null, "Brownie")) //14
        locationList.add(Location("Pretzel station", "You can collect pretzels here", null, 3,null,null,"Pretzel")) //15
        locationList.add(Location("Marshmallow cabin", "You can collect your marshmallow here", null,7,null,null,"Marshmallow"))
    }

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Movement functions
    fun moveNorth() {
        //If there is  location in the north then move to that location
        if (locationList[currentLocation].north != null)
            currentLocation = locationList[currentLocation].north!!
    }

    fun moveSouth() {
        if (locationList[currentLocation].south != null)
            currentLocation = locationList[currentLocation].south!!
    }

    fun moveEast() {
        if (locationList[currentLocation].east != null)
            currentLocation = locationList[currentLocation].east!!
    }

    fun moveWest() {
        if (locationList[currentLocation].west != null)
            currentLocation = locationList[currentLocation].west!!
    }

 //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Is there an item in that location that the player needs
    fun checkIfRoomHasItem(): Boolean {
        //If the item in that room matches the one required on the recipe
        if (currentRecipe[currentItem] == locationList[currentLocation].itemName) {
            playSound("bell")
            score += ITEM_SCORE
            return true
        }
        return false
    }

    // Will return True if recipe complete
    fun moveOnToNextItem() {
        currentItem++
        if (currentItem == currentRecipe.size) {
            score += RECIPE_SCORE
            playSound("tada")
            // Set a flag so that a new recipe is loaded next clock tick
            loadNewRecipe = true
        }
    }

    //If one recipe is done, randomized another one
    fun getNewRecipe() {
        currentRecipe = recipes.random()
        currentItem = 0

        // Adjust time to speed up the next challenge
        timeLimit = (timeLimit * TIME_LIMIT_ADJUST).toInt()
        time = timeLimit
    }

}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow(val app: App) : JFrame(), ActionListener, KeyListener {

    // Fields to hold the UI elements
    private lateinit var clicksLabel: JLabel
    private lateinit var clickButton: JButton
    private lateinit var titleLabel: JLabel
    private lateinit var howToPlayButton: JButton
    private lateinit var playButton: JButton

    private lateinit var northButton: JButton
    private lateinit var southButton: JButton
    private lateinit var eastButton: JButton
    private lateinit var westButton: JButton

    private lateinit var currentLocationLabel: JLabel
    private lateinit var currentDescriptionLabel: JLabel

    private lateinit var item1Label: JLabel
    private lateinit var item2Label: JLabel
    private lateinit var item3Label: JLabel
    private lateinit var item4Label: JLabel
    private lateinit var item5Label: JLabel

    private lateinit var timerLabel: JLabel
    private lateinit var scoreLabel: JLabel

    private lateinit var howToPlayPopUp: HowToPlayDialogue
    private lateinit var endGamePopUp: EndGameDialogue
    private lateinit var countdownTimer: Timer


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI


        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible

        updateView()                    // Initialise the UI
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Sweet sundae"
        contentPane.preferredSize = Dimension(600, 350)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val baseFont = Font(Font.SANS_SERIF, Font.PLAIN, 20)
        val midFont = Font(Font.SANS_SERIF, Font.PLAIN, 14)
        val higherMidFont = Font(Font.SANS_SERIF, Font.PLAIN, 16)
        val smallFont = Font(Font.SANS_SERIF, Font.PLAIN, 10)

        this.addKeyListener(this)

        howToPlayPopUp = HowToPlayDialogue()
        endGamePopUp = EndGameDialogue(app, this)

        titleLabel = JLabel("<html><strong> Welcome to Sweet Sundae!")
        titleLabel.font = baseFont
        titleLabel.bounds = Rectangle(150,10,300,50)
        titleLabel.foreground = Color.WHITE
        titleLabel.horizontalAlignment = SwingConstants.CENTER
        add(titleLabel)

        howToPlayButton = JButton("How to play")
        howToPlayButton.font = smallFont
        howToPlayButton.foreground = Color.black
        howToPlayButton.background = Color(197, 231, 237)
        howToPlayButton.bounds = Rectangle(80,85,100,20)
        howToPlayButton.addActionListener(this)
        howToPlayButton.isFocusable = false
        add(howToPlayButton)

        playButton = JButton("Play")
        playButton.font = smallFont
        playButton.foreground = Color.black
        playButton.background = Color(91, 199, 195)
        playButton.bounds = Rectangle(80,110,100,20)
        playButton.isFocusable = false
        playButton.addActionListener(this)
        add(playButton)

        northButton = JButton("▲")
        northButton.bounds = Rectangle(400,180,60,60)
        northButton.addActionListener(this)
        northButton.isFocusable = false
        add(northButton)

        southButton = JButton("▼")
        southButton.bounds = Rectangle(400,240,60,60)
        southButton.addActionListener(this)
        southButton.isFocusable = false
        add(southButton)

        westButton = JButton("◀")
        westButton.bounds = Rectangle(340,240,60,60)
        westButton.addActionListener(this)
        westButton.isFocusable = false
        add(westButton)

        eastButton = JButton("▶")
        eastButton.bounds = Rectangle(460,240,60,60)
        eastButton.addActionListener(this)
        eastButton.isFocusable = false
        add(eastButton)

        currentLocationLabel = JLabel("Counter")
        currentLocationLabel.bounds = Rectangle(330,70,200,50)
        currentLocationLabel.foreground = Color.white
        currentLocationLabel.horizontalAlignment = SwingConstants.CENTER
        currentLocationLabel.font = baseFont
        add(currentLocationLabel)

        currentDescriptionLabel = JLabel("This is where your order will be place!")
        currentDescriptionLabel.bounds = Rectangle(330, 110, 200,50)
        currentDescriptionLabel.font = smallFont
        currentDescriptionLabel.horizontalAlignment = SwingConstants.CENTER
        currentDescriptionLabel.foreground = Color.white
        add(currentDescriptionLabel)

        item1Label = JLabel("ITEM 1")
        item1Label.font = midFont
        item1Label.bounds = Rectangle(80,150,250,50)
        add(item1Label)

        item2Label = JLabel("ITEM 2")
        item2Label.font = midFont
        item2Label.bounds = Rectangle(80,180,250,50)
        add(item2Label)

        item3Label = JLabel("ITEM 3")
        item3Label.font = midFont
        item3Label.bounds = Rectangle(80,210,250,50)
        add(item3Label)

        item4Label = JLabel("ITEM 4")
        item4Label.font = midFont
        item4Label.bounds = Rectangle(80,240,250,50)
        add(item4Label)

        item5Label = JLabel("ITEM 5")
        item5Label.font = midFont
        item5Label.bounds = Rectangle(80,270,250,50)
        add(item5Label)

        timerLabel = JLabel("<html> <strong> Time: </strong> <br> ${app.INITIAL_TIME_LIMIT}")
        timerLabel.foreground = Color.white
        timerLabel.font = higherMidFont
        timerLabel.bounds = Rectangle(195,80,250,50)
        timerLabel.background = Color.white
        add(timerLabel)

        scoreLabel = JLabel("Score: 0")
        scoreLabel.foreground =  Color.WHITE
        scoreLabel.font = higherMidFont
        scoreLabel.bounds = Rectangle(255,80,250,50)
        scoreLabel.background = Color.ORANGE
        add(scoreLabel)

        countdownTimer = Timer(1000,this)

    }

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Update the UI controls based on the current state
     * of the application model
     */
    fun updateView() {

        this.requestFocus()

        // Have we found the thing we are looking for?
        val foundItem = app.checkIfRoomHasItem()

        //Showing where the player is
        currentLocationLabel.text = app.locationList[app.currentLocation].name

        //Changing the description and adding a small text once the item is founded
        currentDescriptionLabel.text = if (foundItem) {
            "<html>${app.locationList[app.currentLocation].description}\n\n<br><br>You have found your ${app.locationList[app.currentLocation].itemName}!"
        } else {
            app.locationList[app.currentLocation].description
        }
        //Changing the color of the description once the item is founded
        currentDescriptionLabel.foreground = if (foundItem) Color.GREEN else Color.WHITE

        // Have we found our current item?
        if (foundItem) {
            // Yes so move to next item and possibly recipe
            app.moveOnToNextItem()
        }

        //Showing the item name
        item1Label.text = if (app.currentRecipe.size > 0) app.currentRecipe[0] else ""
        //Changing text color when item is found.
        item1Label.foreground = if (app.currentItem > 0) Color.GREEN else Color.WHITE

        item2Label.text = if (app.currentRecipe.size > 1) app.currentRecipe[1] else ""
        item2Label.foreground = if (app.currentItem > 1) Color.GREEN else Color.WHITE

        item3Label.text = if (app.currentRecipe.size > 2) app.currentRecipe[2] else ""
        item3Label.foreground = if (app.currentItem > 2) Color.GREEN else Color.WHITE

        item4Label.text = if (app.currentRecipe.size > 3) app.currentRecipe[3] else ""
        item4Label.foreground = if (app.currentItem > 3) Color.GREEN else Color.WHITE

        item5Label.text = if (app.currentRecipe.size > 4) app.currentRecipe[4] else ""
        item5Label.foreground = if (app.currentItem > 4) Color.GREEN else Color.WHITE

        if (countdownTimer.isRunning) {
            playButton.isEnabled  = false
            northButton.isEnabled = true
            eastButton.isEnabled  = true
            southButton.isEnabled = true
            westButton.isEnabled  = true
        }
        else {
            playButton.isEnabled  = true
            northButton.isEnabled = false
            eastButton.isEnabled  = false
            southButton.isEnabled = false
            westButton.isEnabled  = false
        }

        // Show the score
        scoreLabel.text = "<html> <strong> Score: </strong> <br> ${app.score.toString()}"
    }

    /**
     * Update just the time in the UI
     */
    fun updateTime() {
        timerLabel.text = "<html><strong> Time: </strong><br> ${app.time.toString()}"
    }


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Handle any UI events (e.g. button clicks)
     * Usually this involves updating the application model
     * then refreshing the UI view
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
              northButton ->{
                  app.moveNorth()
                  updateView()
              }

              southButton ->{
                  app.moveSouth()
                  updateView()
              }

              eastButton ->{
                  app.moveEast()
                  updateView()
              }

              westButton ->{
                  app.moveWest()
                  updateView()
              }

              howToPlayButton ->{
                  howToPlayPopUp.isVisible = true
              }

              playButton ->{
                  app.time = app.timeLimit
                  countdownTimer.start()
                  updateView()
              }

              countdownTimer -> {
                  app.time--
                  updateTime()

                  // Do we need to load a new recipe?
                  if (app.loadNewRecipe) {
                      app.getNewRecipe()
                      updateView()
                      app.loadNewRecipe = false
                  }

                  //What happen when time hit 0?
                  if (app.time == 0) {
                      countdownTimer.stop()
                      app.playSound("congratulations")
                      updateView()
                      endGamePopUp.updateView()
                      endGamePopUp.isVisible = true

                  }
              }
        }
    }



    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Handle pressing keys
    override fun keyTyped(e: KeyEvent?) {

    }

    override fun keyPressed(e: KeyEvent?) {
        when (e?.keyCode) {
        KeyEvent.VK_UP    -> app.moveNorth()
        KeyEvent.VK_DOWN  -> app.moveSouth()
        KeyEvent.VK_LEFT  -> app.moveWest()
        KeyEvent.VK_RIGHT -> app.moveEast()
        }
        updateView()
    }

    override fun keyReleased(e: KeyEvent?) {

    }

}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/**
 * Specially for the instruction pop up
 */
class HowToPlayDialogue(): JDialog() {
    /**
     * Configure the UI
     */
    init {
        configureWindow()
        addControls()
        setLocationRelativeTo(null)     // Centre the window
    }

    /**
     * Setup the dialog window
     */
    private fun configureWindow() {
        title = "How to Play"
        contentPane.preferredSize = Dimension(450, 300)
        isResizable = false
        isModal = true
        layout = null
        pack()
    }

    /**
     * Populate the window with controls
     */
    private fun addControls() {
        val baseFont = Font(Font.SANS_SERIF, Font.PLAIN, 11)

        // Adding <html> to the label text allows it to wrap
        val instruction = JLabel("<html> <strong> How to play? </strong> You are working at an ice cream shop today and your job is to complete those ice cream orders! All you need to do is collect the things you need for the recipe shown on the left. Here's a brief tips and instruction for you:<br><br> 1. Use the buttons below to move around the map and be sure to remember where you are going! <br><br> 2. Collect the things you need, and once you have collected it, that ingredient will turn green <br><br> 3. Use your time WISELY! Otherwise you will fail to complete the order. ")
        instruction.bounds = Rectangle(50, 10, 350, 250)
        instruction.horizontalAlignment = SwingConstants.CENTER
        instruction.font = baseFont
        add(instruction)
    }
}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/**
 * Class for the pop up once time hits 0
 */
class EndGameDialogue(val app: App, val mainWindow: MainWindow): JDialog(), ActionListener {

    private lateinit var finishScoreLabel: JLabel
    private lateinit var playAgainButton: JButton

    init {
        configureWindow()
        addControls()
        setLocationRelativeTo(null)     // Centre the window
    }

    /**
     * Setup the dialog window
     */
    private fun configureWindow() {
        title = "End game"
        contentPane.preferredSize = Dimension(450, 300)
        isResizable = false
        isModal = true
        layout = null
        pack()
    }

    private fun addControls() {
        val baseFont = Font(Font.SANS_SERIF, Font.BOLD, 20)

        // Adding <html> to the label text allows it to wrap
        val congratsMessage = JLabel("CONGRATULATIONS!")
        congratsMessage.bounds = Rectangle(150, 30, 300, 50)
        congratsMessage.horizontalAlignment = SwingConstants.CENTER
        congratsMessage.foreground = Color.WHITE
        congratsMessage.font = baseFont
        add(congratsMessage)

        //Button on the pop-up to play again
        playAgainButton = JButton("Play Again")
        playAgainButton.bounds = Rectangle(150,200,150,30)
        playAgainButton.background = Color(91, 199, 195)
        playAgainButton.font = Font(Font.SANS_SERIF, Font.PLAIN, 14)
        playAgainButton.foreground = Color.black
        playAgainButton.addActionListener(this)
        add(playAgainButton)

        finishScoreLabel = JLabel("<html> You score = ")
        finishScoreLabel.font = Font(Font.SANS_SERIF, Font.PLAIN, 24)
        finishScoreLabel.bounds = Rectangle(145, 100, 300, 50)
        finishScoreLabel.foreground = Color.WHITE
        add(finishScoreLabel)
    }

    fun updateView() {
        finishScoreLabel.text = "<html> You score: ${app.score}"
//         ">&#127881 ".repeat(app.score)
    }

    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            playAgainButton -> {
                app.resetGame()
                mainWindow.updateView()
                mainWindow.updateTime()
                this.isVisible = false
            }
        }
    }

}






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
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    val app = App()         // Create the app model
    MainWindow(app)         // Create and show the UI, using the app model




}

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

    val locationList = mutableListOf<Location>()
    var currentLocation = 0

    init {
        setupMap()
    }

    // Create location and define the connection
    fun setupMap() {
        locationList.add(Location("Counter", "This is where your order will be placed.", 1, 8, null, null,""))  // 0
        locationList.add(Location("Fridge", "You can collect ice cream from here", null, 2,0,null, "Ice cream")) // 1
        locationList.add(Location("Chocolate room", "You can collect chocolates from here", 3,null,null,1, "Chocolate")) // 2
        locationList.add(Location("Fruit bar", "You can collect fruits here",4,null,2,null, "Cherry")) // 3
        locationList.add(Location("Topping station", "You can collect some sprinkles here", null,6,3,5,"Sprinkle")) // 4
        locationList.add(Location("Soft-serve machine room", "You can collect soft-serve here",null,4,null,null, "Soft serve")) // 5
        locationList.add(Location("Cookies cupboard", "You can collect cookies here", 7,null,null,4,"Cookie")) // 6
        locationList.add(Location("Dish room", "You can collect boat here", null,null,6,null,"Boat")) // 7
        locationList.add(Location("Paper cupboard", "You can collect paper cup here", null,11,9,0,"Paper cup")) // 8
        locationList.add(Location("Cone room", "You can collect cones here", 8,13,10,null, "Cone")) //9
        locationList.add(Location("Candy storage", "You can collect candies here",9,13,null,null,"Gummy bear")) //10
        locationList.add(Location("Sauce fountain", "You can put sauces on in here", 12,null,null,8, "Strawberry sauce")) //11
        locationList.add(Location("Dairy fridge", "You can collect dairy stuff here", null,null,11,null,"Whip cream")) //12
        locationList.add(Location("Nuts cupboard", "You can collect almonds here",null,null,null,10, "Almonds"))
    }

    fun moveNorth() {
        if (locationList[currentLocation].north != null) //If there is  location in that direction then move to that location
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

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    val recipes = mutableListOf<List<String>>()

    // Recipes for ice cream orders
    var recipe1 = listOf("Cone", "Ice cream", "Gummy bear", "Strawberry sauce")
    var recipe2 = listOf("Paper cup", "Ice cream", "Whip cream", "Sprinkle")
    var recipe3 = listOf("Cone", "Soft serve", "Cherry")

    init {
        recipes.add(recipe1)
        recipes.add(recipe2)
        recipes.add(recipe3)
    }

    // Recipes for an order will be randomised
    var currentRecipe = recipes.random()

    // Tracks the item we are looking for within the recipe
    var currentItem = 0

    fun checkIfRoomHasItem(): Boolean {
        return currentRecipe[currentItem] == locationList[currentLocation].itemName
    }

    // Will return True if recipe complete
    fun moveOnToNextItem(): Boolean {
        currentItem++
        if (currentItem == currentRecipe.size) {
            getNewRecipe()
            return true
        }
        else {
            return false
        }

    }

    fun getNewRecipe() {
        currentLocation = 0
        currentRecipe = recipes.random()
        currentItem = 0
    }


}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow(val app: App) : JFrame(), ActionListener {

    // Fields to hold the UI elements
    private lateinit var clicksLabel: JLabel
    private lateinit var clickButton: JButton
    private lateinit var instructionLabel: JLabel
    private lateinit var instructionButton: JButton
    private lateinit var northButton: JButton
    private lateinit var southButton: JButton
    private lateinit var eastButton: JButton
    private lateinit var westButton: JButton
    private lateinit var currentLabel: JLabel
    private lateinit var currentDescriptionLabel: JLabel
    private lateinit var item1Label: JLabel
    private lateinit var item2Label: JLabel
    private lateinit var item3Label: JLabel
    private lateinit var item4Label: JLabel
    private lateinit var item5Label: JLabel

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

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val baseFont = Font(Font.SANS_SERIF, Font.PLAIN, 36)

        instructionLabel = JLabel("<html><strong> Welcome to Sweet Sundae!")
        instructionLabel.font = Font(Font.SANS_SERIF, Font.PLAIN, 12)
        instructionLabel.bounds = Rectangle(30,20,250,50)
        add(instructionLabel)

        instructionButton = JButton("How to play")
        instructionButton.font = Font(Font.SANS_SERIF, Font.PLAIN, 10)
        instructionButton.foreground = Color.black
        instructionButton.background = Color(197, 231, 237)
        instructionButton.bounds = Rectangle(30,65,100,20)
        instructionButton.addActionListener(this)
        add(instructionButton)

        northButton = JButton("▲")
        northButton.bounds = Rectangle(400,180,60,60)
        northButton.addActionListener(this)
        add(northButton)

        southButton = JButton("▼")
        southButton.bounds = Rectangle(400,240,60,60)
        southButton.addActionListener(this)
        add(southButton)

        westButton = JButton("◀")
        westButton.bounds = Rectangle(340,240,60,60)
        westButton.addActionListener(this)
        add(westButton)

        eastButton = JButton("▶")
        eastButton.bounds = Rectangle(460,240,60,60)
        eastButton.addActionListener(this)
        add(eastButton)

        currentLabel = JLabel("Counter")
        currentLabel.bounds = Rectangle(330,60,200,50)
        currentLabel.foreground = Color.white
        currentLabel.horizontalAlignment = SwingConstants.CENTER
        currentLabel.font = Font(Font.SANS_SERIF, Font.PLAIN, 24)
        add(currentLabel)

        currentDescriptionLabel = JLabel("This is where your order will be place!")
        currentDescriptionLabel.bounds = Rectangle(330, 100, 200,50)
        currentDescriptionLabel.font = Font(Font.SANS_SERIF,Font.PLAIN,11)
        currentDescriptionLabel.horizontalAlignment = SwingConstants.CENTER
        currentDescriptionLabel.foreground = Color.white
        add(currentDescriptionLabel)

        item1Label = JLabel("ITEM 1")
        item1Label.font = Font(Font.SANS_SERIF, Font.PLAIN, 12)
        item1Label.bounds = Rectangle(30,120,250,50)
        add(item1Label)

        item2Label = JLabel("ITEM 2")
        item2Label.font = Font(Font.SANS_SERIF, Font.PLAIN, 12)
        item2Label.bounds = Rectangle(30,150,250,50)
        add(item2Label)

        item3Label = JLabel("ITEM 3")
        item3Label.font = Font(Font.SANS_SERIF, Font.PLAIN, 12)
        item3Label.bounds = Rectangle(30,180,250,50)
        add(item3Label)

        item4Label = JLabel("ITEM 4")
        item4Label.font = Font(Font.SANS_SERIF, Font.PLAIN, 12)
        item4Label.bounds = Rectangle(30,210,250,50)
        add(item4Label)

        item5Label = JLabel("ITEM 5")
        item5Label.font = Font(Font.SANS_SERIF, Font.PLAIN, 12)
        item5Label.bounds = Rectangle(30,240,250,50)
        add(item5Label)



    }


    /**
     * Update the UI controls based on the current state
     * of the application model
     */
    fun updateView() {

        currentLabel.text = app.locationList[app.currentLocation].name
        currentDescriptionLabel.text = if (app.checkIfRoomHasItem()) "You have found your ${app.locationList[app.currentLocation].itemName}!" else app.locationList[app.currentLocation].description
        currentDescriptionLabel.foreground = if (app.checkIfRoomHasItem()) Color.GREEN else Color.WHITE

        // Have we found our current item?
        if (app.checkIfRoomHasItem()) {
            app.moveOnToNextItem()
        }


        item1Label.text = if (app.currentRecipe.size > 0) app.currentRecipe[0] else ""
        item1Label.foreground = if (app.currentItem > 0) Color.GREEN else Color.WHITE

        item2Label.text = if (app.currentRecipe.size > 1) app.currentRecipe[1] else ""
        item2Label.foreground = if (app.currentItem > 1) Color.GREEN else Color.WHITE

        item3Label.text = if (app.currentRecipe.size > 2) app.currentRecipe[2] else ""
        item3Label.foreground = if (app.currentItem > 2) Color.GREEN else Color.WHITE

        item4Label.text = if (app.currentRecipe.size > 3) app.currentRecipe[3] else ""
        item4Label.foreground = if (app.currentItem > 3) Color.GREEN else Color.WHITE

        item5Label.text = if (app.currentItem > 4) app.currentRecipe[4] else ""
        item5Label.foreground = if (app.currentItem > 5) Color.GREEN else Color.WHITE

    }

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
//            clickButton -> {
//                app.updateClickCount()
//                updateView()
//            }
        }
    }

}


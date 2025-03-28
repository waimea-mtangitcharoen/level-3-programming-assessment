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

    fun setupMap() {
        locationList.add(Location("Counter", "This is where your order will be placed.", 1, null, null, null,""))  // 0
        locationList.add(Location("Fridge", "You can collect ice cream from here", null, 2,0,null, "ice cream")) // 1
        locationList.add(Location("Chocolate room", "You can collect chocolates from here", 3,null,null,1   )) // 2
        locationList.add(Location("Fruit bar", "You can collect fruits here",4,null,2,null, "cherry")) // 3
        locationList.add(Location("Topping station", "You can collect some sprinkles here", null,6,3,5,"sprinkle")) // 4
        locationList.add(Location("Soft-serve machine room", "You can collect soft-serve here",null,4,null,null, "soft serve")) // 5
        locationList.add(Location("Cookies cupboard", "You can collect cookies here", 7,null,null,4,"cookie")) // 6
        locationList.add(Location("Dish room", "You can collect boat here", null,null,6,null,"boat")) // 7
        locationList.add(Location("Paper cupboard", "You can collect paper cup here", null,11,9,0,"paper cup")) // 8
        locationList.add(Location("Cone room", "You can collect cones here", 8,null,10,null, "cone")) //9
        locationList.add(Location("Candy storage", "You can collect candies here",8,null,10,null,"gummy bear")) //10
        locationList.add(Location("Sauce fountain", "You can put sauces on in here", 12,null,null,8, "strawberry sauce")) //11
        locationList.add(Location("Dairy fridge", "You can collect dairy stuff here", null,null,11,null,"whip cream")) //12
    }



    fun moveNorth() {
        currentLocation = locationList[currentLocation].north!!
    }

    fun moveSouth() {
        currentLocation = locationList[currentLocation].south!!
    }

    fun moveEast() {
        currentLocation = locationList[currentLocation].east!!
    }

    fun moveWest() {
        currentLocation = locationList[currentLocation].west!!
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
    private lateinit var recipeLabel: JLabel

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

        eastButton = JButton("◀")
        eastButton.bounds = Rectangle(340,240,60,60)
        eastButton.addActionListener(this)
        add(eastButton)

        westButton = JButton("▶")
        westButton.bounds = Rectangle(460,240,60,60)
        westButton.addActionListener(this)
        add(westButton)

        currentLabel = JLabel("Counter")
        currentLabel.bounds = Rectangle(370,40,200,100)
        currentLabel.foreground = Color.white
        currentLabel.font = Font(Font.SANS_SERIF, Font.PLAIN, 36)
        add(currentLabel)


//        clicksLabel = JLabel("CLICK INFO HERE")
//        clicksLabel.horizontalAlignment = SwingConstants.CENTER
//        clicksLabel.bounds = Rectangle(50, 50, 500, 100)
//        clicksLabel.font = baseFont
//        add(clicksLabel)

//        clickButton = JButton("Click Me!")
//        clickButton.bounds = Rectangle(50,200,500,100)
//        clickButton.font = baseFont
//        clickButton.addActionListener(this)     // Handle any clicks
//        add(clickButton)


    }


    /**
     * Update the UI controls based on the current state
     * of the application model
     */
    fun updateView() {

        currentLabel.text = app.locationList[app.currentLocation].name

//        if (app.clicks == app.MAX_CLICKS) {
//            clicksLabel.text = "Max clicks reached!"
//            clickButton.isEnabled = false
//        }
//        else {
//            clicksLabel.text = "You clicked ${app.clicks} times"
//            clickButton.isEnabled = true
//        }
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


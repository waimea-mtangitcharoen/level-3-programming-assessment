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

class Location(val name:String, val description:String, val itemName: String)


/**
 * The application class (model)
 * This is the place where any application data should be
 * stored, plus any application logic functions
 */
class App() {

    val locationList = mutableListOf<Location>()

    init {
        setupMap()
    }

    fun setupMap() {
        locationList.add(Location("Fridge", "Cold", "Ice cream"))
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
    private lateinit var upButton: JButton
    private lateinit var downButton: JButton
    private lateinit var leftButton: JButton
    private lateinit var rightButton: JButton
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

        upButton = JButton("▲")
        upButton.bounds = Rectangle(400,180,60,60)
        upButton.addActionListener(this)
        add(upButton)

        downButton = JButton("▼")
        downButton.bounds = Rectangle(400,240,60,60)
        downButton.addActionListener(this)
        add(downButton)

        leftButton = JButton("◀")
        leftButton.bounds = Rectangle(340,240,60,60)
        leftButton.addActionListener(this)
        add(leftButton)

        rightButton = JButton("▶")
        rightButton.bounds = Rectangle(460,240,60,60)
        rightButton.addActionListener(this)
        add(rightButton)

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

        instructionLabel.text = app.locationList[0].name

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
//            clickButton -> {
//                app.updateClickCount()
//                updateView()
//            }
        }
    }

}


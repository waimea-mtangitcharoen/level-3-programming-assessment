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


/**
 * The application class (model)
 * This is the place where any application data should be
 * stored, plus any application logic functions
 */
class App() {
//    // Constants defining any key values
//    val MAX_CLICKS = 10
//
//    // Data fields
//    var clicks = 0
//
//    // Application logic functions
//    fun updateClickCount() {
//        clicks++
//        if (clicks > MAX_CLICKS) clicks = MAX_CLICKS
//    }
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
    private lateinit var upButton: JButton
    private lateinit var downButton: JButton
    private lateinit var leftButton: JButton
    private lateinit var rightButton: JButton

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

        instructionLabel = JLabel("Welcome to Sweet Sundae! Many customers visit Sunny city's ice cream shop a day, so your job is to complete those orders! To do so:" +
                "1. You are allowed to move around the map freely using the buttons (unless out of bounds!)" +
                "2. To complete the order, collect all the ingredients required in the recipe in time. " +
                "Tips: Remember where things are!"    )

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


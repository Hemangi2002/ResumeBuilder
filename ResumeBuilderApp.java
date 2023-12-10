import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.*;
//Author: Hemangee Kanse
public class ResumeBuilderApp extends JFrame implements Printable {
    private JTextField nameField, dobField;
    private JTextArea profileSummaryArea, projectDetailsArea, experienceArea, skillsArea;
    private JButton printButton;

    private JTextField sscCourseField, sscSchoolField, sscYearField, sscPercentageField;
    private JTextField hscCourseField, hscSchoolField, hscYearField, hscPercentageField;
    private JTextField bachelorsCourseField, bachelorsSchoolField, bachelorsYearField, bachelorsPercentageField;
    private JTextField postgradCourseField, postgradSchoolField, postgradYearField, postgradPercentageField;

    public ResumeBuilderApp() {
        // Set up the main frame
        setTitle("Resume Builder");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        nameField = new JTextField(20);
        dobField = new JTextField(20);
        profileSummaryArea = new JTextArea(5, 20);
        projectDetailsArea = new JTextArea(5, 20);
        experienceArea = new JTextArea(5, 20);
        skillsArea = new JTextArea(5, 20);
        printButton = new JButton("Print Resume");

        sscCourseField = new JTextField(20);
        sscSchoolField = new JTextField(20);
        sscYearField = new JTextField(4);
        sscPercentageField = new JTextField(4);

        hscCourseField = new JTextField(20);
        hscSchoolField = new JTextField(20);
        hscYearField = new JTextField(4);
        hscPercentageField = new JTextField(4);

        bachelorsCourseField = new JTextField(20);
        bachelorsSchoolField = new JTextField(20);
        bachelorsYearField = new JTextField(4);
        bachelorsPercentageField = new JTextField(4);

        postgradCourseField = new JTextField(20);
        postgradSchoolField = new JTextField(20);
        postgradYearField = new JTextField(4);
        postgradPercentageField = new JTextField(4);

        // Set up the layout
        JPanel mainPanel = new JPanel(new GridLayout(18, 2, 10, 10));
        mainPanel.setBackground(new Color(230, 230, 255));
        mainPanel.add(createLabel("Name:", Color.BLACK));
        mainPanel.add(nameField);
        mainPanel.add(createLabel("Date of Birth:", Color.BLACK));
        mainPanel.add(dobField);

        mainPanel.add(createLabel("Educational Details:", Color.BLACK));
        mainPanel.add(new JPanel()); // Empty panel for spacing
        mainPanel.add(createLabel("SSC Course:", Color.BLUE));
        mainPanel.add(sscCourseField);
        mainPanel.add(createLabel("SSC School:", Color.BLUE));
        mainPanel.add(sscSchoolField);
        mainPanel.add(createLabel("SSC Year:", Color.BLUE));
        mainPanel.add(sscYearField);
        mainPanel.add(createLabel("SSC Percentage:", Color.BLUE));
        mainPanel.add(sscPercentageField);

        mainPanel.add(createLabel("HSC Course:", Color.RED));
        mainPanel.add(hscCourseField);
        mainPanel.add(createLabel("HSC School:", Color.RED));
        mainPanel.add(hscSchoolField);
        mainPanel.add(createLabel("HSC Year:", Color.RED));
        mainPanel.add(hscYearField);
        mainPanel.add(createLabel("HSC Percentage:", Color.RED));
        mainPanel.add(hscPercentageField);

        mainPanel.add(createLabel("Bachelors Course:", Color.GREEN));
        mainPanel.add(bachelorsCourseField);
        mainPanel.add(createLabel("Bachelors School:", Color.GREEN));
        mainPanel.add(bachelorsSchoolField);
        mainPanel.add(createLabel("Bachelors Year:", Color.GREEN));
        mainPanel.add(bachelorsYearField);
        mainPanel.add(createLabel("Bachelors Percentage:", Color.GREEN));
        mainPanel.add(bachelorsPercentageField);

        mainPanel.add(createLabel("Postgrad Course:", Color.MAGENTA));
        mainPanel.add(postgradCourseField);
        mainPanel.add(createLabel("Postgrad School:", Color.MAGENTA));
        mainPanel.add(postgradSchoolField);
        mainPanel.add(createLabel("Postgrad Year:", Color.MAGENTA));
        mainPanel.add(postgradYearField);
        mainPanel.add(createLabel("Postgrad Percentage:", Color.MAGENTA));
        mainPanel.add(postgradPercentageField);

        mainPanel.add(createLabel("Profile Summary:", Color.DARK_GRAY));
        mainPanel.add(new JScrollPane(profileSummaryArea));
        mainPanel.add(createLabel("Project Details:", Color.ORANGE));
        mainPanel.add(new JScrollPane(projectDetailsArea));
        mainPanel.add(createLabel("Experience:", Color.PINK));
        mainPanel.add(new JScrollPane(experienceArea));
        mainPanel.add(createLabel("Skills:", Color.CYAN));
        mainPanel.add(new JScrollPane(skillsArea));
        mainPanel.add(printButton);

        // Add action listener to the print button
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printResume();
            }
        });

        // Add the main panel to the frame
        add(mainPanel);

        // Show the frame
        setVisible(true);
    }

    private JLabel createLabel(String text, Color color) {
        JLabel label = new JLabel(text);
        label.setForeground(color);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        return label;
    }

    private void printResume() {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(this);

        if (printerJob.printDialog()) {
            try {
                printerJob.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        // Retrieve information from the fields
        String name = nameField.getText();
        String dob = dobField.getText();
        String profileSummary = profileSummaryArea.getText();
        String projectDetails = projectDetailsArea.getText();
        String experience = experienceArea.getText();
        String skills = skillsArea.getText();

        String sscCourse = sscCourseField.getText();
        String sscSchool = sscSchoolField.getText();
        String sscYear = sscYearField.getText();
        String sscPercentage = sscPercentageField.getText();

        String hscCourse = hscCourseField.getText();
        String hscSchool = hscSchoolField.getText();
        String hscYear = hscYearField.getText();
        String hscPercentage = hscPercentageField.getText();

        String bachelorsCourse = bachelorsCourseField.getText();
        String bachelorsSchool = bachelorsSchoolField.getText();
        String bachelorsYear = bachelorsYearField.getText();
        String bachelorsPercentage = bachelorsPercentageField.getText();

        String postgradCourse = postgradCourseField.getText();
        String postgradSchool = postgradSchoolField.getText();
        String postgradYear = postgradYearField.getText();
        String postgradPercentage = postgradPercentageField.getText();

        // Draw the resume content on the printable area
        int x = 50;
        int y = 50;
        int lineHeight = 15;

        // Display resume content in a structured format
        drawLine(g2d, "Name:", name, x, y, Color.BLACK);
        y += lineHeight;
        drawLine(g2d, "Date of Birth:", dob, x, y, Color.BLACK);
        y += lineHeight;

        drawLine(g2d, "Educational Details:", "", x, y, Color.BLACK);
        y += lineHeight;

        drawLine(g2d, "SSC Course:", sscCourse, x, y, Color.BLUE);
        drawLine(g2d, "SSC School:", sscSchool, x + 200, y, Color.BLUE);
        drawLine(g2d, "SSC Year:", sscYear, x + 400, y, Color.BLUE);
        drawLine(g2d, "SSC Percentage:", sscPercentage, x + 600, y, Color.BLUE);
        y += lineHeight;

        drawLine(g2d, "HSC Course:", hscCourse, x, y, Color.RED);
        drawLine(g2d, "HSC School:", hscSchool, x + 200, y, Color.RED);
        drawLine(g2d, "HSC Year:", hscYear, x + 400, y, Color.RED);
        drawLine(g2d, "HSC Percentage:", hscPercentage, x + 600, y, Color.RED);
        y += lineHeight;

        drawLine(g2d, "Bachelors Course:", bachelorsCourse, x, y, Color.GREEN);
        drawLine(g2d, "Bachelors School:", bachelorsSchool, x + 200, y, Color.GREEN);
        drawLine(g2d, "Bachelors Year:", bachelorsYear, x + 400, y, Color.GREEN);
        drawLine(g2d, "Bachelors Percentage:", bachelorsPercentage, x + 600, y, Color.GREEN);
        y += lineHeight;

        drawLine(g2d, "Postgrad Course:", postgradCourse, x, y, Color.MAGENTA);
        drawLine(g2d, "Postgrad School:", postgradSchool, x + 200, y, Color.MAGENTA);
        drawLine(g2d, "Postgrad Year:", postgradYear, x + 400, y, Color.MAGENTA);
        drawLine(g2d, "Postgrad Percentage:", postgradPercentage, x + 600, y, Color.MAGENTA);
        y += lineHeight;

        drawLine(g2d, "Profile Summary:", profileSummary, x, y, Color.DARK_GRAY);
        y += lineHeight;

        drawLine(g2d, "Project Details:", projectDetails, x, y, Color.ORANGE);
        y += lineHeight;

        drawLine(g2d, "Experience:", experience, x, y, Color.PINK);
        y += lineHeight;

        drawLine(g2d, "Skills:", skills, x, y, Color.CYAN);

        return PAGE_EXISTS;
    }

    private void drawLine(Graphics2D g2d, String label, String value, int x, int y, Color color) {
        g2d.setColor(color);
        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        g2d.drawString(label, x, y);
        g2d.drawString(value, x + 150, y);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ResumeBuilderApp();
            }
        });
    }
}

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.*;

public class Assignment1 {

    // create logger instance
    private static final Logger logger = Logger.getLogger(Assignment1.class.getName());

    static {
        try {
            // disable default console handler to avoid duplicate logs
            logger.setUseParentHandlers(false);
            // Set up a FileHandler to save logs to "fibonacci_logs.log"
            FileHandler fileHandler = new FileHandler("fibonacci_logs.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
            fileHandler.setLevel(Level.ALL);

            // ConsoleHandler to also output logs to the console
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.ALL);
            consoleHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(consoleHandler);

        } catch (IOException e) {
            System.err.println("Failed to initialize logger: " + e.getMessage());
        }// end of try
    }// end of static

    /**
     * The main method serves as the entry point for the Fibonacci program.
     * <p>
     * It initializes the logging system, starts the program, and attempts to
     * generate and print the Fibonacci sequence up to the 10th position using
     * the `fibonacciString` method. Logs any exceptions that occur during execution.
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        logger.info("Starting Fibonacci program...");

        try {
            System.out.println(fibonacciString(10));
        } catch (Exception e) {
            logger.severe("Exception occurred in main: " + e.getMessage());
        }// end of try

        logger.info("Fibonacci program finished.");

        // Send the log file after the program runs
        sendEmail(
                "swills_skeins0@icloud.com",
                "Fibonacci Program Logs",
                "Please find the attached logs for the Fibonacci program execution.",
                "fibonacci_logs.log"
        );

    }// end of main

    /**
     * Computes the nth Fibonacci number using memoization for efficiency.
     * <p>
     * The Fibonacci sequence is a series where each number is the sum of the two preceding ones,
     * starting from 0 and 1. This method calculates the nth number in the sequence.
     *
     * @param n the position in the Fibonacci sequence to compute
     * @return the nth Fibonacci number
     * @throws IllegalArgumentException if the provided position n is negative
     */
    public static int fibonacci(int n) {
        logger.info("Computing fibonacci(" + n + ")");

        if (n < 0) {
            logger.severe("Negative argument provided to fibonacci: " + n);
            throw new IllegalArgumentException("Negative arguments are not allowed");
        }

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        logger.info("Result of fibonacci(" + n + ") is " + memo[n]);
        return memo[n];
    }// end of fibonacci

    /**
     * Generates a string representation of the Fibonacci sequence up to the specified position.
     * <p>
     * This method constructs a string that includes all Fibonacci numbers from 0 up to the nth position,
     * separated by spaces. It uses the `fibonacci` method to compute each number in the sequence.
     * Logs the process of generating the sequence.
     *
     * @param n the position in the Fibonacci sequence up to which the sequence is generated
     * @return a string representation of the Fibonacci sequence up to the nth position
     * @throws IllegalArgumentException if the provided position n is negative
     */
    public static String fibonacciString(int n) {
        logger.info("Generating description for fibonacci sequence up to position " + n);

        StringBuilder result = new StringBuilder("Fibonacci sequence up to position " + n + ": ");
        for (int i = 0; i <= n; i++) {
            result.append(fibonacci(i)).append(" ");
        }

        logger.info("Generated Fibonacci sequence string: " + result);
        return result.toString();
    }// end of fibonacciString

    /**
     * Sends an email with a specified subject and message text to a recipient,
     * attaching a file from the given file path.
     * <p>
     * Utilizes SMTP with SSL for secure email transmission. Logs success or
     * failure of the email sending process.
     *
     * @param recipientEmail the email address of the recipient
     * @param subject        the subject of the email
     * @param messageText    the text content of the email
     * @param filePath       the path to the file to be attached to the email
     */
    public static void sendEmail(String recipientEmail, String subject, String messageText, String filePath) {
        final String senderEmail = "";
        final String senderPassword = "";

        // Setup mail server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        // Create a session with the authentication information
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create the message with recipient, subject, and content
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);

            // Set the email body
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(messageText);

            // Attach the file
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            attachmentBodyPart.attachFile(filePath);

            // Combine both parts into a multipart
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentBodyPart);

            // Set the content of the message to be the multipart
            message.setContent(multipart);

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully with the log file attachment.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to send email.");
        }
    }// end of sendEmail

}// end of class

import java.util.*;
import java.io.*;

public class FlashcardApp {
    private List<Flashcard> flashcards;
    private Scanner scanner;
    private static final String SAVE_FILE = "flashcards.txt";

    public FlashcardApp() {
        flashcards = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = getIntInput("Choose an option: ");
            
            switch (choice) {
                case 1:
                    addFlashcard();
                    break;
                case 2:
                    viewFlashcards();
                    break;
                case 3:
                    takeQuiz();
                    break;
                case 4:
                    saveFlashcards();
                    break;
                case 5:
                    loadFlashcards();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nFlashcard Quiz App");
        System.out.println("1. Add Flashcard");
        System.out.println("2. View Flashcards");
        System.out.println("3. Take Quiz");
        System.out.println("4. Save Flashcards to File");
        System.out.println("5. Load Flashcards from File");
        System.out.println("6. Exit");
    }

    private void addFlashcard() {
        System.out.println("\nEnter question:");
        String question = scanner.nextLine();
        System.out.println("Enter answer:");
        String answer = scanner.nextLine();
        
        flashcards.add(new Flashcard(question, answer));
        System.out.println("Flashcard added successfully!");
    }

    private void viewFlashcards() {
        if (flashcards.isEmpty()) {
            System.out.println("No flashcards available.");
            return;
        }

        System.out.println("\nYour Flashcards:");
        for (int i = 0; i < flashcards.size(); i++) {
            System.out.println("\nCard #" + (i + 1));
            System.out.println(flashcards.get(i));
        }
    }

    private void takeQuiz() {
        if (flashcards.isEmpty()) {
            System.out.println("No flashcards available for quiz.");
            return;
        }

        List<Flashcard> quizCards = new ArrayList<>(flashcards);
        Collections.shuffle(quizCards);

        int correctAnswers = 0;
        for (Flashcard card : quizCards) {
            System.out.println("\nQuestion: " + card.getQuestion());
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            System.out.println("Correct answer: " + card.getAnswer());
            if (userAnswer.equalsIgnoreCase(card.getAnswer())) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("Incorrect!");
            }
        }

        System.out.println("\nQuiz completed! Score: " + correctAnswers + "/" + quizCards.size());
    }

    private void saveFlashcards() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(SAVE_FILE))) {
            for (Flashcard card : flashcards) {
                writer.println(card.getQuestion());
                writer.println(card.getAnswer());
            }
            System.out.println("Flashcards saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving flashcards: " + e.getMessage());
        }
    }

    private void loadFlashcards() {
        flashcards.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILE))) {
            String question;
            while ((question = reader.readLine()) != null) {
                String answer = reader.readLine();
                if (answer != null) {
                    flashcards.add(new Flashcard(question, answer));
                }
            }
            System.out.println("Flashcards loaded successfully!");
        } catch (IOException e) {
            System.out.println("Error loading flashcards: " + e.getMessage());
        }
    }

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        FlashcardApp app = new FlashcardApp();
        app.start();
    }
} 
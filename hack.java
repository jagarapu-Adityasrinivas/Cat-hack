import java.util.*;

public class StatesAndCapitalsQuiz {
    private static final Map<String, String> statesAndCapitals = new HashMap<>();

    static {
        statesAndCapitals.put("Andhra Pradesh", "Amaravati");
        statesAndCapitals.put("Arunachal Pradesh", "Itanagar");
        statesAndCapitals.put("Assam", "Dispur");
        statesAndCapitals.put("Bihar", "Patna");
        statesAndCapitals.put("Chhattisgarh", "Raipur");
        statesAndCapitals.put("Goa", "Panaji");
        statesAndCapitals.put("Gujarat", "Gandhinagar");
        statesAndCapitals.put("Haryana", "Chandigarh");
        statesAndCapitals.put("Himachal Pradesh", "Shimla");
        statesAndCapitals.put("Jharkhand", "Ranchi");
        statesAndCapitals.put("Karnataka", "Bengaluru");
        statesAndCapitals.put("Kerala", "Thiruvananthapuram");
        statesAndCapitals.put("Madhya Pradesh", "Bhopal");
        statesAndCapitals.put("Maharashtra", "Mumbai");
        statesAndCapitals.put("Manipur", "Imphal");
        statesAndCapitals.put("Meghalaya", "Shillong");
        statesAndCapitals.put("Mizoram", "Aizawl");
        statesAndCapitals.put("Nagaland", "Kohima");
        statesAndCapitals.put("Odisha", "Bhubaneswar");
        statesAndCapitals.put("Punjab", "Chandigarh");
        statesAndCapitals.put("Rajasthan", "Jaipur");
        statesAndCapitals.put("Sikkim", "Gangtok");
        statesAndCapitals.put("Tamil Nadu", "Chennai");
        statesAndCapitals.put("Telangana", "Hyderabad");
        statesAndCapitals.put("Tripura", "Agartala");
        statesAndCapitals.put("Uttar Pradesh", "Lucknow");
        statesAndCapitals.put("Uttarakhand", "Dehradun");
        statesAndCapitals.put("West Bengal", "Kolkata");
    }

    public static void conductQuiz(int numQuestions, int numStudents) {
        List<String> states = new ArrayList<>(statesAndCapitals.keySet());
        Scanner scanner = new Scanner(System.in);
        int[] scores = new int[numStudents]; // Array to store scores of each student

        for (int student = 0; student < numStudents; student++) {
            System.out.println("\nStudent " + (student + 1) + "'s turn:");
            Collections.shuffle(states);
            List<String> selectedStates = states.subList(0, numQuestions);
            int score = 0;

            for (String state : selectedStates) {
                System.out.print("What is the capital of " + state + "? ");
                String answer = scanner.nextLine();

                if (answer.trim().equalsIgnoreCase(statesAndCapitals.get(state))) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong! The correct answer is " + statesAndCapitals.get(state) + ".");
                }
            }

            scores[student] = score; // Store the score for the current student
            System.out.println("Quiz completed for Student " + (student + 1) + "! Your score: " + score + "/" + numQuestions);
        }

        // Determine the winner
        int highestScore = -1;
        List<Integer> winners = new ArrayList<>();

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > highestScore) {
                highestScore = scores[i];
                winners.clear();
                winners.add(i + 1); // Store student number (1-based index)
            } else if (scores[i] == highestScore) {
                winners.add(i + 1); // Add to winners if there's a tie
            }
        }

        // Declare the winner(s)
        System.out.print("Winner(s): Student(s) " + winners + " with a score of " + highestScore + "/" + numQuestions);
        
        scanner.close();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the States and Capitals Quiz!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many questions would you like to ask? ");
        int numQuestions = scanner.nextInt();
        System.out.print("How many students will attempt the quiz? ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        conductQuiz(numQuestions, numStudents);
    }
}

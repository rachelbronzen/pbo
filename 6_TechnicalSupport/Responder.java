import java.util.HashMap;
import java.util.Random;

public class Responder {
    private String[] answers;
    private HashMap<String, Integer> responseMap;
    private Random random;

    public Responder() {
        random = new Random();  
        initializeAnswers();  
        initializeResponseMap(); 
    }
    
    
   public String generateResponse(String userInput) {
        userInput = userInput.toLowerCase();  
        for (String keyword : responseMap.keySet()) {
            if (userInput.contains(keyword)) {
                int answerIndex = responseMap.get(keyword);
                return answers[answerIndex];
            }
        }

        return getRandomAnswer();
    }
    
    private void initializeAnswers() {
        answers = new String[6];
        answers[0] = "Hello there! What's wrong?\n";
        answers[1] = "Are you sure?\n";
        answers[2] = "Today is actually a great day.\n";
        answers[3] = "My name is Technical Support System\n";
        answers[4] = "It's okay. You can do it\n";
        answers[5] = "I love you too.\n";
    }
    
    private void initializeResponseMap() {
        responseMap = new HashMap<>();
        responseMap.put("hello", 0);
        responseMap.put("nothing", 1);
        responseMap.put("today", 2);
        responseMap.put("name", 3);
        responseMap.put("hate", 4);
        responseMap.put("love", 5);
    }
    
    private String getRandomAnswer() {
        int randomIndex = random.nextInt(answers.length);
        return answers[randomIndex];
    }
}

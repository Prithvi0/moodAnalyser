public class MoodAnalyser {
    private String message;
    public MoodAnalyser(String message) {
        this.message = message;
    }
    // METHOD CONTAINING SAD MESSAGE RETURNS 'SAD'
    public String analyseMood() {
        if (message.contains("Sad"))
            return "SAD";
        else
            return "HAPPY";
    }
} 
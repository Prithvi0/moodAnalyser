public class MoodAnalyser {
    private String message;
    // DEFAULT CONSTRUCTOR
    public MoodAnalyser() {
    }
    // PARAMETERISED CONSTRUCTOR
    public MoodAnalyser(String message) {   //  MoodAnalyser WITH A MESSAGE FIELD
        this.message = message;
    }
    // METHOD CONTAINING SAD MESSAGE RETURNS 'SAD' ELSE RETURNS 'HAPPY'
    public String analyseMood() {   // METHOD SUPPORTING NO PARAMETERS
        if (message.contains("Sad"))
            return "SAD";
        else
            return "HAPPY";
    }
} 
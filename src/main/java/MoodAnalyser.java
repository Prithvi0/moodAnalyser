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
        try {
            if (message.contains("Sad"))    // USING MESSAGE FIELD DEFINED FOR THE CLASS
                return "SAD";
            else
                return "HAPPY";
        } catch (NullPointerException e) {  // HANDLING EXCEPTION WHEN USER PROVIDES INVALID MOOD ( NULL )
            e.printStackTrace();
            return "HAPPY";
        }
    }
}
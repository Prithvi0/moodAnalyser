public class MoodAnalyser {
    private String message;
    // DEFAULT CONSTRUCTOR
    public MoodAnalyser() {
    }
    // PARAMETERISED CONSTRUCTOR
    public MoodAnalyser(String message) {   //  MoodAnalyser WITH A MESSAGE FIELD
        this.message = message;
    }
    //
    public String analyseMood(String message) throws MoodAnalysisException {
        this.message = message;
        return analyseMood();
    }

    public String analyseMood() throws MoodAnalysisException {
        try {
            if (message.length() == 0)
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,
                        "Please Enter correct mood");
            if (message.contains("Sad"))
                return "SAD";
            else
                return "HAPPY";
        } catch (NullPointerException e) {  // HANDLING CUSTOM EXCEPTION FOR INVALID MOOD ( NULL )
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL,
                                            "Please Enter correct mood");
        }
    }

    public boolean equals(Object another) {
        return this.message.equals(((MoodAnalyser) another).message);
    }
}
import java.util.Objects;

public class MoodAnalyser {
    private String message;
    // DEFAULT CONSTRUCTOR
    public MoodAnalyser() {
    }
    // PARAMETERISED CONSTRUCTOR
    public MoodAnalyser(String message) {   //  MoodAnalyser WITH A MESSAGE FIELD
        this.message = message;
    }

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
    // METHOD TO CHECK IF THE TWO OBJECTS ARE EQUAL
    @Override
    public boolean equals(Object another) {
        if (this == another)
            return true;
        if (another == null || getClass() != another.getClass())
            return false;
        MoodAnalyser that = (MoodAnalyser) another;
        return Objects.equals(message, that.message);
    }
    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
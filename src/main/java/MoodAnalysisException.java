public class MoodAnalysisException extends Exception{
    //  USING ENUM TO DIFFERENTIATE THE MOOD ANALYSIS ERROR
    enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY
    }
    ExceptionType type;

    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public MoodAnalysisException(ExceptionType type, Throwable cause) {
        super(cause);
        this.type = type;
    }

    public MoodAnalysisException(ExceptionType type, String message, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}

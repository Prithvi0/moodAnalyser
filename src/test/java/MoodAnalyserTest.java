import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    // TC 1.1: PASS THE TEST CASE TO RETURN SAD MOOD
    @Test
    public void givenMood_WhenSad_ShouldReturnSadMessage() throws MoodAnalysisException {
        //  CREATING MoodAnalyser OBJECT
        MoodAnalyser analyser = new MoodAnalyser("I'm in a Sad Mood");
        // CALLING analyseMood FUNCTION WITH MESSAGE AS PARAMETER
        String mood = analyser.analyseMood();
        Assert.assertEquals("SAD", mood);
    }
    // TC 1.2: PASS THE TEST CASE TO RETURN HAPPY MOOD
    @Test
    public void givenMood_WhenAnyMood_ShouldReturnHappyMessage() throws MoodAnalysisException {
        //  CREATING MoodAnalyser OBJECT
        MoodAnalyser analyser = new MoodAnalyser("I'm in a Happy Mood");
        // CALLING analyseMood FUNCTION WITH MESSAGE AS PARAMETER
        String mood = analyser.analyseMood();
        Assert.assertEquals("HAPPY", mood);
    }
    // TC 2.1: TEST CASE TO PASS NULL EXCEPTION AND RETURN HAPPY
    @Test
    public void givenMood_WhenNull_ShouldReturnHappyMessage() throws MoodAnalysisException {
        MoodAnalyser analyser = new MoodAnalyser("I'm in a Happy Mood");
        String mood = analyser.analyseMood();
        Assert.assertEquals("HAPPY", mood);
    }
    //  T.C 3.1: PASS TEST CASE IN TRY CATCH BLOCK AND THROW EXCEPTION
    @Test
    public void givenMood_WhenNull_ShouldThrowException() {
        MoodAnalyser analyser = new MoodAnalyser(null);
        try {
            analyser.analyseMood(null);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL, e.type);
        }
    }
}
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    // TC 1.1: PASS THE TEST CASE TO RETURN SAD MOOD
    @Test
    public void givenMood_WhenSad_ShouldReturnSadMessage() {
        //  CREATING MoodAnalyser OBJECT
        MoodAnalyser analyser = new MoodAnalyser("I'm in a Sad Mood");
        // CALLING analyseMood FUNCTION WITH MESSAGE AS PARAMETER
        String mood = analyser.analyseMood();
        Assert.assertEquals("SAD", mood);
    }
}
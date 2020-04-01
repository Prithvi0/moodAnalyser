import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class MoodAnalyserTest {
    public MoodAnalyser analyser;
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

    //  T.C 3.1: PASS TEST CASE IN TRY CATCH BLOCK AND THROW EXCEPTION IF MOOD IS NULL
    @Test
    public void givenMood_WhenNull_ShouldThrowException() {
        MoodAnalyser analyser = new MoodAnalyser(null);
        try {
            analyser.analyseMood(null);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL, e.type);
        }
    }

    //  T.C 3.2: PASS TEST CASE TO HANDLE EMPTY MOOD BY THROWING THE EXCEPTION AND INFORM THE SAME
    @Test
    public void givenMood_WhenEmpty_ShouldThrowException() {
        MoodAnalyser analyser = new MoodAnalyser("");
        try {
            analyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, e.type);
        }
    }

    //  T.C 4.1: PASS TEST CASE IF TWO OBJECTS ARE EQUAL
    @Test
    public void givenMoodAnalyserClass_WhenCorrect_ShouldReturnObject() throws MoodAnalysisException {
        MoodAnalyser analyser = new MoodAnalyser();
        Constructor<?> constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser");
        Object newObject = MoodAnalyserFactory.createDefaultMoodAnalyserObject(constructor);
        boolean equal = analyser.equals(newObject);
        Assert.assertTrue(equal);
    }
    //  T.C 4.2: PASS TEST CASE WITH WRONG CLASS NAME AND THROW THE EXCEPTION
    @Test
    public void givenMoodAnalyserClass_WhenIncorrect_ShouldThrowException() {
        try {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("Mood");

        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }
    //  T.C 4.3: PASS TEST CASE WITH WRONG CONSTRUCTOR PARAMETER AND THROW THE EXCEPTION
    @Test
    public void givenConstructor_WhenIncorrect_ShouldThrowException() {
        try {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser", Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }
    //  T.C 5.1: PASS TEST CASE IF TWO OBJECTS ARE EQUAL (OBJECT WITH PARAMETERISED CONSTRUCTOR)
    @Test
    public void givenParameterisedConstructor_WhenCorrect_ShouldReturnObject() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = MoodAnalyserFactory.createParameterisedMoodAnalyserObject("I'm in a Happy Mood");
        Assert.assertEquals(new MoodAnalyser("I'm in a Happy Mood"), moodAnalyser);
    }
}
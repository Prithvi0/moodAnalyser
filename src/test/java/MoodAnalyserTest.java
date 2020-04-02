import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
            Constructor<?> defaultConstructor = MoodAnalyserFactory.getConstructor("Mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }

    //  T.C 4.3: PASS TEST CASE WITH WRONG CONSTRUCTOR PARAMETER AND THROW THE EXCEPTION
    @Test
    public void givenConstructor_WhenIncorrect_ShouldThrowException() {
        try {
            Constructor<?> defaultConstructor = MoodAnalyserFactory.getConstructor("MoodAnalyser", Integer.class);
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

    // T.C 5.2: PASS TEST CASE FOR PARAMETERISED CONSTRUCTOR WITH WRONG CLASS NAME AND THROW THE EXCEPTION
    @Test
    public void givenParameterisedConstructor_WhenIncorrectMoodAnalysisClass_ShouldThrowException() {
        try {
            Constructor<?> paramConstructor = MoodAnalyserFactory.getConstructor("Mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }

    // T.C 5.3: PASS TEST CASE FOR WRONG PARAMETERISED CONSTRUCTOR AND THROW THE EXCEPTION
    @Test
    public void givenParameterisedConstructor_WhenIncorrect_ShouldThrowException() {
        try {
            Constructor<?> paramConstructor = MoodAnalyserFactory.getConstructor("MoodAnalyser", Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    //  T.C 6.1: PASS TEST CASE FOR REFLECTION TO INVOKE METHOD AND SHOW HAPPY MOOD
    @Test
    public void givenHappyMessage_WhenProper_ShouldReturnHappyMood() throws MoodAnalysisException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        try {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("MoodAnalyser", Integer.class);
            Object moodObject = MoodAnalyserFactory.createParameterisedMoodAnalyserObject("I'm in a Happy Mood");
            Object moodObj = MoodAnalyserFactory.analyseMoodInvoke(moodObject, "analyseMood");
            Assert.assertEquals("HAPPY", moodObj);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    // T.C 6.2: PASS TEST CASE WITH WRONG METHOD NAME AND THROW THE EXCEPTION
    @Test
    public void givenHappyMessage_WhenImproperMethod_ShouldThrowException() throws MoodAnalysisException {
        MoodAnalyser analyser = MoodAnalyserFactory.createParameterisedMoodAnalyserObject("I'm in a Happy Mood");
        try {
            Constructor<?> MoodAnalyserConstructor = MoodAnalyserFactory.getConstructor("MoodAnalyser", String.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    // T.C 7.1: PASS TEST CASE TO SET FIELD VALUE AND INVOKE METHOD USING REFLECTION AND ASSERT HAPPY MOOD
    @Test
    public void givenHappyMessage_WithReflector_ShouldReturnHappy() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyzerDefault();
        try {
            String mood = (String) MoodAnalyserFactory.changeMoodDynamically(moodAnalyser, "I'm in a Happy Mood", "message");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    // T.C 7.2: PASS TEST CASE FOR IMPROPER SET FIELD AND THROW AN EXCEPTION
    @Test
    public void givenField_WhenSetImproperValue_WithReflector_ShouldThrowException() {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("MoodAnalyser");
            MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.createDefaultMoodAnalyserObject(moodAnalyserConstructor);
            try {
                MoodAnalyserFactory.changeMoodDynamically(moodAnalyserObject, "I'm in a Happy Mood", "msg");
            } catch (NoSuchMethodException | NoSuchFieldException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            } catch (MoodAnalysisException e) {
                Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD, e.type);
                e.printStackTrace();
            }
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    // T.C 7.3: PASS TEST CASE TO SET FIELD VALUE TO NULL AND THROW AN EXCEPTION
    @Test
    public void givenSetField_WhenSetToNullMessage_WithReflector_ShouldThrowException() {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserFactory.getConstructor("MoodAnalyser");
            MoodAnalyser moodAnalyserObject = MoodAnalyserFactory.createDefaultMoodAnalyserObject(moodAnalyserConstructor);
            try {
                MoodAnalyserFactory.changeMoodDynamically(moodAnalyserObject, "I'm in a Happy Mood", null);
            } catch (MoodAnalysisException e) {
                Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL, e.type);
                e.printStackTrace();
            }
        } catch (MoodAnalysisException | NoSuchMethodException | NoSuchFieldException | IllegalAccessException | InvocationTargetException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
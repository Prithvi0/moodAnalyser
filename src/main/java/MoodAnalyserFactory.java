import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserFactory {
    // REFLECTION TO CREATE OBJECT WITH DEFAULT CONSTRUCTOR
    public static Constructor<?> getConstructor(String moodAnalyser, Class<?>... param) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyserClass = Class.forName(moodAnalyser);
            return moodAnalyserClass.getConstructor(param);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Object createDefaultMoodAnalyserObject(Constructor<?> constructor) throws MoodAnalysisException {
        try {
            return constructor.newInstance();
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    // REFLECTION TO CREATE OBJECT WITH PARAMETERISED CONSTRUCTOR
    public static MoodAnalyser createParameterisedMoodAnalyserObject(String message) throws MoodAnalysisException {
        try {
            Constructor<?> constructor = Class.forName("MoodAnalyser").getConstructor(String.class);
            return (MoodAnalyser) constructor.newInstance(message);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    //  REFLECTION TO INVOKE METHOD
    public static Object analyseMoodInvoke(Object moodAnalyser, String analyseMood) {
        moodAnalyser = moodAnalyser;
        try {
            Method invokeMethod = moodAnalyser.getClass().getMethod(analyseMood);
            Object result = invokeMethod.invoke(moodAnalyser);
            return result;
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return moodAnalyser;
    }
    //  REFLECTION TO CHANGE MOOD DYNAMICALLY
    public static Object changeMoodDynamically(MoodAnalyser moodObject, String message, String fieldValue) {
        try {
            Class<?> objectClass = moodObject.getClass();
            Field fieldObject = objectClass.getDeclaredField(message);
            fieldObject.set(moodObject,fieldValue);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    // REFLECTION TO CREATE OBJECT WITH DEFAULT CONSTRUCTOR
    public static Constructor<?> getConstructor(String moodAnalyser, Class<?>... param) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyserClass = Class.forName("MoodAnalyser");
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
}
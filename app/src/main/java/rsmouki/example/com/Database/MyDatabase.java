package rsmouki.example.com.Database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {QuestionData.class}, version = 2)
public abstract class MyDatabase extends RoomDatabase {
    private static final String TAG = "ROOM DATABASE";
    //Log.d(TAG, "create QuestionDataDAO");
    public abstract QuestionDataDAO QuestionDataDao();
}

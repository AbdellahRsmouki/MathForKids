package rsmouki.example.com.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface QuestionDataDAO {

    @Insert(onConflict=OnConflictStrategy.IGNORE)
    void addQuestionData(QuestionData qd);
    @Query("select * from questiondata where id = :id")
    List<QuestionData> getQuestioinData(int id);
    @Query("select * from questiondata")
    List<QuestionData> getAllQuestionDatas();
    @Query("select * from questiondata where mode = :qdmode and operator = :qdoperator ")
    List<QuestionData> getQuestionDatas(String qdmode, String qdoperator);
    @Delete
    void deleteQuestionData(QuestionData qd);
    @Update
    void updateQuestionData(QuestionData qd);
}


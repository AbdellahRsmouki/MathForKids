package rsmouki.example.com.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Arrays;

@Entity(tableName = "questiondata")
public class QuestionData {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    public int qdid;
    @ColumnInfo(name = "mode")
    public String qdmode;
    @ColumnInfo(name = "operator")
    public String qdoperator;



    @NonNull
    public int getQdid() {
        return qdid;
    }

    public void setQdid(@NonNull int qdid) {
        this.qdid = qdid;
    }

    public String getQdmode() {
        return qdmode;
    }

    public void setQdmode(String qdmode) {
        this.qdmode = qdmode;
    }

    public String getQdoperator() {
        return qdoperator;
    }

    public void setQdoperator(String qdoperator) {
        this.qdoperator = qdoperator;
    }

    public String getQd() {
        return qd;
    }

    public void setQd(String qd) {
        this.qd = qd;
    }

    public String getRealAnswer() {
        return RealAnswer;
    }

    public void setRealAnswer(String realAnswer) {
        RealAnswer = realAnswer;
    }




    @ColumnInfo(name = "question")
    public String qd;
    @ColumnInfo(name = "answer")
    public String RealAnswer;
    @ColumnInfo(name = "response1")
    public String response1;
    @ColumnInfo(name = "response2")
    public String response2;
    @ColumnInfo(name = "response3")
    public String response3;

    public QuestionData(String qdmode, String qdoperator, String qd, String realAnswer, String response1, String response2, String response3, String response4) {
        this.qdmode = qdmode;
        this.qdoperator = qdoperator;
        this.qd = qd;
        RealAnswer = realAnswer;
        this.response1 = response1;
        this.response2 = response2;
        this.response3 = response3;
        this.response4 = response4;
    }

    @Override
    public String toString() {
        return "QuestionData{" +
                "qdid=" + qdid +
                ", qdmode='" + qdmode + '\'' +
                ", qdoperator='" + qdoperator + '\'' +
                ", qd='" + qd + '\'' +
                ", RealAnswer='" + RealAnswer + '\'' +
                ", response1='" + response1 + '\'' +
                ", response2='" + response2 + '\'' +
                ", response3='" + response3 + '\'' +
                ", response4='" + response4 + '\'' +
                '}';
    }

    public QuestionData(@NonNull int qdid, String qdmode, String qdoperator, String qd, String realAnswer, String response1, String response2, String response3, String response4) {

        this.qdid = qdid;
        this.qdmode = qdmode;
        this.qdoperator = qdoperator;
        this.qd = qd;
        RealAnswer = realAnswer;
        this.response1 = response1;
        this.response2 = response2;
        this.response3 = response3;
        this.response4 = response4;
    }

    public String getResponse1() {

        return response1;
    }

    public void setResponse1(String response1) {
        this.response1 = response1;
    }

    public String getResponse2() {
        return response2;
    }

    public void setResponse2(String response2) {
        this.response2 = response2;
    }

    public String getResponse3() {
        return response3;
    }

    public void setResponse3(String response3) {
        this.response3 = response3;
    }

    public String getResponse4() {
        return response4;
    }

    public void setResponse4(String response4) {
        this.response4 = response4;
    }

    @ColumnInfo(name = "response4")
    public String response4;


    public QuestionData() {
    }
}
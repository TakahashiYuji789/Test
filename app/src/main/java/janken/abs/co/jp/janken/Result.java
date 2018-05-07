package janken.abs.co.jp.janken;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.prefs.PreferenceChangeEvent;

public class Result extends AppCompatActivity {

    NumberContainer container =  new NumberContainer();
    int winNum_,loseNum_,drawNum_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_scene);

        //勝った数を取得
        TextView winNum = findViewById(R.id.WinCount01);
        winNum.setText("勝った数:"+container.getWinNumber_());
        //負けた数を取得
        TextView loseNum = findViewById(R.id.LoseCount01);
        loseNum.setText("負けた数:"+container.getLoseNumber_());
        //引き分け数を取得
        TextView drawNum = findViewById(R.id.DrawCount01);
        drawNum.setText("引き分け数:"+container.getDrawNumber_());

        Result();
        SaveResult();
    }

        //勝敗結果
    public  void Result() {
        winNum_ = container.getWinNumber_();
        loseNum_ = container.getLoseNumber_();
        drawNum_ = container.getDrawNumber_();
        ImageView image_ = findViewById(R.id.ResultImage);
        if (winNum_ > loseNum_ && winNum_>=drawNum_) {
            image_.setImageResource(R.drawable.youwin);

        } else if (loseNum_ > winNum_ && loseNum_>=drawNum_) {
            image_.setImageResource(R.drawable.youlose);
        } else {
            image_.setImageResource(R.drawable.draw_maked);
        }

    }

    public void onButtonTitle(View view){
        Intent intent = new Intent(this,Title.class);
        startActivity(intent);
        finish();
    }
        //値を保存
    public void   SaveResult(){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("Win",pref.getInt("TWin",0)+container.getWinNumber_());
        editor.putInt("Lose",pref.getInt("TLose",0)+container.getLoseNumber_());
        editor.putInt("Draw",pref.getInt("TDraw",0)+container.getDrawNumber_());
        editor.apply();
        editor.commit();

    }
}

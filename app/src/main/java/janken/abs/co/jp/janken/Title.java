package janken.abs.co.jp.janken;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Title extends AppCompatActivity {
    NumberContainer container = new NumberContainer();
    int number = 1;
    int winNum_ ;
    int loseNum_;
    int drawNum_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        int winNum_ = preferences.getInt("Win",0);
        int loseNum_= preferences.getInt("Lose",0);
        int drawNum_= preferences.getInt("Draw",0);


        TextView battleRecord = findViewById(R.id.BattleHisCom);
         battleRecord.setText(winNum_+"勝ち"+loseNum_+"負け"+drawNum_+"引き分け");
    }

    public void onClickStart(View veiw) {
        Intent intent = new Intent(this, ModeSelect.class);
        startActivity(intent);
        finish();
    }

    //保存した値をリセット
    public void OnClickReset(View view){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
        TextView battleRecord = findViewById(R.id.BattleHisCom);
        battleRecord.setText(winNum_+"勝ち"+loseNum_+"負け"+drawNum_+"引き分け");

    }

}




package janken.abs.co.jp.janken;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ModeSelect extends AppCompatActivity {
    private TextView textView_;
    private int battleNum_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);

        SaveResult();
        textView_ = findViewById(R.id.BarNumber);
        final TextView battleMode_ = findViewById(R.id.BattleMode);
        battleNum_ = 1;
        textView_.setText("回数："+battleNum_);
        final TextView  ruleStruct = findViewById(R.id.Rule);
        battleMode_.setText("総当たり戦");
        ruleStruct.setText("1.対戦形式は任意で1～10まで対戦出来ます\n2.対戦は勝敗問わずカウントします\n3.設定した値まで終了しません\n4.結果は総合的に判定します");
        new NumberContainer().Initialize();
        new NumberContainer().battleType_ = false;

         SeekBar seekBar = findViewById(R.id.seekBar);
        //初期値
        seekBar.setProgress(0);
        //最大値
        seekBar.setMax(9);
        SeekBar seekBar2 = findViewById(R.id.seekBar2);

        //初期値
        seekBar2.setProgress(0);
        seekBar2.setMax(1);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                battleNum_ = progress+1;
                textView_.setText("回数："+battleNum_);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress==0){
                battleMode_.setText("総当たり戦");
                ruleStruct.setText("1.対戦形式は任意で1～10まで対戦出来ます\n2.対戦は勝敗問わずカウントします\n3.設定した値まで終了しません\n4.結果は総合的に判定します");
                    new NumberContainer().battleType_ = false;
                }
                else
                {
                    battleMode_.setText("星取り戦");
                    ruleStruct.setText("1.対戦形式は任意で1～10まで対戦出来ます\n2.設定した回戦数の半分以上を満たした場合終了します\n3.設定した回数を達した場合終了します\n4.結果は総合的に判定します");
                    new NumberContainer().battleType_ = true;

               }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });    }
    public void  onClickGame(View veiw){
        Intent intent = new Intent(this,MainActivity.class);
        if(battleNum_>10) new NumberContainer().setBattleNumber_(10);
        else new NumberContainer().setBattleNumber_(battleNum_);
        startActivity(intent);
    }
    public  void SaveResult(){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("TWin",pref.getInt("Win",0));
        editor.putInt("TLose",pref.getInt("Lose",0));
        editor.putInt("TDraw",pref.getInt("Draw",0));
        editor.apply();
        editor.commit();
    }

}



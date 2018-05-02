package janken.abs.co.jp.janken;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MiddleResult extends AppCompatActivity {

    NumberContainer container =  new NumberContainer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_03);
        TextView battleNum = findViewById(R.id.BattleNum);
        battleNum.setText(container.getCountBattle_()+"戦目だよ");

        TextView winNum = findViewById(R.id.WinCount00);
        winNum.setText("勝った数:"+container.getWinNumber_());

        TextView loseNum = findViewById(R.id.LoseCount00);
        loseNum.setText("負けた数:"+container.getLoseNumber_());

        TextView drawNum = findViewById(R.id.DrawCount00);
        drawNum.setText("引き分け数:"+container.getDrawNumber_());
    }
    public void onBattleScene(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}

package janken.abs.co.jp.janken;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity02 extends AppCompatActivity {
    final int Rock = 0;
    final int Scissors = 1;
    final int Paper = 2;

    int enemynum_;
    int playernum_;
    int playerNumber,enemyNumber;
     NumberContainer container_ = new NumberContainer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main02);
        Intent intent = getIntent();
        container_.setCountBattle_(1);
        playernum_ = intent.getIntExtra("PlayerHand",0);

        EnemyHandImage();
        PlayerHandImage();
        Result();
    }
    public void onClick(View view){
        if((container_.battleOver())||(container_.battleType_&&container_.CountedOver())){
            Intent intent = new Intent(this,Result.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this,MiddleResult.class);
            startActivity(intent);
    }
        finish();
    }
    //敵の手の画像変更
    public void  EnemyHandImage(){
        //ランダム作成
        long seed = System.currentTimeMillis();
        Random rnd = new Random(seed);
        ImageView enemyhand = findViewById(R.id.EnemyHand);
        enemynum_ = rnd.nextInt(3);
    switch (enemynum_){
        case Rock://0
            enemyhand.setImageResource(R.drawable.j_gu02);
            enemyNumber = 0;
            break;
        case Scissors://1
            enemyhand.setImageResource(R.drawable.j_ch02);
          enemyNumber= 1;
            break;
        case Paper://2
            enemyhand.setImageResource(R.drawable.j_pa02);
            enemyNumber = 2;
            break;}
    }
    //プレイヤーの手の画像変更
    public  void  PlayerHandImage(){
        ImageView playerhand = findViewById(R.id.PlayerHand);
        switch (playernum_){
        case Rock://0
            playerhand.setImageResource(R.drawable.j_gu02);
            playerNumber = 0;
            break;
        case Scissors://1
            playerhand.setImageResource(R.drawable.j_ch02);
            playerNumber = 1;
            break;
        case Paper://2
            playerhand.setImageResource(R.drawable.j_pa02);
            playerNumber = 2;
            break;
        }
    }

    //勝敗結果
    public  void Result(){
        TextView result = findViewById(R.id.Result);
        ImageView comaSan = findViewById(R.id.Coma);
        if((playernum_==2&&enemynum_==0)||(playernum_==0&&enemynum_==2)){
            if(playernum_>enemynum_){
                result.setText("勝ち");
                comaSan.setImageResource(R.drawable.win);
                container_.setWinNumber_(1);
            }
            else{
                result.setText("負け");
                comaSan.setImageResource(R.drawable.lose);
                container_.setLoseNumber_(1);
            }
            return;
        }
        if( playernum_==enemynum_){
            result.setText("あいこ");
            comaSan.setImageResource(R.drawable.draw);
            container_.setDrawNumber_(1);
            return;
        }

          if(playernum_<enemynum_){
            result.setText("勝ち");
            comaSan.setImageResource(R.drawable.win);
              container_.setWinNumber_(1);
          }
        else{
            result.setText("負け");
            comaSan.setImageResource(R.drawable.lose);
            container_.setLoseNumber_(1);
        }
    }

}

package janken.abs.co.jp.janken;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
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
     NumberContainer container_ = new NumberContainer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main02);
        Intent intent = getIntent();

        //ランダム作成
        long seed = System.currentTimeMillis();
        Random rnd = new Random(seed);

        //バトル回数を呼び出す
        container_.setCountBattle_(1);

        //プレイヤー情報
         playernum_ = intent.getIntExtra("PlayerHand",0);
        ImageView playerhand = findViewById(R.id.PlayerHand);
        PictureHand(playerhand,playernum_);

        //敵の情報
        ImageView enemyhand = findViewById(R.id.EnemyHand);
        enemynum_ = rnd.nextInt(3);
        PictureHand(enemyhand,enemynum_);

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

    //画像変換
    public  void PictureHand(ImageView imageView,int num){
        switch (num) {
            case Rock://0
                imageView.setImageResource(R.drawable.j_gu02);
                break;
            case Scissors://1
                imageView.setImageResource(R.drawable.j_ch02);
                break;
            case Paper://2
                imageView.setImageResource(R.drawable.j_pa02);
                break;
        }
    }

    //勝敗結果
    public  void Result(){
        TextView result = findViewById(R.id.Result);
        ImageView comaSan = findViewById(R.id.Coma);

        if( playernum_==enemynum_){
            result.setText("あいこ");
            comaSan.setImageResource(R.drawable.draw);
            container_.setDrawNumber_(1);
            return;
        }

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
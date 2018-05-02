package janken.abs.co.jp.janken;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    NumberContainer container =  new NumberContainer();
    int winNum_,loseNum_,drawNum_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_scene);

        TextView winNum = findViewById(R.id.WinCount01);
        winNum.setText("勝った数:"+container.getWinNumber_());

        TextView loseNum = findViewById(R.id.LoseCount01);
        loseNum.setText("負けた数:"+container.getLoseNumber_());

        TextView drawNum = findViewById(R.id.DrawCount01);
        drawNum.setText("引き分け数:"+container.getDrawNumber_());

        Result();

    }

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
    }
}

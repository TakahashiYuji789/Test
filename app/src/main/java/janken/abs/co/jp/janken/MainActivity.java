package janken.abs.co.jp.janken;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     NumberContainer container =  new NumberContainer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //対戦数を表示
        if(container.getCountBattle_()>=1){
            TextView title = findViewById(R.id.JankenTitle);
            int num = container.getCountBattle_() +1;
            title.setText("第"+num+"戦目 じゃーんけーん......");
        }
    }

    //じゃんけんボタンがどの押されたか
    public  void onButtonClick(View view) {
        Intent intent = new Intent(this,MainActivity02.class);
        switch (view.getId()) {
            case R.id.Rock:
                intent.putExtra("PlayerHand",0);
                break;
            case R.id.Scissors:
                intent.putExtra("PlayerHand",1);
                break;
            case R.id.Paper:
                intent.putExtra("PlayerHand",2);
                break;
        }
        startActivity(intent);
        finish();
    }
}

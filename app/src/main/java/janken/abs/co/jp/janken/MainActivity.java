package janken.abs.co.jp.janken;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     NumberContainer container =  new NumberContainer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(container.getCountBattle_()>=1){
            TextView title = findViewById(R.id.JankenTitle);
            int num = container.getCountBattle_() +1;
            title.setText("第"+num+"戦目 じゃーんけーん......");
        }
    }

    public void onButtonGu(View view){
        Intent intent = new Intent(this,MainActivity02.class);
        intent.putExtra("PlayerHand",0);
        startActivity(intent);
    }
    public void onButtonChoki(View view){
        Intent intent = new Intent(this,MainActivity02.class);
        intent.putExtra("PlayerHand",1);
        startActivity(intent);
    }
    public void onButtonPa(View view){
        Intent intent = new Intent(this,MainActivity02.class);
        intent.putExtra("PlayerHand",2);
        startActivity(intent);
    }
}

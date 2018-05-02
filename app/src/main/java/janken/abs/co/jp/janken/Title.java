package janken.abs.co.jp.janken;

import android.content.Intent;
import android.os.Build;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title);
      //  TextView battleRecord = findViewById(R.id.BattleHisCom);
     // battleRecord.setText(container.getWinNumber_()+"勝ち"+container.getLoseNumber_()+"負け"+container.getDrawNumber_()+"引き分け");
    }

    public void onClickStart(View veiw) {
        Intent intent = new Intent(this, ModeSelect.class);
        startActivity(intent);
    }

    public void OnClickReset(View view){

    }

}




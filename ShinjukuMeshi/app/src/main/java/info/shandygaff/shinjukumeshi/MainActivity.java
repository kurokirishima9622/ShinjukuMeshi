package info.shandygaff.shinjukumeshi;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bt1;
    Button bt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //はじめにDB作る
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.close();

        bt1 = (Button)findViewById(R.id.button1);
        bt2 = (Button)findViewById(R.id.button2);

        bt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                bt1Clicked(v);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                bt2Clicked(v);
            }
        });
    }

    protected void bt1Clicked(View v){
        Intent intent = new Intent(MainActivity.this,RecommendShopActivity.class);
        startActivity(intent);
    }

    protected void bt2Clicked(View v){
        Intent intent = new Intent(MainActivity.this,ShoplistActivity.class);
        startActivity(intent);
    }
}

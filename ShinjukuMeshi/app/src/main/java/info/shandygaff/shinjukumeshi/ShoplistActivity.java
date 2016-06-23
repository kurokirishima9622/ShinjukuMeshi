package info.shandygaff.shinjukumeshi;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShoplistActivity extends AppCompatActivity {
    ArrayList<Hoge> list;
    ListView lv;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoplist);

        et = (EditText)findViewById(R.id.inputText);
        Button bt = (Button)findViewById(R.id.searchButton);
        lv = (ListView)findViewById(R.id.shopList);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select();
            }
        });

        select();
    }
    public void select(){//名前後で変える
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        //データベースオブジェクトを取得する（データベースにアクセスすると作成される。）
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        DAO dao = new DAO(db);
        //検索蘭が空だったら全件
        if(et.getText().toString().equals("")){

            list=  dao.select();
        }else{
            list=dao.select(et.getText().toString());
        }


        db.close();

        int itemLayoutId = R.layout.list;
        ArrayAdapter<Hoge> adapter = new ArrayAdapter<Hoge>(this,itemLayoutId, list);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int a = list.get(position).getId();
                details(a);

            }
        });
    }

    public void details(int id){
        Intent intent = new Intent(getApplicationContext(),ShopDetailsActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
}

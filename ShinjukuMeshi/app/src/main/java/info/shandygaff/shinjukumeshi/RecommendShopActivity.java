package info.shandygaff.shinjukumeshi;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RecommendShopActivity extends AppCompatActivity {
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_shop);

        tv1=(TextView)findViewById(R.id.textView9);
        tv2=(TextView)findViewById(R.id.textView10);
        tv3=(TextView)findViewById(R.id.textView11);
        tv4=(TextView)findViewById(R.id.textView12);
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        //データベースオブジェクトを取得する（データベースにアクセスすると作成される。）
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        DAO dao = new DAO(db);
        Hoge hoge = new Hoge();
        hoge =  dao.select(5);
        db.close();
        tv1.setText("店名:"+hoge.getName());
        tv2.setText("住所:"+hoge.getAddress());
        tv3.setText("電話番号:"+hoge.getPhone());
        tv4.setText("予算:"+hoge.getYosan());

    }
}

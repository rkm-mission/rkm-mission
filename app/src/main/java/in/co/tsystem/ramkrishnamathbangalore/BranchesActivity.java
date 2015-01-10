package in.co.tsystem.ramkrishnamathbangalore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;


public class BranchesActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.requestWindowFeature(Window.FEATURE_NO_TITLE);


    Intent myIntent = getIntent();
    int val = myIntent.getIntExtra("return_from_map", 0);
    if (val == 1) {
        finish();
    }

    setContentView(R.layout.activity_branch_map_option);
    final Button button, button2;

    button = (Button) findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(BranchesActivity.this, MapActivity.class);
            intent.putExtra("branch", 0);
            startActivity(intent);
        }

    });

    button2 = (Button) findViewById(R.id.button2);
    button2.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(BranchesActivity.this, MapActivity.class);
            intent.putExtra("branch", 1);
            startActivity(intent);
        }

    });
}
}
package clear.back;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Sub extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView tv = new TextView(this);
        tv.setText("Test3_1Activity");
        setContentView(tv);
    }
}
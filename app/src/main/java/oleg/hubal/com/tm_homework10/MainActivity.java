package oleg.hubal.com.tm_homework10;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import oleg.hubal.com.tm_homework10.Fragments.BallFragment;
import oleg.hubal.com.tm_homework10.Fragments.HeartFragment;
import oleg.hubal.com.tm_homework10.Fragments.ListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_ball:
                openBallAnimFragment();
                return true;
            case R.id.menu_list:
                openListAnimFragment();
                return true;
            case R.id.menu_heart:
                openHeartAnimFragment();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openBallAnimFragment() {
        BallFragment ballFragment = new BallFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frgm_container_AM, ballFragment)
                .commit();
    }

    private void openListAnimFragment() {
        ListFragment listFragment = new ListFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frgm_container_AM, listFragment)
                .commit();
    }

    private void openHeartAnimFragment() {
        HeartFragment heartFragment = new HeartFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frgm_container_AM, heartFragment)
                .commit();
    }
}

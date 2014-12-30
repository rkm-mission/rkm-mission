package com.example.ramkrishnamathandmission;

import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.view.Window;


public class MainActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;


    String[] nav_array;

    //Create media player global variable
    MediaPlayer mPlayer;

    private boolean soundon = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // start music on app launch
        startMusic();

        Resources resource = getResources();
        nav_array = resource.getStringArray(R.array.nav_drawer_array);
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
               (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    protected void onResume() {
        super.onResume();
        //stopMusic();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopMusic();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopMusic();
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        try {
            switch (position) {
                case 0:
                    Intent intent = new Intent(MainActivity.this, RamkrishnaMathandMission.class);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(MainActivity.this, Vedanta.class);
                    startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(MainActivity.this, Festival.class);
                    startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(MainActivity.this, Ideology.class);
                    startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(MainActivity.this, SriRamakrishna.class);
                    startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(MainActivity.this, SaradaDevi.class);
                    startActivity(intent);
                    break;
                case 6:
                    intent = new Intent(MainActivity.this, SwamiVivekananda.class);
                    startActivity(intent);
                    break;
                case 7:
                    intent = new Intent(MainActivity.this, Emblem.class);
                    startActivity(intent);
                    break;
                case 8:
                    intent = new Intent(MainActivity.this, BranchesActivity.class);
                    startActivity(intent);
                    break;
                case 9:
                    intent = new Intent(MainActivity.this, DonationPage.class);
                    startActivity(intent);
                    break;
                case 10:
                    intent = new Intent(MainActivity.this, Subscribe.class);
                    startActivity(intent);
                    break;
                case 11:
                    intent = new Intent(MainActivity.this, ContactUs.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        }
        catch (Exception e) {
        }
        finally {

            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, PlaceholderFragment.newInstance(position + 1 ))
                    .commit();
        }
    }

    public void onSectionAttached(int number) {
                mTitle = getString(R.string.app_name);
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            if (soundon) {
                // switchoff sound
                stopMusic();
            }else {
                // switch on sound
                startMusic();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

    public void startMusic(){
        mPlayer = MediaPlayer.create(getApplicationContext(), R.raw.rkm_song);
        mPlayer.setLooping(true);
        mPlayer.start();//Start playing the music
        soundon = true;
    }
    public void stopMusic(){
        //set the toggle button status to OFF
        if(mPlayer!=null && mPlayer.isPlaying()){//If music is playing already
            mPlayer.stop();//Stop playing the music
            soundon = false;
        }
    }

}

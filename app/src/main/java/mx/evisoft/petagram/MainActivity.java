package mx.evisoft.petagram;

/**
 * Created by Evana Margain Puig on 24/07/16.
 */

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import mx.evisoft.petagram.Activity.AcercaDeActivity;
import mx.evisoft.petagram.Activity.ContactoActivity;
import mx.evisoft.petagram.fragment.PerfilFragment;
import mx.evisoft.petagram.fragment.RecyclerViewFragment;

import java.util.ArrayList;

import mx.evisoft.petagram.Activity.FavoritosActivity;
import mx.evisoft.petagram.adapter.PageAdapter;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Toolbar tb = (Toolbar) findViewById(R.id.miActionBar);
        tb.inflateMenu(R.menu.action_favoritos);
        tb.setOnMenuItemClickListener(
                new Toolbar.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.action_favs:
                                Intent intentFavoritos = new Intent(MainActivity.this, FavoritosActivity.class);
                                startActivity(intentFavoritos);
                                return onOptionsItemSelected(item);
                            case R.id.action_contacto:
                                Intent intentContacto = new Intent(MainActivity.this, ContactoActivity.class);
                                startActivity(intentContacto);
                                return onOptionsItemSelected(item);
                            case  R.id.action_acerca_de:
                                Intent intentAcercaDe = new Intent(MainActivity.this, AcercaDeActivity.class);
                                startActivity(intentAcercaDe);
                                return onOptionsItemSelected(item);
                        }

                        return false;
                    }
                });

        return true;
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_animales_comapnia);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_name);
    }


}

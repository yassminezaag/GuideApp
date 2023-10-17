package yassmine.epi.projet

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.icu.text.CaseMap.Title
import android.net.Uri
import android.os.Build
import android.telephony.SmsManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import yassmine.epi.projet.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    lateinit var binding: ActivityMenuBinding
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

            binding.txtlocal.setOnClickListener({
                intent = Intent(this,MapsActivity::class.java)
                startActivity(intent)

            })

            binding.txtcomp.setOnClickListener({
                intent = Intent(this,CompetitionActivity::class.java)
                startActivity(intent)
            })

        binding.txtConv.setOnClickListener({
            intent = Intent(this, ConvertisseurActivity::class.java)
            startActivity(intent)
        })

        binding.txthotel.setOnClickListener({
            intent = Intent(this, HotelsActivity::class.java)
            startActivity(intent)
        })



            binding.apply {
            toggle= ActionBarDrawerToggle(this@MenuActivity,drawerLayout,R.string.open,R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navView.setNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.menu_home -> {

                    }
                    R.id.menu_police -> {

                            if (ActivityCompat.checkSelfPermission(this@MenuActivity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                            {
                                ActivityCompat.requestPermissions(this@MenuActivity, arrayOf(Manifest.permission.CALL_PHONE), 1)
                            } else
                                intent=Intent(Intent.ACTION_CALL, Uri.parse("tel:"+resources.getString(R.string.phone_number)))
                                startActivity(intent)
                    }
                }
                  true
            }

        }
      /*  private fun replaceFragment(fragment: Fragment,title : String) {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frameL)
        }
*/
    }
        override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            true
        }
        return super.onOptionsItemSelected(item)
    }




}
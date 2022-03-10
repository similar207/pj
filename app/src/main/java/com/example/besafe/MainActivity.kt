package com.example.besafe

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import com.example.besafe.databinding.ActivityMainBinding
import java.lang.Exception
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import android.content.Intent as Intent

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getHashKey()

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)

        btn2.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }

        btn1.setOnClickListener {
            val intent = Intent(this, WaytoguideActivity::class.java)
            startActivity(intent)
        }


    }

    //카카오 해시키
    @RequiresApi(Build.VERSION_CODES.P)
    private fun getHashKey() {
        try{
            val info = packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNING_CERTIFICATES)
            val signatures = info.signingInfo.apkContentsSigners
            val md = MessageDigest.getInstance("SHA")
            for (signature in signatures) {
                val md: MessageDigest
                md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                val key = String(Base64.encode(md.digest(), 0))
                Log.d("Hash Key: ", "!@!@!key!@!@!")
            }
        } catch(e: Exception){
            Log.e("not fount", e.toString())
        }
    }


}
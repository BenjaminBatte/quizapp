package com.benjamin.quizapplication

import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.benjamin.quizapplication.databinding.ActivityMainBinding
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var kenya = findViewById<CheckBox>(R.id.kenya);
        var utah = findViewById<CheckBox>(R.id.utah);
        var texas = findViewById<CheckBox>(R.id.texas);

        val rg = findViewById<RadioGroup>(R.id.rg);
        val sub = findViewById<Button>(R.id.btnSub);
        val cancel = findViewById<Button>(R.id.cancel);

        var totalMark=0;


        cancel.setOnClickListener {
            rg.clearCheck();
            kenya.isChecked=false
            utah.isChecked=false
            texas.isChecked=false
            totalMark=0;

        }


        sub.setOnClickListener {



            val selectedOption: Int = rg!!.checkedRadioButtonId
            val radioButton = findViewById<RadioButton>(selectedOption)
            var animal: String = radioButton.text.toString();
            if(animal.equals("Cheetah")){
                totalMark= totalMark+50;
            }

            if(kenya!!.isChecked){
                totalMark= totalMark+0;
            }
            if(texas.isChecked){
                totalMark= totalMark+25;
            }
            if(utah.isChecked){
                totalMark= totalMark+25;
            }

            var builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Quiz Results as at "+ LocalDate.now().toString())
            builder.setMessage("Congulatulations you scored "+totalMark+" %")


            builder.setPositiveButton("Yes"){
                    dialogInterface, which ->
                dialogInterface.dismiss()
                totalMark=0;
                finish()
            }

            builder.setNegativeButton("Cancel"){
                    dialogInterface, which ->
                totalMark=0;
                dialogInterface.dismiss()
            }

            val dialog: AlertDialog = builder.create();
            dialog.show();
        }

    }
}
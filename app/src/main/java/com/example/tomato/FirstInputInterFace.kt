package com.example.tomato

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_first_input_inter_face.*

class FirstInputInterFace : AppCompatActivity() {
    var Text_View: TextView? = null
    var Edit_Text: EditText? = null
    var restNumber = intent?.getBundleExtra("restNumber")?.getInt("restTime")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_input_inter_face)

        supportActionBar!!.hide()

        Text_View = findViewById<View>(R.id.Text_View) as TextView
        Edit_Text = findViewById<View>(R.id.Edit_Text) as EditText
        setimagesuccess()

    }

    fun setimagesuccess(){
        Glide.with(this)
                .load(R.drawable.pizza)
                .apply(RequestOptions.bitmapTransform(CircleCrop()))
                .into(imageView_pizza)
    }

    fun Save(v: View?) {


        val it_Record = Intent(this, Record::class.java)
        var restNumber = intent?.getIntExtra("restNumber", 0)
        // Intent it_SecondRest = new Intent(this,second_rest.class);
        if ("" == Edit_Text!!.text.toString().trim { it <= ' ' }) Toast.makeText(
            applicationContext,
            "請輸入內容~",
            Toast.LENGTH_SHORT
        ).show() else {
            it_Record.putExtra("內容1", Edit_Text!!.text.toString())
            it_Record.putExtra("次數1", 1)
            it_Record.putExtra("restNumber", restNumber)
            setResult(Activity.RESULT_OK, it_Record)
            startActivityForResult(it_Record, 1)
            finish()
        }
    }
}
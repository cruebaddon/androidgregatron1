package uk.co.cruentus.gregatron1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.* //everything in the activity_main xml?


public class gregLearning {

    //fun dothestuff(){text1.text = "button working"}


}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text2.text = "Kotlin for Android rocks!"

        var ghvbutton1 = Button(this)

        //ghvbutton1.setOnClickListener {val intent = Intent(this,aaaa)
//            startActivity(intent)
    }

}





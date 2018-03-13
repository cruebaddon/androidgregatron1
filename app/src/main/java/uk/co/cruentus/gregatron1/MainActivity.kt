package uk.co.cruentus.gregatron1

import android.support.v7.app.AppCompatActivity //MainActivity
import kotlinx.android.synthetic.main.activity_main.* //everything in the activity_main xml?

import android.os.Bundle //Bundle
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.BroadcastReceiver

import java.lang.System.currentTimeMillis
import java.util.*  //Date and Calendar
import java.text.SimpleDateFormat


class MainActivity : AppCompatActivity() {

    private val tickReceiver by lazy {makeBroadcastReceiver()}

    fun getCurrentTime(units:Int): String {
        val simpleDateFormat =
                when (units){
                    0 -> SimpleDateFormat("HH:mm", Locale.UK)
                    1 -> SimpleDateFormat("HH")
                    2 -> SimpleDateFormat("mm")
                    else -> SimpleDateFormat("HH:mm", Locale.US)
                }
        return simpleDateFormat.format(currentTimeMillis())
    }


    fun getCurrentTimeStamp(): String {
        val simpleDateFormat = SimpleDateFormat("HH:mm", Locale.UK)
        val now = currentTimeMillis()
        return simpleDateFormat.format(now)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerReceiver(tickReceiver, IntentFilter(Intent.ACTION_TIME_TICK))

        //fun onClick(){text2.text ="button works"}

        //val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            texttest.text = "TEST oncreate tuesday   "+getCurrentTime(2) + "  more text to see what happens and if it'll wrap"
            textclock.text = getCurrentTimeStamp()
            text3.text = "Sono le "+numeri[getCurrentTime(1).toInt()] + " e " + numeri[getCurrentTime(2).toInt()]
        }
    }

    private fun makeBroadcastReceiver():BroadcastReceiver{
        return object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent?) {
                if (intent?.action == Intent.ACTION_TIME_TICK) {
                    textclock.text = getCurrentTimeStamp()
                    texttest.text = "TEST receiver tuesday time: "+getCurrentTime(2) +"  more text to see what happens and if it'll wrap"
                    text3.text = "Sono le "+numeri[getCurrentTime(1).toInt()] + " e " + numeri[getCurrentTime(2).toInt()]
                }
            }
        }
    }

        val numeri = arrayOf(
            "zero","uno","due","tre","quattro","cinque","sei","sette","otto","nove",
            "dieci","undici","dodici","tredici","quattordici","quindici","sedici","diciassette","diciotto","diciannove",
            "venti","ventuno","ventidue","ventitré","ventiquattro","venticinque","ventisei","ventisette","ventotto","ventinove",
            "trenta","trentuno","trentadue","trentatré","trentaquattro","trentacinque","trentasei","trentasette","trentotto","trentanove",
            "quaranta","quarantuno","quarantadue","quarantatré","quarantaquattro","quarantacinque","quarantasei","quarantasette","quarantotto","quarantanove",
            "cinquanta","cinquantuno","cinquantadue","cinquantatré","cinquantaquattro","cinquantacinque","cinquantasei","cinquantasette","cinquantotto","cinquantanove",
            "sessanta","sessantuno","sessantadue","sessantatré","sessantaquattro","sessantacinque","sessantasei","sessantasette","sessantotto","sessantanove",
            "settanta","settantuno","settantadue","settantatré","settantaquattro","settantacinque","settantasei","settantasette","settantotto","settantanove",
            "ottanta","ottantuno","ottantadue","ottantatré","ottantaquattro","ottantacinque","ottantasei","ottantasette","ottantotto","ottantanove",
            "novanta","novantuno","novantadue","novantatré","novantaquattro","novantacinque","novantasei","novantasette","novantotto","novantanove"
        )
}

//https://www.raywenderlich.com/165824/introduction-android-activities-kotlin

//var timeStamp = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) + ""
//consider listening to the ACTION_TIME_TICK, ACTION_TIME_CHANGED
// and ACTION_TIMEZONE_CHANGED Intent broadcasts to find out when the time changes.

//(time:String)


//val numeri0 = arrayOf("zero","uno","due","tre","quattro","cinque","sei","sette","otto","nove")
//val numeri1 = arrayOf("dieci","undici","dodici","tredici","quattordici","quindici","sedici","diciassette","diciotto","diciannove")
//val numeri2 = arrayOf("venti","ventuno","ventidue","ventitré","ventiquattro","venticinque","ventisei","ventisette","ventotto","ventinove")
//val numeri3 = arrayOf("trenta","trentuno","trentadue","trentatré","trentaquattro","trentacinque","trentasei","trentasette","trentotto","trentanove")
//val numeri4 = arrayOf("quaranta","quarantuno","quarantadue","quarantatré","quarantaquattro","quarantacinque","quarantasei","quarantasette","quarantotto","quarantanove")
//val numeri5 = arrayOf("cinquanta","cinquantuno","cinquantadue","cinquantatré","cinquantaquattro","cinquantacinque","cinquantasei","cinquantasette","cinquantotto","cinquantanove")
//val numeri6 = arrayOf("sessanta","sessantuno","sessantadue","sessantatré","sessantaquattro","sessantacinque","sessantasei","sessantasette","sessantotto","sessantanove")
//val numeri7 = arrayOf("settanta","settantuno","settantadue","settantatré","settantaquattro","settantacinque","settantasei","settantasette","settantotto","settantanove")
//val numeri8 = arrayOf("ottanta","ottantuno","ottantadue","ottantatré","ottantaquattro","ottantacinque","ottantasei","ottantasette","ottantotto","ottantanove")
//val numeri9 = arrayOf("novanta","novantuno","novantadue","novantatré","novantaquattro","novantacinque","novantasei","novantasette","novantotto","novantanove")
//val numeri = arrayOf(numeri0,numeri1,numeri2,numeri3,numeri4,numeri5,numeri6,numeri7,numeri8,numeri9)

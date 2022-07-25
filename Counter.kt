import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val timer=MyCounter(10000,1000)
    var counterValue:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startBtn.setOnClickListener{
            timer.start()
            startBtn.isEnabled= false
        }
        stopBtn.setOnClickListener{
            timer.cancel()
            startBtn.isEnabled=true
        }
    }
    inner class MyCounter(milliInFuture: Long,countDownInterval: Long):CountDownTimer(milliInFuture,countDownInterval){
        override fun onFinish(){
        }
        override fun onTick(milliUntilFinisher:Long)
        {
            counterValue++
            viewNumber.text=counterValue.toString()
        }
    }
}
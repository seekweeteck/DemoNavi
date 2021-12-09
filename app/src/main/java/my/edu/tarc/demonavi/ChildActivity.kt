package my.edu.tarc.demonavi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ChildActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child)
        Toast.makeText(this, "This is a toast", Toast.LENGTH_SHORT).show()
    }
}
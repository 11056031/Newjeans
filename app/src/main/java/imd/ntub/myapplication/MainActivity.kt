package imd.ntub.myapplication
/*
組員

11056008吳柏丞
11056017吳佳憲
11056031陳廷軒
 */
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.view.MotionEvent
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.content.Intent


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 初始化视图
        val nt = findViewById<TextView>(R.id.nt)
        val ntp = findViewById<EditText>(R.id.ntp)
        val ntp2 = findViewById<EditText>(R.id.ntp2)
        val ntp3 = findViewById<EditText>(R.id.ntp3)
        val Music = findViewById<RadioGroup>(R.id.Music)
        val Card = findViewById<RadioGroup>(R.id.Card)
        val cb1 = findViewById<CheckBox>(R.id.cb1)
        val cb2 = findViewById<CheckBox>(R.id.cb2)
        val cb3 = findViewById<CheckBox>(R.id.cb3)
        val rb1 = findViewById<RadioButton>(R.id.rb1)
        val rb2 = findViewById<RadioButton>(R.id.rb2)
        val rb3 = findViewById<RadioButton>(R.id.rb3)
        val rb4 = findViewById<RadioButton>(R.id.rb4)
        val b1 = findViewById<Button>(R.id.b1)
        val b2 = findViewById<Button>(R.id.b2)

        // 确认购买按钮的点击事件监听器
        b1.setOnClickListener {
            // 创建一个确认购买的对话框
            val builder = AlertDialog.Builder(this)
            builder.setTitle("是否確認購買")
            builder.setMessage("您確認是否要購買所選項目？")
            // 设置确认按钮，并在点击时处理确认购买的逻辑
            builder.setPositiveButton("確認") { dialog, which ->
                // 获取专辑A和专辑B的选择状态
                val isAlbumASelected = rb1.isChecked
                val isCardA = rb3.isChecked
                // 获取复选框的选择状态
                val isPostcardSelected = cb1.isChecked
                val isCalendarSelected = cb2.isChecked
                val isNotebookSelected = cb3.isChecked

                // 定义专辑的价格
                val albumAPrice = 388
                val albumBPrice = 420
                // 定义小卡的价格
                val cardAPrice = 60
                val cardBPrice = 50
                // 定义其他的价格
                val postcardPrice = 60
                val calendarPrice = 120
                val notebookPrice = 80

                // 获取专辑数量
                val albumQuantity = ntp2.text.toString().toIntOrNull() ?: 0
                // 获取小卡数量
                val cardQuantity = ntp3.text.toString().toIntOrNull() ?: 0

                // 计算选择的专辑的价格
                val selectedAlbumPrice = if (isAlbumASelected) albumAPrice else albumBPrice
                val albumTotalPrice = selectedAlbumPrice * albumQuantity

                // 计算选择的小卡的价格
                val selectedCardPrice = if (isCardA) cardAPrice else cardBPrice
                val cardTotalPrice = selectedCardPrice * cardQuantity

                // 计算选择的其他物品的价格
                var totalPrice = albumTotalPrice + cardTotalPrice
                if (isPostcardSelected) {
                    totalPrice += postcardPrice
                }
                if (isCalendarSelected) {
                    totalPrice += calendarPrice
                }
                if (isNotebookSelected) {
                    totalPrice += notebookPrice
                }

                // 不再使用 Total，而是直接将总金额传递到下一个活动中
                val intent = Intent(this, Order1::class.java)
                intent.putExtra("totalPrice", totalPrice.toString())
                intent.putExtra("selectedAlbum", isAlbumASelected) // 传递专辑选择状态
                intent.putExtra("selectedCard", isCardA) // 传递小卡选择状态
                intent.putExtra("isPostcardSelected", isPostcardSelected) // 传递明信片选择状态
                intent.putExtra("isCalendarSelected", isCalendarSelected) // 传递日历选择状态
                intent.putExtra("isNotebookSelected", isNotebookSelected) // 传递笔记本选择状态
                startActivity(intent)
            }
            // 设置取消按钮，并在点击时关闭对话框
            builder.setNegativeButton("取消") { dialog, which ->
                dialog.dismiss()
            }
            // 创建并显示对话框
            val dialog = builder.create()
            dialog.show()
        }


        // 重置按钮的点击事件监听器
        b2.setOnClickListener {
            // 清除EditText中的文本
            ntp.text.clear()
            ntp2.text.clear()
            ntp3.text.clear()

            // 清除RadioGroup中的选中状态
            Music.clearCheck()
            Card.clearCheck()

            // 清除CheckBox中的选中状态
            cb1.isChecked = false
            cb2.isChecked = false
            cb3.isChecked = false
        }

        // 在 onCreate 方法中设置触摸监听器
        ntp.setOnTouchListener { v, event ->
            // 当用户触摸 EditText 时，清空文本并返回 false 表示继续处理触摸事件
            ntp.text.clear()
            false
        }

        ntp2.setOnTouchListener { v, event ->
            // 当用户触摸 EditText 时，清空文本并返回 false 表示继续处理触摸事件
            ntp2.text.clear()
            false
        }

        ntp3.setOnTouchListener { v, event ->
            // 当用户触摸 EditText 时，清空文本并返回 false 表示继续处理触摸事件
            ntp3.text.clear()
            false
        }
    }
}

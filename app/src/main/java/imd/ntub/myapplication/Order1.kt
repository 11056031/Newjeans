package imd.ntub.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent

class Order1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order1)

        val selectedAlbumTextView = findViewById<TextView>(R.id.selectedAlbumTextView)
        val selectedCardTextView = findViewById<TextView>(R.id.selectedCardTextView)
        val selectedPostcardTextView = findViewById<TextView>(R.id.selectedPostcardTextView)
        val selectedCalendarTextView = findViewById<TextView>(R.id.selectedCalendarTextView)
        val selectedNotebookTextView = findViewById<TextView>(R.id.selectedNotebookTextView)
        val totalPriceTextView = findViewById<TextView>(R.id.totalPriceTextView)
        val buyButton = findViewById<Button>(R.id.buyButton)

        // 获取从 MainActivity 传递过来的数据
        val totalPrice = intent.getStringExtra("totalPrice")
        val selectedAlbum = intent.getBooleanExtra("selectedAlbum", false)
        val selectedCard = intent.getBooleanExtra("selectedCard", false)
        val isPostcardSelected = intent.getBooleanExtra("isPostcardSelected", false)
        val isCalendarSelected = intent.getBooleanExtra("isCalendarSelected", false)
        val isNotebookSelected = intent.getBooleanExtra("isNotebookSelected", false)

        // 根据选择的选项设置文本视图的内容
        if (totalPrice != null) {
            totalPriceTextView.text = "總金額: $totalPrice$"
        }
        // 设置專輯版本信息
        selectedAlbumTextView.text = "專輯版本: ${if (selectedAlbum || selectedCard || isPostcardSelected || isCalendarSelected || isNotebookSelected)
        { if (selectedAlbum) "專輯 A" else "專輯 B" } else { "" }}"
        // 设置小卡版本信息
        selectedCardTextView.text = "小卡版本: ${if (selectedCard || isPostcardSelected || isCalendarSelected || isNotebookSelected)
        { if (selectedCard) "小卡 A" else "小卡 B" } else { "" }}"
        // 设置明信片信息
        selectedPostcardTextView.text = "是否有明信片: ${if (isPostcardSelected || isCalendarSelected || isNotebookSelected)
        { if (isPostcardSelected) "是" else "" } else { "" }}"
        // 设置日曆信息
        selectedCalendarTextView.text = "是否有日曆: ${if (isCalendarSelected || isNotebookSelected)
        { if (isCalendarSelected) "是" else "" } else { "" }}"
        // 设置笔记本信息
        selectedNotebookTextView.text = "是否有筆記本: ${if (isNotebookSelected) "是" else "" }"


        // 设置购买按钮的点击事件
        buyButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}


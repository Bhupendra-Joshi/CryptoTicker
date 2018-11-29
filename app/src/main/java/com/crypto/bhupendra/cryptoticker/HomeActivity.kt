package com.crypto.bhupendra.cryptoticker

import android.app.PictureInPictureParams
import android.databinding.DataBindingUtil
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import android.util.Rational
import android.view.View
import android.view.View.OnClickListener
import com.crypto.bhupendra.cryptoticker.databinding.ActivityHomeBinding
import com.crypto.bhupendra.cryptoticker.network.models.Response
import com.crypto.bhupendra.cryptoticker.util.CustomItemTouchHelperCallback
import com.crypto.bhupendra.cryptoticker.util.RecyclerDecoration
import com.crypto.bhupendra.cryptoticker.util.TextUtil

class HomeActivity : AppCompatActivity(), OnClickListener, OnUpdate {

    private var binding: ActivityHomeBinding? = null
    private var ticker: Response? = null
    private var list = ArrayList<String>()
    private var adapter: RecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ticker = Response()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding?.btnRefresh?.setOnClickListener(this)
        binding?.ticker = ticker
        adapter = RecyclerAdapter(list)
        binding?.rvList?.adapter = adapter
        binding?.rvList?.layoutManager = LinearLayoutManager(this)
        setRecyclerDecorator()
    }

    private fun addItemsToList() {
        list.add("Item 1")
        list.add("Item 2")
        list.add("Item 3")
        list.add("Item 4")
        list.add("Item 5")
        list.add("Item 6")
        list.add("Item 7")
        list.add("Item 8")
        list.add("Item 9")
        list.add("Item 10")
        list.add("Item 11")
        list.add("Item 12")
        list.add("Item 13")
        list.add("Item 14")
        list.add("Item 15")
        list.add("Item 16")
        list.add("Item 18")
        list.add("Item 19")
        list.add("Item 20")
        list.add("Item 21")
    }

    override fun onClick(v: View?) {
//        var userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36"
//        var cookie = "__cfduid=dc9f60a85c80f6ad4cd9999747de1be881513675615; _ga=GA1.2.591049238.1513675619; _gid=GA1.2.1019550137.1513675619; AWSALB=vGdHdYM64Zweub9za/OQeVYJFta+cVeFIuKi31W2lnoQ+35uAXjUZngcagZiGkekHeU996952KhmSlrOlKZ3hwplCQ0wxGgbL42hMBWlv/E/yjKe5Zpy/X5pXuB3; _koinex-frontend_session=UVFhS3VIejdzSGhjZ1RXd0wvTWMxM3lDQTk1aUFMOHhEeUl3ZktPdDV5bHlTVFRxbWR6YTZaMXpqNEJRMUxaZkNKbFF4VExWd1JMZ2x6OGlKNy9jbmFlR0NYanR3UVVtZUQxeXFNcGNrdXptQ3M2ZnAyUnVGNTc0ZXNDa292bWZyakxqZVpoYXpnWStXTjhGd0h1cXhnPT0tLWlnT1ZUUXdHeTQ3Zjlpb1RVVjRyb2c9PQ%3D%3D--1cff369a41e003c5993b6d432b3fd57eff29b076; cf_clearance=0e72252fcba4acb07faec8b077e1f044f5e92013-1513743785-7200"
//
//        TickerManager(this, cookie, userAgent).getTicker()
//        v?.visibility = View.GONE;
    }

    private fun setRecyclerDecorator() {
        addItemsToList()

        var decoration = RecyclerDecoration(this)
        binding?.rvList?.addItemDecoration(decoration)


        var touchHelper = ItemTouchHelper(CustomItemTouchHelperCallback(ItemTouchHelper.UP + ItemTouchHelper.DOWN, ItemTouchHelper.RIGHT + ItemTouchHelper.LEFT, this))

        touchHelper.attachToRecyclerView(binding?.rvList)
    }

    override fun onUpdateTicker(ticker: Response) {
        ticker.BTC = TextUtil.formatNumberString(ticker.BTC)
        ticker.ETH = TextUtil.formatNumberString(ticker.ETH)
        ticker.BCH = TextUtil.formatNumberString(ticker.BCH)
        ticker.XRP = TextUtil.formatNumberString(ticker.XRP)
        ticker.LTC = TextUtil.formatNumberString(ticker.LTC)
        ticker.MIOTA = TextUtil.formatNumberString(ticker.MIOTA)
        ticker.OMG = TextUtil.formatNumberString(ticker.OMG)
        ticker.GNT = TextUtil.formatNumberString(ticker.GNT)

        binding?.ticker = ticker
        binding?.executePendingBindings()
    }

    override fun onRemoveItem(position: Int) {
        adapter?.removeItemFromList(position)
    }

    override fun onChangeposition(originalPosition: Int, targetPosition: Int) {
//        adapter?.changeItemPosition(originalPosition, targetPosition)
        adapter?.notifyItemMoved(originalPosition, targetPosition)
    }

    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        val build = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val build = PictureInPictureParams.Builder()
                    .setAspectRatio(Rational(300, 240))
                    .build()
            enterPictureInPictureMode(build)
        } else {
            TODO("VERSION.SDK_INT < O")
        }
    }

}

interface OnUpdate {

    fun onUpdateTicker(ticker: Response)

    fun onRemoveItem(position: Int)

    fun onChangeposition(originalPosition: Int, targetPosition: Int)
}

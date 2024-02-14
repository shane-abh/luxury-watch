package com.example.project1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase

class CartActivity : AppCompatActivity() {

    private var adapter: CartAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val query = FirebaseDatabase.getInstance().reference.child("productList").child("rolex")

        val options = FirebaseRecyclerOptions.Builder<Cart>().setQuery(query, Cart::class.java).build()
        System.out.println(query)
        System.out.println("options")

        adapter = CartAdapter(options)

        val rView:RecyclerView = findViewById(R.id.rView)
        rView?.layoutManager = LinearLayoutManager(this )
        rView?.adapter = adapter

    }
    override fun onStart() {
        super.onStart()
        adapter?.startListening()
    }
    override fun onStop() {
        super.onStop()
        adapter?.stopListening()
    }
}
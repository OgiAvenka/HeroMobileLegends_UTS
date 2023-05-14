package com.example.heromobilelegends_uts.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heromobilelegends_uts.DetailMovieActivity
import com.example.heromobilelegends_uts.Movie
import com.example.heromobilelegends_uts.MovieAdapter
import com.example.heromobilelegends_uts.R

class ExploreFragment : Fragment() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter : MovieAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieArrayList : ArrayList<Movie>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var descriptions: Array<String>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_movie)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
//        adapter = MovieAdapter(movieArrayList)
        recyclerView.adapter = context?.let {
            MovieAdapter(it, movieArrayList){
                val intent = Intent(context, DetailMovieActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)
            }
        }

    }

    private fun dataInitialize() {
        movieArrayList = arrayListOf<Movie>()

        image = arrayOf(
            R.drawable.akai,
            R.drawable.alucard,
            R.drawable.claude,
            R.drawable.esmeralda,
            R.drawable.estes,
            R.drawable.karrie,
            R.drawable.clint,
            R.drawable.cecilion,
            R.drawable.lancelot,
            R.drawable.zilong,

            )

        title = arrayOf(
            "AKAI",
            "ALUCARD",
            "CLAUDE",
            "ESMERALDA",
            "ESTES",
            "KARRIE",
            "CLINT",
            "CECILION",
            "LANCELOT",
            "ZILONG",


            )

        descriptions = arrayOf(
            "Akai merupakan salah satu hero Tank terkuat di Mobile Legends yang punya kemampuan luar biasa. Skill ultimate miliknya, yaitu Heavy Spin sangat berguna untuk mengacaukan gerakan lawan atau menahan pergerakan lawan",
            "Alucard merupakan salah satu hero Mobile Legends: Bang Bang yang kerap digunakan sebagai offlaner. Alucard sendiri sebenarnya masuk dalam tipe fighter dan memiliki kemampuan lifesteal yang tinggi. Selain itu, Alucard juga dibekali dengan damage yang besar sehingga kerap menjadi kunci kemenangan sebuah tim.",
            "Claude sendiri merupakan salah satu hero dengan role Marksman di game Mobile Legends. Claude saat ini dikenal sebagai salah satu hero Marksman tersulit dan butuh skill mekanik tinggi, pasalnya sang pemain harus tahu timing untuk masuk ke dalam pertempuran dan keluar dari posisi berbahaya secepatnya.",
            "Mobile Legends: Bang Bang (MLBB) kembali merilis rekomendasi terbaru build terbaru untuk heronya, kali ini yang akan dibahas adalah sosok Esmeralda. Hero dengan role mage atau tank ini memiliki mobilitas serta defense yang tinggi",
            "Hero Estes merupakan salah satu hero support di game Mobile Legends yang memiliki kemampuan unik dalam menyembuhkan teman-temannya. Estes merupakan karakter yang memiliki cerita perjalanan hidup yang menarik, di mana ia menjadi seorang healer yang kuat setelah melewati berbagai cobaan dan rintangan.",
            "Karrie merupakan salah satu hero MM di Mobile Legends yang juga masuk dalam meta season 27, hero ini mendapatkan buff signifikan yang membuatnya semakin berbahaya. Bahkan di turnamen-turnamen besar, Karrie masih menjadi hero pilihan para pro player bahkan menjadi langganan karena kemampuannya menghentikan tank dan fighter, terutama yang bertipe tank berdarah tinggi, Karrie memang dikenal sebagai hero killer yang sangat tahan lama dan berdamage tinggi karena skill pasifnya. Sejak awal permainan, Karrie sudah mampu memberikan damage yang signifikan, sehingga ia bisa digunakan di Gold Lane karena ia bisa bertahan bahkan menyerang, Jadi bagi pengguna Tank dan Fighter, sebaiknya berhati-hati saat bertemu Karrie karena bisa memberikan damage yang sangat tinggi kepada Tank dan Fighter. Tak heran jika hero ini juga langganan band saat di mode ranked.",
            "Clint dari segi laning menjadi salah satu hero yang cukup kuat untuk damage di early game jika head to head tanpa roamer dengan hero Marksman yang lainnya. Sebab, jika dimainkan secara benar Clint bisa mudah mencicil HP musuh berkat skill + pasifnya.",
            "Cecilion merupakan Hero mage di Mobile Legends dengan tingkat burst damage yang besar. Dalam setiap permainan baik itu classic maupun ranked Hero ini menjadi primadona bagi para user mage karena skill yang dimiliki Cecilion terbilang over power.",
            "Hero Lancelot di Mobile Legends kini masih menjadi hero assassin paling menakutkan. Untuk membuat hero Lancelot menjadi kuat, biasanya pemain akan menambahkan item build yang cocok. Hero Lancelot dikenal dengan gaya permaianan yang cepat dengan damage yang besar",
            "Zilong merupakan hero yang sangat lemah di early game. Maka dari itu pengguna Zilong disarankan untuk bermain aman pada saat fase laning sampai setidaknya kamu memiliki dua hingga tiga item baru kamu boleh bermain agresif",

            )

        for (i in image.indices) {

            val movie = Movie(image[i],title[i], descriptions[i])
            movieArrayList.add(movie)
        }

    }

}

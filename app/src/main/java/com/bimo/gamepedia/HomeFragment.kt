package com.bimo.gamepedia

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var adapter:GameAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var GameArrayList: ArrayList<Game>

    lateinit var image: Array<Int>
    lateinit var name: Array<String>
    lateinit var desc: Array<String>

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_komik)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = context?.let {
            GameAdapter(it, GameArrayList){
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)
            }
        }

    }

    fun dataInitialize(){
        GameArrayList = arrayListOf<Game>()

        image = arrayOf(
            R.drawable.apex,
            R.drawable.pubgm,
            R.drawable.gow,
            R.drawable.gta5,
            R.drawable.gtaonline,
            R.drawable.fifa,
            R.drawable.valorant,
            R.drawable.fortnite,
            R.drawable.eldenring,
            R.drawable.mlbb,
        )

        name = arrayOf(
            "Apex Legends",
            "PUBG Mobile",
            "God of War Ragnarok",
            "GTA V",
            "GTA Online",
            "FIFA 23",
            "Valorant",
            "Fortnite",
            "Elden Ring",
            "Mobile Legend Bang Bang",
        )

        desc = arrayOf(
            "Apex Legends adalah game battle royale multipemain daring yang menampilkan regu yang terdiri dari tiga pemain menggunakan karakter siap pakai dengan kemampuan khusus, yang disebut \"Legenda\", mirip dengan penembak pahlawan.",
            "PUBG adalah game penembak pemain versus pemain di mana hingga seratus pemain bertarung dalam battle royale, sejenis pertandingan kematian orang terakhir berdiri berskala besar di mana pemain berjuang untuk tetap menjadi yang terakhir hidup.",
            "God of War Ragnarök adalah game aksi-petualangan yang dikembangkan oleh Santa Monica Studio dan diterbitkan oleh Sony Interactive Entertainment. Ini dirilis di seluruh dunia pada 9 November 2022, untuk PlayStation 4 dan PlayStation 5",
            "Grand Theft Auto V adalah game aksi-petualangan yang dimainkan dari sudut pandang orang ketiga atau orang pertama. Pemain menyelesaikan misi — skenario linier dengan tujuan yang ditetapkan — untuk melanjutkan cerita. Di luar misi, pemain dapat dengan bebas menjelajahi dunia terbuka.",
            "Game ini adalah komponen daring Grand Theft Auto V. Terletak di negara bagian fiktif San Andreas (berdasarkan California Selatan), Grand Theft Auto Online memungkinkan hingga 30 pemain untuk menjelajahi lingkungan dunia terbukanya dan terlibat dalam pertandingan gim kooperatif atau kompetitif .",
            "FIFA 23 adalah video game sepak bola yang diterbitkan oleh Electronic Arts (atau hanya EA). Ini adalah angsuran ke-30 dan terakhir dalam seri FIFA yang dirilis di seluruh dunia pada 30 September 2022 untuk Nintendo Switch, PlayStation 4, PlayStation 5, Windows, Xbox One, dan Xbox Seri X/S.",
            "Valorant adalah penembak pahlawan taktis orang pertama berbasis tim yang ditetapkan dalam waktu dekat. Pemain bermain sebagai salah satu dari sekumpulan Agen, karakter yang didasarkan pada beberapa negara dan budaya di seluruh dunia.",
            "Fortnite Battle Royale adalah gim pemain-lawan-pemain hingga 100 pemain, memungkinkan seseorang untuk bermain sendiri, dalam duo, atau dalam regu (biasanya terdiri dari tiga atau empat pemain). Pemain tanpa senjata mendarat dari \"Battle Bus\" yang melintasi peta game.",
            "Elden Ring adalah perspektif orang ketiga, aksi, permainan peran dengan fokus pada pertempuran dan eksplorasi. Ini mencakup elemen yang mirip dengan yang ada di game lain yang dikembangkan FromSoftware seperti seri Dark Souls, Bloodborne, dan Sekiro: Shadows Die Twice.",
            "Mobile Legends: Bang Bang adalah permainan video seluler ber-genre multiplayer online battle arena (MOBA) yang dikembangkan dan diterbitkan oleh Moonton, anak perusahaan dari ByteDance."
            )

        for (i in image.indices){
            val komik = Game(image[i], name[i], desc[i])
            GameArrayList.add(komik)
        }
    }
}
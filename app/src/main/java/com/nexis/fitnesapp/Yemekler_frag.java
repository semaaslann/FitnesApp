package com.nexis.fitnesapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Yemekler_frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Yemekler_frag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Yemekler_frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Yemekler_frag.
     */
    // TODO: Rename and change types and number of parameters
    public static Yemekler_frag newInstance(String param1, String param2) {
        Yemekler_frag fragment = new Yemekler_frag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private void fetchYemekler() {
        db.collection("yemekler")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        yemeklers.clear(); // Yemekler listesini temizleyin

                        for (QueryDocumentSnapshot document : task.getResult()) {
                            // Firestore'dan gelen belgeleri döngüyle dolaşın ve Yemekler nesnelerini oluşturun
                            /*int logo = document.get("logo");
                            String yemekadi = document.get("yemekadi");
                            String kalori = document.get("kalori");*/

                            int logo = ((Long) document.get("logo")).intValue();
                            String yemekadi = (String) document.get("yemekadi");
                            String kalori = (String) document.get("kalori");

                            Yemekler yemek = new Yemekler(logo, yemekadi, kalori);
                            yemeklers.add(yemek);
                        }

                        myadaptor.notifyDataSetChanged(); // Adapteri güncelleyin
                    } else {
                        // Hata durumunda işlemleri ele alın
                    }
                });
    }


    RecyclerView benimrecycle;
    ArrayList<Yemekler> yemeklers;
    MyrecycAdaptor myadaptor;
    FirebaseFirestore db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_yemekler_frag, container, false);
        benimrecycle =view.findViewById(R.id.rcyclemyrecycle);
        yemeklers = new ArrayList<>();
        myadaptor = new MyrecycAdaptor(yemeklers);
        benimrecycle.setAdapter(myadaptor);
        benimrecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        myadaptor.notifyDataSetChanged();
        db = FirebaseFirestore.getInstance();

        diziolustur();

        fetchYemekler();

        CollectionReference yemeklerCollection = db.collection("yemekler");
        Yemekler yemek3 = new Yemekler(3,"Mısır","96 cal/100gr");
        Yemekler yemek4 = new Yemekler(4,"Bezelye","84");
        Yemekler yemek5 = new Yemekler(5,"Patates","76");
        Yemekler yemek6 = new Yemekler(6,"Pırasa","52");
        Yemekler yemek7 = new Yemekler(7,"Pancar","43");
        Yemekler yemek8 = new Yemekler(8,"Havuç","42");
        Yemekler yemek9 = new Yemekler(9,"Kereviz","40");
        Yemekler yemek10 = new Yemekler(10,"Fasulye","32");
        Yemekler yemek11 = new Yemekler(11,"Mantar","28");
        Yemekler yemek12 = new Yemekler(12,"Karnabahar","27");
        Yemekler yemek13 = new Yemekler(13,"Ispanak","26");
        Yemekler yemek14 = new Yemekler(14,"Lahana","24");
        Yemekler yemek15 = new Yemekler(15,"Biber","22");

        yemeklerCollection.add(yemek3);
        yemeklerCollection.add(yemek4);
        yemeklerCollection.add(yemek5);
        yemeklerCollection.add(yemek6);
        yemeklerCollection.add(yemek7);
        yemeklerCollection.add(yemek8);
        yemeklerCollection.add(yemek9);
        yemeklerCollection.add(yemek10);
        yemeklerCollection.add(yemek11);
        yemeklerCollection.add(yemek12);
        yemeklerCollection.add(yemek13);
        yemeklerCollection.add(yemek14);
        yemeklerCollection.add(yemek15);

        return view;
    }

    private void diziolustur() {
        /*yemeklers.add(new Yemekler(R.drawable.yumurta));*/
    }
}
package fr.acos.fragmentwithkotlin

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import fr.acos.fragmentwithkotlin.fragments.ActiviteCommuniqueAvecFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Récupération d'un objet représentant le fragment
       var fragment: Fragment? = supportFragmentManager.findFragmentById(R.id.activite_vers_fragment)

        //Cast du fragment afin d'accèder à la fonction "modifierMessage"
        if(fragment is ActiviteCommuniqueAvecFragment)
        {
           fragment.modifierMessage("Très bien !")
        }
    }
}


package fr.acos.fragmentwithkotlin.fragments

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import fr.acos.fragmentwithkotlin.R

/**
 * Created by acoss on 03/06/2018.
 */
//Création d'une classe héritant de la classe Fragment
class FragmentIndependant : Fragment() {

    //Représente l'activité qui contient le fragment.
    //var activiteMere:FragmentCommuniqueAvecActivite.envoyerInfoALActivite?= null;

    private lateinit var activiteMere: Activity

    //Fournit une fonction pour créer de nouvelles instances du fragment
    companion object {

        fun newInstance(): FragmentIndependant {
            return FragmentIndependant()
        }
    }

    /**
     * Création de la vue du fragment.
     */
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
    {
        //view représente le Layout du fragment.
        val view = inflater?.inflate(R.layout.fragment_independant, container, false)

        //button représente le bouton de l'ihm du fragment.
        val button =  view?.findViewById<Button>(R.id.btn_what)

        //Association d'une fonction au bouton
        button?.setOnClickListener{ onWhatsUp() }

        return view
    }

    /**
     * Fonction executée lorsque le fragment est attaché à l'activité.
     *
     * @param context Représente l'activité qui contient le fragment.
     */
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is Activity) {
            this.activiteMere = context
        }
    }

    /**
     * Fonction liée au bouton.
     */
    fun onWhatsUp() {
        //Affichage d'un toast.
        Toast.makeText(activiteMere,"Good !", Toast.LENGTH_LONG).show()
    }
}
package fr.acos.fragmentwithkotlin.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
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
class FragmentCommuniqueAvecActivite : Fragment()
{
    //Représente l'activité qui contient le fragment.
    private lateinit var activiteMere: FragmentCommuniqueAvecActivite.envoyerInfoALActivite

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
        val view = inflater?.inflate(R.layout.fragment_communique_avec_activite, container, false)

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
        if (context is FragmentCommuniqueAvecActivite.envoyerInfoALActivite) {
            this.activiteMere = context
        }
    }
    /**
     * Fonction liée au bouton.
     */
    fun onWhatsUp()
    {
        //Appel de la fonction 'onClickWhatsUp' de l'activité MainActivity
         activiteMere.onClickWhatsUp("Very Goood !!")
    }

   /**
   * Interface devant être implémenté par l'activité.
   */
   interface envoyerInfoALActivite
   {
       fun onClickWhatsUp(chaine:String)
   }

}
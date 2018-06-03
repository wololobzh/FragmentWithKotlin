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
 * Création d'une classe héritant de la classe Fragment
 */
class ActiviteCommuniqueAvecFragment : Fragment() {

    //Représente l'activité qui contient le fragment.
    private lateinit var activiteMere: Activity
     //Cette variable contient le message à afficher dans le toast.
    private var messageAAfficher:String = ""

     /**
      * Fournit une fonction pour créer de nouvelles instances du fragment
      */
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
        val view = inflater?.inflate(R.layout.activite_communique_avec_fragment, container, false)

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
      * Fonction permettant de modifier le message affiché par le toast.
      */
    fun modifierMessage(message:String)
    {
        messageAAfficher = message;
    }

    /**
     * Fonction liée au bouton.
     */
    fun onWhatsUp() {
        //Affichage d'un toast.
        Toast.makeText(activiteMere,messageAAfficher, Toast.LENGTH_LONG).show()
    }
}
package my.edu.tarc.demonavi.ui.profile

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import my.edu.tarc.demonavi.R
import my.edu.tarc.demonavi.databinding.FragmentProfileBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    //_binding is a nullable variable
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Enable Menu in a Fragment
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //For activity
        //binding = NameOfActivity.inflate(layoutInflater)

        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.imageView2.setOnClickListener {
            Log.d("Profile", "Profile Image clicked")
        }
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_profile_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_save -> {
                //Save profile data
                //Toast.makeText(context, "Record saved", Toast.LENGTH_SHORT).show()
                //Snackbar.make(binding.frameLayout, "Record saved", Snackbar.LENGTH_SHORT).show()
                val builder = AlertDialog.Builder(context)
                builder.setMessage("Save profile?")
                    .setPositiveButton("Save",
                        DialogInterface.OnClickListener { dialog, id ->
                            // Save profile
                        })
                    .setNegativeButton("Cancel",
                        DialogInterface.OnClickListener { dialog, id ->
                            // User cancelled the dialog
                        })
                // Create the AlertDialog object and return it
                builder.create().show()
                true
            }
            R.id.action_select_all ->{
                //TODO : Write code to handle select all function
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.setGroupVisible(R.id.group_menu_selection, true)
        menu.findItem(R.id.action_select_all).isVisible = true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
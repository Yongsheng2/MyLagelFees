package my.tarc.edu.mylagelfees.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import my.tarc.edu.mylagelfees.R
import my.tarc.edu.mylagelfees.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        //_binding = FragmentHomeBinding.inflate(inflater, container, false)
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageViewContactUs.setOnClickListener{
            //Implicit Intent - a general action
            //Explicit Intent - specific component
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:0342567788"))
            //call a number
            startActivity(intent)
        }
        binding.buttonCalculate.setOnClickListener{
            val sellingPrice = binding.editTextNumberSellingPrice.text.toString().toFloat()
            val downPayment = binding.editTextNumberDownPayment.text.toString().toFloat()
            val loan = sellingPrice - downPayment
            val firstTime = binding.checkBoxFirstTime.isChecked
            if(firstTime){
                //Process First Time Buyer
                //loan can be <= 90% of the sell. price

            }else{
                //Process non-first time
                //loan must more than 90% of the selling price
            }

        }

        binding.buttonReset.setOnClickListener{

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
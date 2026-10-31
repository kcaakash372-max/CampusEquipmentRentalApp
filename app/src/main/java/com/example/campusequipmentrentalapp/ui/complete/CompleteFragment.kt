package com.example.campusequipmentrentalapp.ui.complete

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.campusequipmentrentalapp.R
import com.example.campusequipmentrentalapp.data.EquipmentRepository
import com.example.campusequipmentrentalapp.databinding.FragmentCompleteBinding
import com.example.campusequipmentrentalapp.util.NavKeys

class CompleteFragment : Fragment(R.layout.fragment_complete) {

    private var _binding: FragmentCompleteBinding? = null
    private val binding: FragmentCompleteBinding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCompleteBinding.bind(view)

        val equipmentId = arguments?.getInt(NavKeys.EQUIPMENT_ID, -1) ?: -1
        val applicantName = arguments?.getString(NavKeys.APPLICANT_NAME) ?: "Not specified"
        val studentId = arguments?.getString(NavKeys.STUDENT_ID) ?: "Not specified"
        val purpose = arguments?.getString(NavKeys.PURPOSE) ?: "Not specified"
        val rentalDays = arguments?.getInt(NavKeys.RENTAL_DAYS, 1) ?: 1

        val equipment = EquipmentRepository.findById(equipmentId)

        if (equipment != null) {
            binding.tvCompleteEquipment.text = getString(
                R.string.complete_equipment_format,
                equipment.icon,
                equipment.name
            )
        } else {
            binding.tvCompleteEquipment.text = getString(R.string.unknown_equipment)
        }

        binding.tvCompleteApplicant.text = getString(R.string.complete_applicant_format, applicantName)
        binding.tvCompleteStudentId.text = getString(R.string.complete_student_id_format, studentId)
        binding.tvCompletePeriod.text = getString(R.string.complete_period_format, rentalDays)
        binding.tvCompletePurpose.text = getString(R.string.complete_purpose_format, purpose)

        binding.btnGoList.setOnClickListener {
            findNavController().popBackStack(R.id.equipmentListFragment, false)
        }

        binding.btnGoHome.setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment, false)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

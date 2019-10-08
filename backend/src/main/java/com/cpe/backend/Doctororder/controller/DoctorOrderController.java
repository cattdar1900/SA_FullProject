package com.cpe.backend.Doctororder.controller;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.Doctororder.Model.orderModel;
import com.cpe.backend.Doctororder.entity.DoctorOrder;
import com.cpe.backend.Doctororder.entity.MedicineItem;
import com.cpe.backend.Doctororder.repository.DoctorOrderRepository;
import com.cpe.backend.Doctororder.repository.MedicationTypeRepository;
import com.cpe.backend.Doctororder.repository.MedicineItemRepository;
import com.cpe.backend.Doctororder.repository.MedicineRepository;
import com.cpe.backend.Examination.entity.ExaminationSystem;
import com.cpe.backend.Examination.repository.ExaminationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class DoctorOrderController {

    @Autowired
    private DoctorOrderRepository doctorOrderRepository;
    @Autowired
    private ExaminationRepository examinationRepository;
    @Autowired
    private MedicationTypeRepository medicationTypeRepository;
    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private MedicineItemRepository medicineItemRepository;

    DoctorOrderController(DoctorOrderRepository doctorOrderRepository) {
        this.doctorOrderRepository = doctorOrderRepository;
    }

    @GetMapping("/doctororder")
    public Collection<DoctorOrder> doctororder() {
        return doctorOrderRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/doctororder/{id}")
    public Optional<DoctorOrder> doctororders(@PathVariable Long id) {
        Optional<DoctorOrder> doctororders = doctorOrderRepository.findById(id);
        return doctororders;
    }

    @PostMapping("/postDoctor")
    public DoctorOrder index(@RequestBody orderModel body ) {
        DoctorOrder docOrder = new DoctorOrder();
        //xaminationSystem exam = body.get("examinationId");
        //System.out.println(body.get("examinationId"));
        ExaminationSystem ex = examinationRepository.findById(body.getExaminationId()).get();
        docOrder.setEx(ex);
        docOrder.setDate(new Date());
        

        for(int i = 0 ; i<body.getMedicationTypeIds().length ; i++){
            MedicineItem medI = new MedicineItem();
            medI.setMedicine(medicineRepository.findById(Long.valueOf(body.getMedicineIds()[i]).longValue()));
            medI.setMedicationType(medicationTypeRepository.findById(Long.valueOf(body.getMedicationTypeIds()[i]).longValue()));
            medI.setDoctorOrder(docOrder);
            medicineItemRepository.save(medI);
        }
        DoctorOrder docOrderNew = doctorOrderRepository.save(docOrder);
        return docOrderNew;
    }

    @GetMapping("/ordertable/{id}")
    public Collection<Object[]> getData(@PathVariable Long id){
        System.out.println(id);
        Collection<Object[]> data =  doctorOrderRepository.findByDoctorID(id);
        System.out.println(data);

        return data;
    }

  
   
}
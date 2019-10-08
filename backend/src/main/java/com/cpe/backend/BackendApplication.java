package com.cpe.backend;

import java.text.SimpleDateFormat;
import java.util.stream.Stream;
import java.util.Date;

import com.cpe.backend.Appointment.entity.Department;
import com.cpe.backend.Appointment.entity.TypeCause;
import com.cpe.backend.Appointment.entity.TypeGoing;
import com.cpe.backend.Appointment.repository.DepartmentRepository;
import com.cpe.backend.Appointment.repository.TypeCauseRepository;
import com.cpe.backend.Appointment.repository.TypeGoingRepository;
import com.cpe.backend.Bed.entity.Bed;
import com.cpe.backend.Bed.entity.Nurse;
import com.cpe.backend.Bed.entity.Reservation;
import com.cpe.backend.Bed.repository.BedRepository;
import com.cpe.backend.Bed.repository.NurseRepository;
import com.cpe.backend.Bed.repository.ReservationRepository;
import com.cpe.backend.Discharge.entity.DistributionType;
import com.cpe.backend.Discharge.entity.Selfcare;
import com.cpe.backend.Discharge.entity.Sensorium;
import com.cpe.backend.Discharge.repository.DistributionTypeRepository;
import com.cpe.backend.Discharge.repository.SelfcareRepository;
import com.cpe.backend.Discharge.repository.SensoriumRepository;
import com.cpe.backend.Examination.entity.Doctor;
import com.cpe.backend.Examination.entity.Duration;
import com.cpe.backend.Examination.entity.ExaminationSystem;
import com.cpe.backend.Examination.entity.State;
import com.cpe.backend.Examination.repository.DoctorRepository;
import com.cpe.backend.Examination.repository.DurationRepository;
import com.cpe.backend.Examination.repository.ExaminationRepository;
import com.cpe.backend.Examination.repository.StateRepository;
import com.cpe.backend.Payment.entity.DoctorOrder;
import com.cpe.backend.Payment.entity.Medicine;
import com.cpe.backend.Payment.entity.MedicineItem;
import com.cpe.backend.Payment.entity.PaymentOption;
import com.cpe.backend.Payment.entity.TypeBank;
import com.cpe.backend.Payment.repository.DoctorOrderRepository;
import com.cpe.backend.Payment.repository.MedicineItemRepository;
import com.cpe.backend.Payment.repository.MedicineRepository;
import com.cpe.backend.Payment.repository.PaymentOptionRepository;
import com.cpe.backend.Payment.repository.TypeBankRepository;
import com.cpe.backend.RegisterPatient.entity.Benefit;
import com.cpe.backend.RegisterPatient.entity.Gender;
import com.cpe.backend.RegisterPatient.entity.Patient;
import com.cpe.backend.RegisterPatient.entity.Province;
import com.cpe.backend.RegisterPatient.entity.User;
import com.cpe.backend.RegisterPatient.repository.BenefitRepository;
import com.cpe.backend.RegisterPatient.repository.GenderRepository;
import com.cpe.backend.RegisterPatient.repository.PatientRepository;
import com.cpe.backend.RegisterPatient.repository.ProvinceRepository;
import com.cpe.backend.RegisterPatient.repository.UserRepository;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	ApplicationRunner init(UserRepository userRepo,BenefitRepository repository,
	GenderRepository genderRepository,ProvinceRepository provinceRepository,
	TypeCauseRepository typeCauseRepository, DepartmentRepository departmentRepository,
	TypeGoingRepository typeGoingRepository,SensoriumRepository sensoriumRepository,
	SelfcareRepository selfcareRepository,DistributionTypeRepository distributionTypeRepository,
	StateRepository s,DoctorRepository dr,DurationRepository du,BedRepository bedRepository,NurseRepository nurseRepository,
	PatientRepository patientRepository,MedicineRepository medicineRepository,MedicineItemRepository md,
	DoctorOrderRepository doctorOrderRepository,PaymentOptionRepository paymentoptionRepository,TypeBankRepository typeBankRepository,
	ReservationRepository reservationRepository,ExaminationRepository examinationRepository) {
		return args -> {
			User user1 = new User();
			user1.setId("B5907519");
			user1.setPassword("1500");
			userRepo.save(user1);

			Gender gender1 = new Gender();
			gender1.setName("ชาย");
			gender1.setGenderDescription("ผู้ชาย");
			genderRepository.save(gender1);

			Gender gender2 = new Gender();
			gender2.setName("หญิง");
			gender2.setGenderDescription("ผู้หญิง");
			genderRepository.save(gender2);

			Stream.of("ชัยภูมิ", "นคราชสีมา", "บุรรีรัมย์", "สุรินทร์").forEach(name -> {
				Province provinces = new Province(); // สร้าง Object Customer
				provinces.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
				provinces.setDescription("จังหวัด" +name +" เป็น 1 ในเขต นครชัยบุรินทร์ ");
				provinceRepository.save(provinces); // บันทึก Objcet ชื่อ Customer
			});


			Benefit benefit1 = new Benefit();
			benefit1.setName("สิทธิ 30 บาท");
			benefit1.setBeneDescriptstion("รักษาได้บางโรค จ่ายเงินเพียง 30 บาทเท่านั้น");
			benefit1.setDicount(20);
			repository.save(benefit1);

			Benefit benefit2 = new Benefit();
			benefit2.setName("สิทธิข้าราชการ");
			benefit2.setBeneDescriptstion("รักษาได้บางโรค ต้องเป็นข้าราชการหรือมีครอบครัวเป็นข้าราชการเท่านั้น");
			benefit2.setDicount(20);
			repository.save(benefit2);

			Benefit benefit3 = new Benefit();
			benefit3.setName("สิทธิผู้สูงอายุ");
			benefit3.setBeneDescriptstion("รักษาได้บางโรค ต้องเป็นผู้มีอายุมากกว่าหรือเท่ากับ 60 ปีเท่านั้น");
			benefit3.setDicount(20);
			repository.save(benefit3);

			Benefit benefit4 = new Benefit();
			benefit4.setName("สิทธิประกันสังคม");
			benefit4.setBeneDescriptstion("รักษาได้บางโรค ต้องจ่ายเบี้ยประกันสังคมทุกปี");
			benefit4.setDicount(20);
			repository.save(benefit4);

			Benefit benefit5 = new Benefit();
			benefit5.setName("สิทธินักศึกษา");
			benefit5.setBeneDescriptstion("รักษาได้บางโรคต้องเป็นนักศึกษามหาวิทยาลัยเทคโนโลยีสุรนารีเท่านั้น");
			benefit5.setDicount(20);
			repository.save(benefit5);

			Stream.of("ติดตามอาการ","นอนโรงพยาบาล").forEach(typecauseSelect ->{
				TypeCause typeCause2 = new TypeCause();
				typeCause2.setTypecauseSelect(typecauseSelect);
				typeCauseRepository.save(typeCause2);
			});

			Stream.of("แผนกวิสัญญี","แผนกศัลยกรรม","แผนกกุมารเวชกรรม","แผนกเวชศาสตร์ฟื้นฟู","แผนกอายุรกรรม","แผนกจักษุ","แผนกหู คอ จมูก","แผนกเภสัชกรรม","แผนกจิตเวช","แผนกรังสีกรรม","แผนกผู้ป่วยใน").forEach(departmentlSelect ->{
				Department department = new Department();
				department.setDepartmentlSelect(departmentlSelect);
				departmentRepository.save(department);
			});

			Stream.of("รถยนต์ส่วนบุคคล","รถโรงพยาบาล","รถจักรยานยนต์" , "เดิน").forEach(typegoingSelect ->{
				TypeGoing typeGoing = new TypeGoing();
				typeGoing.setTypegoingSelect(typegoingSelect);
				typeGoingRepository.save(typeGoing);
			});

			Stream.of("รู้สึกตัว", "สับสน", "ไม่รู้สึกตัว").forEach(name -> {
				Sensorium sensorium = new Sensorium(); // สร้าง Object Employee
				sensorium.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Employee
				sensoriumRepository.save(sensorium); // บันทึก Objcet ชื่อ Employee
			});

			Stream.of("ช่วยเหลือตนเองได้", "ช่วยเหลือตนเองได้บางส่วน", "ช่วยเหลือตนเองไม่ได้").forEach(name -> {
				Selfcare selfcare = new Selfcare(); // สร้าง Object Customer
				selfcare.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
				selfcareRepository.save(selfcare); // บันทึก Objcet ชื่อ Customer
			});

			Stream.of("แพทย์อนุญาต", "หนีกลับ", "ถึงแก่กรรม", "ส่งต่อ").forEach(name -> {
				DistributionType distributionType = new DistributionType(); // สร้าง Object Video
				distributionType.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Video
				distributionTypeRepository.save(distributionType); // บันทึก Objcet ชื่อ Video
			});

			Stream.of("ดีขึ้น", "แย่ลง", "คงที่").forEach(name -> {
				State state = new State();
				state.setName(name);
				s.save(state);
			});

			Stream.of("นพ. เอ", "นพ. บี", "พญ. ซี").forEach(name -> {
                Doctor doctor = new Doctor();
                doctor.setName(name);
                dr.save(doctor);
			});
			Stream.of("เช้า", "เที่ยง", "เย็น", "ดึก").forEach(name -> {
                Duration duration = new Duration();
                duration.setName(name);
                du.save(duration);
			});


			Stream.of("ชาย , ห้องเตียงรวม , 500", "ชาย , ห้องพิเศษ , 1000" , "หญิง , ห้องเตียงรวม , 500" , "หญิง , ห้องพิเศษ , 1000").forEach(type -> {
				Bed bed = new Bed(); // สร้าง Object Customer
				bed.setName(type); // set ชื่อ (name) ให้ Object ชื่อ Customer
				if (type == "ชาย , ห้องเตียงรวม , 500") 
				bed.setPrice(500);
				else if (type == "ชาย , ห้องพิเศษ , 1000")
				bed.setPrice(1000);
				else if (type == "หญิง , ห้องเตียงรวม , 500")
				bed.setPrice(500);
				else if (type == "หญิง , ห้องพิเศษ , 1000")
				bed.setPrice(1000);
				bedRepository.save(bed); // บันทึก Objcet ชื่อ Customer
			});



			Stream.of("ศรัญญาภรณ์ สมานราษฎร์", "ปิย์รดา แก้วไพฑูรย์", "รุ่งนภาพร พลองพิมาย" , "นันทิกา พูนพิน").forEach(nu -> {
				Nurse nurse = new Nurse(); // สร้าง Object Customer
				nurse.setName(nu); // set ชื่อ (name) ให้ Object ชื่อ Customer
				nurseRepository.save(nurse); // บันทึก Objcet ชื่อ Customer
			});

			Patient p1 = new Patient();
			p1.setNationalID((long) 1234);
			p1.setName("เต๋าไงจะใครละ");
			patientRepository.save(p1);

			Patient p2 = new Patient();
			p2.setNationalID((long) 5678);
			p2.setName("เตอร์เอง");
			patientRepository.save(p2);

			ExaminationSystem ex = new ExaminationSystem();
			ex.setPatient(p1);
			examinationRepository.save(ex);

			ExaminationSystem ex2 = new ExaminationSystem();
			ex2.setPatient(p2);
			examinationRepository.save(ex2);

			Medicine medicine1 = new Medicine(); 
					medicine1.setName("ยาแก้ไอ"); // set ชื่อ (name) ให้ Object ชื่อ Employee
					medicine1.setPrice(20L);
					medicineRepository.save(medicine1);
				
				
					Medicine medicine2 = new Medicine(); 
					medicine2.setName("ยาลดไข้"); // set ชื่อ (name) ให้ Object ชื่อ Employee
					medicine2.setPrice(30L);
					medicineRepository.save(medicine2);
				
				
					Medicine medicine3 = new Medicine(); 
					medicine3.setName("ยาแก้แพ้"); // set ชื่อ (name) ให้ Object ชื่อ Employee
					medicine3.setPrice(40L);
					medicineRepository.save(medicine3);

			DoctorOrder doctorOrder = new DoctorOrder();
			String sDate1="10/4/2019";  
			Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);									
			doctorOrder.setStartDate(date1);
			doctorOrder.setEx(ex);
			



			DoctorOrder doctorOrder2 = new DoctorOrder();
			String sDate2="11/4/2019";
			Date date2= new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);
			doctorOrder2.setStartDate(date2);	
			doctorOrder2.setEx(ex2);
			
			doctorOrderRepository.save(doctorOrder2);
			doctorOrderRepository.save(doctorOrder);	

			MedicineItem  mid1 = new MedicineItem();
			mid1.setMedicine(medicine1);
			mid1.setDr(doctorOrder2);
			md.save(mid1);

			MedicineItem  mid2 = new MedicineItem();
			mid2.setMedicine(medicine2);
			mid2.setDr(doctorOrder2);
			md.save(mid2);

			MedicineItem  mid3 = new MedicineItem();
			mid3.setMedicine(medicine3);
			mid3.setDr(doctorOrder2);
			md.save(mid3);

			

			MedicineItem  mid5 = new MedicineItem();
			mid5.setMedicine(medicine2);
			mid5.setDr(doctorOrder);
			md.save(mid5);

			MedicineItem  mid6 = new MedicineItem();
			mid6.setMedicine(medicine3);
			mid6.setDr(doctorOrder);
			md.save(mid6);

			Stream.of("ชำระเงินสด","ชำระผ่านบัตร").forEach(name -> {
				PaymentOption paymentoption = new PaymentOption(); // สร้าง Object Employee
				paymentoption.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Employee
				paymentoptionRepository.save(paymentoption); // บันทึก Objcet ชื่อ Employee
			});
			
			Stream.of("กสิกร","กรุงไทย","ไทยพาณิชย์").forEach(name -> {
				TypeBank typeBank = new TypeBank(); // สร้าง Object Employee
				typeBank.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Employee
				typeBankRepository.save(typeBank); // บันทึก Objcet ชื่อ Employee
			});

			

			Bed bed = new Bed(); // สร้าง Object Customer
			bed.setName("ห้องพิเศษโคตร ๆ");
			bed.setPrice(900);
			bedRepository.save(bed);

			Bed bed1 = new Bed(); // สร้าง Object Customer
			bed1.setName("ห้องพิเศษโคตร ๆๆๆๆ");
			bed1.setPrice(5000);
			bedRepository.save(bed1);

			String sDate3="2/4/2019";  
			Date date3=new SimpleDateFormat("dd/MM/yyyy").parse(sDate3);									
			doctorOrder.setStartDate(date3);
			Reservation r1 = new Reservation();
			r1.setPatient(p1);
			r1.setReservDate(date2);
			r1.setBed(bed);
			reservationRepository.save(r1);

			String sDate4="10/4/2019";  
			Date date4=new SimpleDateFormat("dd/MM/yyyy").parse(sDate4);									
			doctorOrder.setStartDate(date3);
			Reservation r2 = new Reservation();
			r2.setPatient(p2);
			r2.setReservDate(date4);
			r2.setBed(bed1);
			reservationRepository.save(r2);



			


			

			

			
		};
	}

}

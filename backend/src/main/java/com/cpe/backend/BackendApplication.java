package com.cpe.backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

import com.cpe.backend.entity.Benefit;
import com.cpe.backend.entity.Gender;
import com.cpe.backend.entity.Province;
import com.cpe.backend.repository.BenefitRepository;
import com.cpe.backend.repository.GenderRepository;
import com.cpe.backend.repository.ProvinceRepository;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	ApplicationRunner init(BenefitRepository repository,GenderRepository genderRepository,ProvinceRepository provinceRepository) {
		return args -> {
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

			
		};
	}

}

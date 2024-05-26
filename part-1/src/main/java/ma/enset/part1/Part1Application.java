package ma.enset.part1;

import ma.enset.part1.entities.Patient;
import ma.enset.part1.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;

@SpringBootApplication
public class Part1Application {

    public static void main(String[] args) {
        SpringApplication.run(Part1Application.class, args);
    }




    @Bean
    public CommandLineRunner start(PatientRepository patientRepository){

        return args -> {

            SimpleDateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY");

            patientRepository.save(
                    Patient.builder()
                            .name("patient-1")
                            .birthDate(dateFormat.parse("01-12-1998"))
                            .isSeek(true)
                            .score(2000)
                            .build()
            );

            patientRepository.save(
                    Patient.builder()
                            .name("patient-2")
                            .birthDate(dateFormat.parse("01-11-1968"))
                            .isSeek(true)
                            .score(4000)
                            .build()
            );
            patientRepository.save(
                    Patient.builder()
                            .name("patient-3")
                            .birthDate(dateFormat.parse("24-08-2015"))
                            .isSeek(false)
                            .score(100)
                            .build()
            );
            patientRepository.save(
                    Patient.builder()
                            .name("patient-4")
                            .birthDate(dateFormat.parse("21-01-2002"))
                            .isSeek(true)
                            .score(1000)
                            .build()
            );

            System.out.println("---------------------------- RESULTS ---------------------------------");
            patientRepository.findAll()
                    .forEach(System.out::println);
        };

    }

}

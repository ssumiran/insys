package u.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import u.student.entity.Student;
import u.student.repository.StudentRepository;
import u.student.request.CreateStudentRequest;
import u.student.response.AddressResponse;
import u.student.response.StudentResponse;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	WebClient webClient;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		
		student.setAddressId(createStudentRequest.getAddressId());
		student = studentRepository.save(student);

		StudentResponse studentResponse = new StudentResponse(student);
		
		//studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		return studentResponse;
	}
	
	public StudentResponse getById (long id) {
		Student student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student);
		System.out.println("uri : "+webClient.get().uri("/getById/" + student.getAddressId()).toString());
		//studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		
		return studentResponse;
	}
	
	public AddressResponse getAddressById (long addressId) {
		Mono<AddressResponse> addressResponse = 
				webClient.get().uri("/getById/" + addressId)
		.retrieve().bodyToMono(AddressResponse.class);
		
		return addressResponse.block();
	}
}


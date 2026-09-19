package u.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import u.student.entity.Student;
import u.student.repository.StudentRepository;
import u.student.request.CreateStudentRequest;
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

		return new StudentResponse(student);
	}
	
	public StudentResponse getById (long id) {
		return new StudentResponse(studentRepository.findById(id).get());
	}
}


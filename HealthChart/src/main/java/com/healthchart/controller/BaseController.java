package com.healthchart.controller;

import com.healthchart.model.Patient;
import com.healthchart.service.PatientService;
import com.healthchart.service.TestComponent;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.security.krb5.internal.PAData;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
public class BaseController {

	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
//	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	@Autowired
	private TestComponent testComponent;

//	@Autowired
//	private PatientService service;

//	@Autowired
//	MessageSource messageSource;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", ++counter);
//		logger.debug("[welcome] counter : {}", counter);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {

		model.addAttribute("message", "Welcome " + name + " " + testComponent.getMyName());
		model.addAttribute("counter", ++counter);
//		logger.debug("[welcomeName] counter : {}", counter);
		return VIEW_INDEX;
	}

//	/*
//	 * This method will list all existing employees.
//	 */
//	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
//	public String listEmployees(ModelMap model) {
//
//		List<Patient> employees = service.findAllPatients();
//		model.addAttribute("patients", employees);
//		return "allpatients";
//	}
//
//	/*
//	 * This method will provide the medium to add a new employee.
//	 */
//	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
//	public String newPatient(ModelMap model) {
//		Patient patient = new Patient();
//		model.addAttribute("patient", patient);
//		model.addAttribute("edit", false);
//		return "registration";
//	}
//
//	/*
//	 * This method will be called on form submission, handling POST request for
//	 * saving employee in database. It also validates the user input
//	 */
//	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
//	public String savePatient(@Valid Patient patient, BindingResult result,
//							  ModelMap model) {
//
//		if (result.hasErrors()) {
//			return "registration";
//		}
//
//		/*
//		 * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation
//		 * and applying it on field [ssn] of Model class [Employee].
//		 *
//		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
//		 * framework as well while still using internationalized messages.
//		 *
//		 */
//		if(!service.isPatientNameUnique(patient.getId(), patient.getFirstName() + " " + patient.getLastName())){
//			FieldError ssnError =new FieldError("patient","name",messageSource.getMessage("non.unique.name", new String[]{patient.getFirstName() + " " + patient.getLastName()}, Locale.getDefault()));
//			result.addError(ssnError);
//			return "registration";
//		}
//
//		service.savePatient(patient);
//
//		model.addAttribute("success", "Patient " + patient.getFirstName() + " " + patient.getLastName() + " registered successfully");
//		return "success";
//	}

}
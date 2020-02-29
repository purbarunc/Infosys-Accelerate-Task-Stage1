package com.infosys.accelerate.controller;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.accelerate.domain.Cd;
import com.infosys.accelerate.httpresponse.ErrorResponse;
import com.infosys.accelerate.httpresponse.HttpResponse;
import com.infosys.accelerate.utils.CdXmlParser;

@RestController
@RequestMapping(value = "/cds")
public class CdController {
	@Autowired
	private CdXmlParser cdXmlParser;

	@GetMapping
	public ResponseEntity<?> getAllCds() {
		try {
			return new ResponseEntity<List<Cd>>(cdXmlParser.parse(), HttpStatus.OK);
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
			return new ResponseEntity<HttpResponse>(new ErrorResponse("Error parsing XML File"),
					HttpStatus.EXPECTATION_FAILED);
		}
	}
}

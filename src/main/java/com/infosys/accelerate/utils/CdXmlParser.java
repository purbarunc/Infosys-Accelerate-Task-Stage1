package com.infosys.accelerate.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.infosys.accelerate.domain.Cd;
import com.infosys.accelerate.domain.ListOfCd;

@Service
public class CdXmlParser {
	public List<Cd> parse() throws JAXBException, IOException {
		File file = new ClassPathResource("CD.xml").getFile();
		JAXBContext jaxbContext = JAXBContext.newInstance(ListOfCd.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		ListOfCd cd = (ListOfCd) jaxbUnmarshaller.unmarshal(file);
		ArrayList<Cd> cds = cd.getCdList();
		return cds;
	}
}

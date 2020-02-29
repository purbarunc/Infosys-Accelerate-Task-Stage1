package com.infosys.accelerate.domain;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "listOfCD")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListOfCd {
	@XmlElement(name = "CD")
	ArrayList<Cd> cdList;

	public ArrayList<Cd> getCdList() {
		return cdList;
	}

	public void setCdList(ArrayList<Cd> cdList) {
		this.cdList = cdList;
	}
}

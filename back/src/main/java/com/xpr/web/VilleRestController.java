package com.xpr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.xpr.dao.VilleRepository;
import com.xpr.dao.annotation.XprRole;
import com.xpr.entities.Ville;


@RestController
@RequestMapping(path="/ville")
public class VilleRestController {
	
	@Autowired
	private VilleRepository villeRepository;
	
	@RequestMapping(value="/getAllVilles",method=RequestMethod.GET)
	@XprRole(role = XprRole.Role.LIST, view= "ModelViews.SelectView")
	public List<Ville> getAllVilles() {
		return villeRepository.getAllVilles();
	}


}

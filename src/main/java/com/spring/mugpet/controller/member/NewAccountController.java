package com.spring.mugpet.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.service.MemberService;
import com.spring.mugpet.service.PetService;

@Controller
@Transactional
public class NewAccountController {
	
	@Autowired
	private MemberService memberService;
	@Transactional
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	@Autowired
	private PetService petService;
	@Transactional
	public void setPetberService(PetService petService) {
		this.petService = petService;
	}

	
	@ModelAttribute("registerForm")
	public RegisterForm setRegisterForm() {
			return new RegisterForm();
	}
	

	@RequestMapping(value="/member/register", method=RequestMethod.GET)
	public String register() {
		return "tile/member/registerForm";
	}
	
	
	@RequestMapping(value="/member/register", method=RequestMethod.POST)
	public String register(@ModelAttribute("registerForm")RegisterForm registerForm,
									BindingResult result,
									HttpServletRequest request,
									@RequestPart(value="imgFile",required=false) MultipartFile file) throws Exception {
	
		System.out.println(registerForm);
		
		MemberInfo newAccount = registerForm.getAccount();
		request.getSession().setAttribute("newAccount", newAccount);
		
		if(file!=null) {
	
			memberService.creatAccount(newAccount,file);
		}
		else {
			memberService.creatAccountWithoutImgFile(newAccount);
		}
		
		return "redirect:/pet/petRegister";
		
	}
	
	
	@ModelAttribute("petRegisterForm")
	public PetRegisterForm formBacking() {
		return new PetRegisterForm();
	}

	@RequestMapping(value="/pet/petRegister", method=RequestMethod.GET)
	public String register(HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberInfo newAccount = (MemberInfo) session.getAttribute("newAccount");
		System.out.println(newAccount);
		return "tile/member/petRegisterForm";
	}
	
	@RequestMapping(value="/pet/petRegister", method = RequestMethod.POST)
	public String registerPet(@ModelAttribute("petRegisterForm")PetRegisterForm petRegisterForm,
							HttpServletRequest request) throws Exception {
		
	
		HttpSession session = request.getSession();
		MemberInfo newAccount = (MemberInfo) session.getAttribute("newAccount");
		System.out.println(newAccount);
		System.out.println(petRegisterForm.getPet().getName());
		petRegisterForm.getPet().setU_id(newAccount.getU_id());
		petRegisterForm.getPet().setSpe_id(Integer.parseInt(request.getParameter("species")));
		petService.addPet(petRegisterForm.getPet());
		
		return "redirect:/member/login";

	}
	

}

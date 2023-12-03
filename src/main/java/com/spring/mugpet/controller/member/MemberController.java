package com.spring.mugpet.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mugpet.controller.item.ItemController;
import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.domain.Pet;
import com.spring.mugpet.service.MemberService;
import com.spring.mugpet.service.PetService;

@Controller
@RequestMapping("/member")
@SessionAttributes("userSession")
public class MemberController {
	
	
	@Autowired
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Autowired
	private ItemController itemController;
	public void setItemController(ItemController itemController) {
		this.itemController = itemController;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(HttpSession session, @RequestParam(value="item_id", defaultValue="0")int item_id, ModelMap model) {
		MemberInfo userSession = (MemberInfo) session.getAttribute("userSession");
		System.out.println(userSession + "," + userSession.getU_id() +"," + userSession.getName());
		model.put("item_id", item_id);
		return "tile/member/loginForm";

	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,
						@RequestParam("email") String email,
						@RequestParam("pwd") String pwd,
						@RequestParam(value="forwardAction", required=false) String forwardAction,
						@RequestParam(value="item_id") int item_id,
						Model model) throws Exception {
		
		MemberInfo userSession = memberService.login(email,pwd);
		model.addAttribute("userSession", userSession);
		
		if(userSession==null) {
			return new ModelAndView("error", "message", 
					"Invalid username or password.  Signon failed.");
		}
		else {
			if(forwardAction != null) {
				return new ModelAndView("redirect:" + forwardAction);
			}
			else {
				if (item_id != 0) {
					ModelAndView mav = itemController.viewItem(userSession, item_id);
					return mav;
				} else {
					return new ModelAndView("redirect:/main");
				}
			}
		}
	}
	
	@ModelAttribute("modifyMemberInfoForm")
	public ModifyMemberInfoForm setmodifyMemberInfoForm(HttpSession session) {
			MemberInfo userSession = (MemberInfo) session.getAttribute("userSession");
			return new ModifyMemberInfoForm(userSession);
	}
	@RequestMapping(value="/modifyMemberInfo",method=RequestMethod.GET)
	public String modifyMemberInfo() {
	
		return "tile/member/modifyMemberInfo";
	}
	@RequestMapping(value="/modifyMemberInfo",method=RequestMethod.POST)
	public String modifyMemberInfo(@ModelAttribute("modifyMemberInfoForm")ModifyMemberInfoForm modifyMemberInfoForm,
						RedirectAttributes rttr,HttpSession session) {
		
		if(!modifyMemberInfoForm.getAccount().getPwd().equals(modifyMemberInfoForm.getRepeatedPassword())) {
			rttr.addFlashAttribute("msg", "비밀번호를 다시 확인해주세요");
			return "redirect:/member/modifyMemberInfo";
		}
		else {
			memberService.updateAccount(modifyMemberInfoForm);
			session.setAttribute("userSession", modifyMemberInfoForm.getAccount());
		}
		
		return "redirect:/myPage/myHome";
		
	
	}
}

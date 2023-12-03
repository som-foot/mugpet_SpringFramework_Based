package com.spring.mugpet.controller.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.domain.Pet;
import com.spring.mugpet.domain.Reply;
import com.spring.mugpet.service.MemberServiceImpl;
import com.spring.mugpet.service.PetService;
import com.spring.mugpet.service.ReplyServiceImpl;

@Controller
@SessionAttributes("userSession")
public class ReplyController {
	@Autowired
	private ReplyServiceImpl replyService;
	
	@Autowired
	private MemberServiceImpl memberService;
	
	@Autowired
	private PetService petService;
	
	@RequestMapping(value = "/community/replyInsert")
	public String comSubmit(NewReplyCommand replyCommand, @ModelAttribute("userSession") MemberInfo userSession) {
		if(replyCommand.getContent() == "") {
			System.out.println("댓글 내용 입력 X");
			return "redirect:/community/view?com_id=" + replyCommand.getCom_id();
		}
		
		replyCommand.setU_id(userSession.getU_id());
		replyService.insertComReply(replyCommand);
		
		//기존 view로 이동
		return "redirect:/community/view?com_id=" + replyCommand.getCom_id();
	}
	
	@RequestMapping(value = "/usedGoods/replyInsert")
	public String goodsSubmit(NewReplyCommand replyCommand, @ModelAttribute("userSession") MemberInfo userSession) {
		if(replyCommand.getContent() == "") {
			System.out.println("댓글 내용 입력 X");
			return "redirect:/usedGoods/view?g_id=" + replyCommand.getG_id();
		}
		
		replyCommand.setU_id(userSession.getU_id());
		replyService.insertGoodsReply(replyCommand);
		
		//기존 view로 이동
		return "redirect:/usedGoods/view?g_id=" + replyCommand.getG_id();
	}
	
	@RequestMapping("/community/replyDelete")
	public String deleteComReply(@RequestParam(value = "rp_id") int rp_id, @RequestParam(value = "com_id") int com_id) {
		//댓글 삭제
		replyService.deleteComReply(rp_id, com_id);
		
		//기존 view로 이동
		return "redirect:/community/view?com_id=" + com_id;
	}
	
	@RequestMapping("/usedGoods/replyDelete")
	public String deleteGoodsReply(@RequestParam(value = "rp_id") int rp_id, @RequestParam(value = "g_id") int g_id) {
		//댓글 삭제
		replyService.deleteGoodsReply(rp_id, g_id);
		
		//기존 view로 이동
		return "redirect:/usedGoods/view?g_id=" + g_id;
	}
	
	@RequestMapping("/myPage/myReplyList")
	public String getMyReplyList(@ModelAttribute("userSession") MemberInfo userSession, Model model) {
		//내가 쓴 댓글 목록
		int u_id = userSession.getU_id();
		String nickname = memberService.getNickNameByU_Id(u_id);
		Pet pet = petService.getPetByU_id(u_id);
		String petName = pet.getName();
		
		List<Reply> replyList = replyService.getMyReplyList(u_id);
		
		model.addAttribute("replyList", replyList);
		model.addAttribute("nickname", nickname);
		model.addAttribute("petName", petName);
		
		return "tile/myPage/myReplyList";
	}
}
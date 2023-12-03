package com.spring.mugpet.controller.community;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.spring.mugpet.domain.Community;
import com.spring.mugpet.domain.MemberInfo;
import com.spring.mugpet.domain.Pet;
import com.spring.mugpet.domain.Reply;
import com.spring.mugpet.service.CommunityFormValidator;
import com.spring.mugpet.service.CommunityServiceImpl;
import com.spring.mugpet.service.MemberServiceImpl;
import com.spring.mugpet.service.PetService;
import com.spring.mugpet.service.ReplyServiceImpl;

@Controller
@SessionAttributes("userSession")
@RequestMapping(method=RequestMethod.GET)
public class CommunityController {
	
	@Autowired
	private CommunityServiceImpl comService;
	
	@Autowired
	private ReplyServiceImpl replyService;
	
	@Autowired
	private MemberServiceImpl memberService;
	
	@Autowired
	private PetService petService;
	
	@Autowired
	private CommunityFormValidator comValidator;
	
	@RequestMapping("/community/view")
	public String getCom(@RequestParam(value = "com_id") int com_id, @ModelAttribute("userSession")MemberInfo userSession, Model model) {
		//게시글 상세보기
		
		int spe_id = 1;
		String petName = null;
		
		Community com = null;
		com = comService.getCom(com_id);
		
		//해당 게시글에 작성된 댓글 목록 가져오기
		List<Reply> replyList = replyService.getCommunityReplyList(com_id);
		ArrayList<String> rp_nicknameList = new ArrayList<String>();
		
		int u_id = comService.getU_IdByCommunity(com_id);
		String nickname = memberService.getNickNameByU_Id(u_id);
		
		if(userSession.getU_id() != 0) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			
			spe_id = pet.getSpe_id();
			System.out.println(">>>>>>spe_id : " + spe_id);
			petName = pet.getName();
			System.out.println(">>>>>>>petName : " + petName);
		}
		
		//댓글을 작성한 사용자 닉네임 가져오기
		for(Reply reply : replyList) {
			int rp_id = reply.getRp_id();
			int rp_u_id = replyService.getU_IdByCommunityReply(com_id, rp_id);
			String rp_nickname = memberService.getNickNameByU_Id(rp_u_id);
			rp_nicknameList.add(rp_nickname);
		}
		
		System.out.println("com_id: " + com.getCom_id());
		System.out.println("userSession의  u_id: " + userSession.getU_id());
		
		model.addAttribute("community", com);
		model.addAttribute("replyList", replyList);
		model.addAttribute("nickname", nickname);
		model.addAttribute("rp_nicknameList", rp_nicknameList);
		model.addAttribute("userSession", userSession);
		model.addAttribute("petName", petName);
		model.addAttribute("spe", petService.getSpeName(spe_id));
		model.addAttribute("spe_id", spe_id);
		
		return "tiless/community/view";
	}
	
	@RequestMapping("/community/communityList")
	public String getComList(Model model, @ModelAttribute("userSession")MemberInfo userSession) {
		//게시글 목록 보기
		
		int spe_id = 1;
		String petName = null;
		List<Community> comList = comService.getComList();
		
		if(userSession.getU_id() != 0) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			
			spe_id = pet.getSpe_id();
			System.out.println(">>>>>>spe_id : " + spe_id);
			petName = pet.getName();
			System.out.println(">>>>>>>petName : " + petName);
		
		}
		
		ArrayList<String> nicknameList = new ArrayList<String>();
		
		//게시글을 작성한 사용자 닉네임 가져오기
		for(Community coms : comList) {
			int com_id = coms.getCom_id();
			int u_id = comService.getU_IdByCommunity(com_id);
			String nickname = memberService.getNickNameByU_Id(u_id);
			nicknameList.add(nickname);
		}
		
		for(Community com : comList) {
			System.out.println(com.getTitle());
			System.out.println(com.getCom_id());
		}
		
		model.addAttribute("comList", comList);
		model.addAttribute("petName", petName);
		model.addAttribute("spe", petService.getSpeName(spe_id));
		model.addAttribute("nicknameList", nicknameList);
		model.addAttribute("spe_id", spe_id);
		
		return "tiless/community/communityList";
	}
	
	@RequestMapping("/myPage/myCommunityList")
	public String getMemberComList(Model model, @ModelAttribute("userSession") MemberInfo userSession) {
		//본인이 쓴 게시글 목록 보기
		int u_id = userSession.getU_id();
		List<Community> myComList = comService.getMemberComList(u_id);
		String nickname = memberService.getNickNameByU_Id(u_id);
		
		int spe_id = 1;
		String petName = null;
		
		if(userSession.getU_id() != 0) {
			Pet pet = petService.getPetByU_id(userSession.getU_id());
			
			spe_id = pet.getSpe_id();
			System.out.println(">>>>>>spe_id : " + spe_id);
			petName = pet.getName();
			System.out.println(">>>>>>>petName : " + petName);
		
		}
		
		model.addAttribute("myComList", myComList);
		model.addAttribute("nickname", nickname);
		model.addAttribute("petName", petName);
		model.addAttribute("spe", petService.getSpeName(spe_id));
		model.addAttribute("spe_id", spe_id);
	
		return "tile/myPage/myCommunityList";
	}
	
	//해당 게시글에 작성된 모든 댓글을 삭제 후 게시글 삭제
	@RequestMapping("/community/delete")
	public String deleteCom(@RequestParam(value = "com_id") int com_id) {
		//게시글 삭제
		replyService.deleteComAllReply(com_id);
		comService.deleteCom(com_id);
		
		//게시글 목록 view로 이동
		return "redirect:/community/communityList";
	}
	
	//글 수정 버튼 클릭시, 수정 폼으로 이동
	@RequestMapping(value = "/community/updateForm", method = RequestMethod.GET)
	public String updateForm(Model model, @RequestParam("com_id") int com_id) {
		Community com = null;
		com = comService.getCom(com_id);
		
		model.addAttribute("community", com);
		
		return "/community/updateForm";
	}
	
	//수정 폼에서 수정 완료 버튼 클릭시, 해당 글과 관련된 내용을 db에 수정해 저장 후 상세보기 페이지로 이동
	@RequestMapping(value = "/community/update", method = RequestMethod.POST)
	public String updateSubmit(@Validated NewCommunityCommand comCommand, BindingResult result, HttpServletRequest request,
								@RequestPart(value="imgFile", required=false) MultipartFile file, Model model, @ModelAttribute("userSession") MemberInfo userSession) throws Exception {
		comValidator.validate(comCommand, result);
		
		if(result.hasErrors()) {
			Community com = comService.getCom(comCommand.getCom_id());
			model.addAttribute("community", com);
			
			return "/community/updateForm";
		}
		
		comCommand.setU_id(userSession.getU_id());
		
		if(file != null){
			comService.updateCom(comCommand, file);
		}else {
			comService.updateComWithoutImgFile(comCommand);
		}
		
		//에러 확인
		showErrors(result);
		
		//수정된 view로 이동
		return "redirect:/community/view?com_id=" + comCommand.getCom_id();
	}
	
	//글 작성 버튼 누르면 폼으로 이동
	@RequestMapping(value = "/community/writeForm", method = RequestMethod.GET)
	public String form(@ModelAttribute("userSession") MemberInfo userSession) {
		return "/community/writeForm";
	}
	
	//폼에서 작성 완료 버튼을 누르면 해당 글과 관련된 내용을 db에 저장 후 s상세보기 페이지로 이동
	@RequestMapping(value = "/community/write", method = RequestMethod.POST)
	public String submit(@Validated NewCommunityCommand comCommand, BindingResult result, HttpServletRequest request,
						@RequestPart(value="imgFile", required=false) MultipartFile file, @ModelAttribute("userSession") MemberInfo userSession) throws Exception {
		comValidator.validate(comCommand, result);
		
		if(result.hasErrors()) {
			return "/community/writeForm";
		}
		
		comCommand.setU_id(userSession.getU_id());
		
		if(file != null) {
			comService.insertCom(comCommand, file);
		}else {
			comService.insertComWithoutImgFile(comCommand);
		}
		
		//에러 확인
		showErrors(result);
	
		//작성된 view로 이동
		return "redirect:/community/view?com_id=" + comCommand.getCom_id();		
	}
	
	@RequestMapping(value = "/community/likes")
	public String updateComLikesCnt(@RequestParam("com_id") int com_id, Model model) {
		//좋아요 수
		comService.updateComLikesCnt(com_id, 1);
		
		//기존 view로 이동
		return "redirect:/community/view?com_id=" + com_id;
	}
	
	public void showErrors(Errors errors) {
		if(errors.hasErrors()) {
			System.out.println("에러 개수: " + errors.getErrorCount());
			System.out.println("\t[filed]\t[code]");
			List<FieldError> errList = errors.getFieldErrors();
			
			for(FieldError err : errList) {
				System.out.println("\t " + err.getField() + "\t|" + err.getCode());
			}
		}else {
			System.out.println("에러 없음");
		}
	}
}
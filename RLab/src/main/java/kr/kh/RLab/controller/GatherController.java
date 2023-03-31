package kr.kh.RLab.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.RLab.pagination.Criteria;
import kr.kh.RLab.pagination.PageMaker;
import kr.kh.RLab.service.GatherService;
import kr.kh.RLab.vo.FileVO;
import kr.kh.RLab.vo.GatherVO;
import kr.kh.RLab.vo.MemberVO;
import kr.kh.RLab.vo.RegionVO;
import kr.kh.RLab.vo.StudyVO;
import kr.kh.RLab.vo.TagRegisterVO;
import kr.kh.RLab.vo.TagVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/gather")
public class GatherController {

	private final GatherService gatherService;

	
	//스터디 생성
	@GetMapping("/insertstudy")
	public ModelAndView studyInsert(ModelAndView mv,HttpServletRequest request) {
		MemberVO member = (MemberVO)request.getSession().getAttribute("user");
	    mv.setViewName("/gather/insertstudy");
	    return mv;
	}
	@PostMapping("/insertstudy")
	public ModelAndView studyInsertPost(ModelAndView mv,StudyVO study,HttpServletRequest request,RegionVO region,MultipartFile [] files,
			FileVO file,TagVO tag,TagRegisterVO tagRegister) {
		MemberVO member = (MemberVO)request.getSession().getAttribute("user");
		boolean res = gatherService.insertStudy(study,member,region,files,file,tag,tagRegister);
		
		mv.setViewName("/gather/insertgather");
		return mv;
	}
	
	//모집글 생성
	@GetMapping("/insertgather")
	public ModelAndView gatherInsert(ModelAndView mv,HttpServletRequest request) {
		MemberVO member = (MemberVO)request.getSession().getAttribute("user");
		ArrayList<StudyVO> list = gatherService.selectStudyAll();
		mv.addObject("studies",list);
		mv.setViewName("/gather/list");
	    return mv;
	}
	
	@PostMapping("/insertgather")
	public ModelAndView gatherInsertPost(ModelAndView mv,HttpServletRequest request,GatherVO gather,StudyVO study) {
		MemberVO member = (MemberVO)request.getSession().getAttribute("user");
		boolean res = gatherService.insertGather(member,gather,study);
	    mv.setViewName("/gather/detail");
	    return mv;
	}
	
	//게시글 리스트보기
	@GetMapping("/list")
	public ModelAndView mainlistgather(ModelAndView mv) {
		ArrayList<StudyVO> stList = gatherService.selectStudyAll();
		ArrayList<FileVO> fileList = gatherService.selectFileList();
		ArrayList<TagRegisterVO> tagList = gatherService.selectTagList();
		mv.addObject("stList",stList);
		mv.addObject("tagList",tagList);
		mv.setViewName("/gather/list");
	    return mv;
	}
	
//	@GetMapping("/gather/list")
//	public ModelAndView gatherSearch(ModelAndView mv,Criteria cri) {
//		ArrayList<StudyVO> stdList = gatherService.getBoardList(cri);
//		//페이지네이션
//		int totalCount = gatherService.getBoardTotalCount(cri);
//		PageMaker pm = new PageMaker(totalCount,9,cri);//한 페이지의 게시글 개수를 3개로 
//		mv.addObject("stdList",stdList);
//		mv.addObject("pm",pm);
//		mv.setViewName("/gather/list");
//	    return mv;
//	}

		
	//모집글 상세보기
	@GetMapping("/detail/{ga_num}")
	public ModelAndView gatherDetail(ModelAndView mv,@PathVariable int ga_num) {
		GatherVO gather = gatherService.getGather(ga_num);
		mv.addObject("ga",gather);
		mv.setViewName("/gather/detail");
	    return mv;
	}
	
	
	
	
}